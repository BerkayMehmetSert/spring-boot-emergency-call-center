package com.bms.emergencycallcenter.service;

import com.bms.emergencycallcenter.dto.CityDto;
import com.bms.emergencycallcenter.dto.converter.CityDtoConverter;
import com.bms.emergencycallcenter.exception.CityAlreadyExistException;
import com.bms.emergencycallcenter.exception.CityNotFoundException;
import com.bms.emergencycallcenter.helper.message.BusinessMessage;
import com.bms.emergencycallcenter.helper.message.LogMessage;
import com.bms.emergencycallcenter.model.City;
import com.bms.emergencycallcenter.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CityService {
    private final CityRepository cityRepository;
    private final CountryService countryService;
    private final CityDtoConverter converter;
    private static final Logger logger = LoggerFactory.getLogger(CityService.class);

    public CityService(CityRepository cityRepository,
                       CountryService countryService,
                       CityDtoConverter converter) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
        this.converter = converter;
    }

    public void createCity(final String name, final String countryId) {
        checkIfCityExists(name);

        City city = new City(
                name,
                countryService.getCountryById(countryId)
        );

        cityRepository.save(city);
        logger.info(LogMessage.City.CITY_CREATED + city.getId());
    }

    public void updateCityName(final String id, final String name) {
        City city = getCityById(id);

        if (!city.getName().equalsIgnoreCase(name)) {
            checkIfCityExists(name);
        }
        City updatedCity = new City(
                city.getId(),
                name,
                city.getCountry(),
                city.getCalls()
        );

        cityRepository.save(updatedCity);
        logger.info(LogMessage.City.CITY_UPDATED + city.getId());
    }

    public void deleteCity(final String id) {
        cityRepository.delete(getCityById(id));
        logger.info(LogMessage.City.CITY_DELETED + id);
    }

    public CityDto findCityByName(final String name) {
        City city = cityRepository.findByNameIgnoreCase(name).orElseThrow(() -> {
            logger.error(LogMessage.City.CITY_NOT_FOUND_BY_NAME + name);
            throw new CityNotFoundException(BusinessMessage.City.CITY_NOT_FOUND_BY_NAME + name);
        });

        logger.info(LogMessage.City.CITY_FOUND_BY_NAME + name);
        return converter.convert(city);
    }

    public Set<CityDto> findAllCities() {
        Set<City> cities = new HashSet<>(cityRepository.findAll());

        if (cities.isEmpty()) {
            logger.error(LogMessage.City.CITY_LIST_EMPTY);
            throw new CityNotFoundException(BusinessMessage.City.CITY_LIST_EMPTY);
        }

        logger.info(LogMessage.City.CITY_LIST + cities.size());
        return converter.convert(cities);
    }

    protected City getCityById(final String id) {
        return cityRepository.findById(id).orElseThrow(() -> {
            logger.error(LogMessage.City.CITY_NOT_FOUND + id);
            return new CityNotFoundException(BusinessMessage.City.CITY_NOT_FOUND + id);
        });
    }

    private void checkIfCityExists(final String name) {
        if (cityRepository.existsByNameIgnoreCase(name)) {
            logger.error(LogMessage.City.CITY_ALREADY_EXISTS + name);
            throw new CityAlreadyExistException(BusinessMessage.City.CITY_ALREADY_EXISTS + name);
        }
    }
}
