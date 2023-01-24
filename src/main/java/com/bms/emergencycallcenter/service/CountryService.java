package com.bms.emergencycallcenter.service;

import com.bms.emergencycallcenter.dto.CountryDto;
import com.bms.emergencycallcenter.dto.converter.CountryDtoConverter;
import com.bms.emergencycallcenter.exception.CountryAlreadyExistException;
import com.bms.emergencycallcenter.exception.CountryNotFoundException;
import com.bms.emergencycallcenter.helper.message.BusinessMessage;
import com.bms.emergencycallcenter.helper.message.LogMessage;
import com.bms.emergencycallcenter.model.Country;
import com.bms.emergencycallcenter.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CountryService {
    private final CountryRepository countryRepository;
    private final CountryDtoConverter converter;
    private static final Logger logger = LoggerFactory.getLogger(CountryService.class);

    public void createCountry(final String name) {
        checkIfCountryExists(name);

        Country country = new Country(name);

        countryRepository.save(country);
        logger.info(LogMessage.Country.COUNTRY_CREATED + name);
    }

    public void updateCountry(final String id, final String name) {
        Country country = getCountryById(id);

        if (!country.getName().equalsIgnoreCase(name)) {
            checkIfCountryExists(name);
        }

        Country updatedCountry = new Country(
                country.getId(),
                name,
                country.getCities()
        );

        countryRepository.save(updatedCountry);
        logger.info(LogMessage.Country.COUNTRY_UPDATED + id);
    }

    public void deleteCountry(final String id) {
        countryRepository.delete(getCountryById(id));
        logger.info(LogMessage.Country.COUNTRY_DELETED + id);
    }

    public CountryDto findCountryByName(final String name) {
        Country country = countryRepository.findByNameIgnoreCase(name).orElseThrow(() -> {
            logger.error(LogMessage.Country.COUNTRY_NOT_FOUND_BY_NAME + name);
            throw new CountryNotFoundException(BusinessMessage.Country.COUNTRY_NOT_FOUND_BY_NAME + name);
        });

        logger.info(LogMessage.Country.COUNTRY_FOUND_BY_NAME + name);
        return converter.convert(country);
    }

    public Set<CountryDto> findAllCountries() {
        Set<Country> countries = new HashSet<>(countryRepository.findAll());

        if (countries.isEmpty()) {
            logger.error(LogMessage.Country.COUNTRY_LIST_EMPTY);
            throw new CountryNotFoundException(BusinessMessage.Country.COUNTRY_LIST_EMPTY);
        }

        logger.info(LogMessage.Country.COUNTRY_LIST + countries.size());
        return converter.convert(countries);
    }

    protected Country getCountryById(final String id) {
        return countryRepository.findById(id).orElseThrow(() -> {
            logger.error(LogMessage.Country.COUNTRY_NOT_FOUND + id);
            throw new CountryNotFoundException(BusinessMessage.Country.COUNTRY_NOT_FOUND + id);
        });
    }

    private void checkIfCountryExists(final String name) {
        if (countryRepository.existsByNameIgnoreCase(name)) {
            logger.error(LogMessage.Country.COUNTRY_ALREADY_EXISTS + name);
            throw new CountryAlreadyExistException(BusinessMessage.Country.COUNTRY_ALREADY_EXISTS + name);
        }
    }

    public CountryService(CountryRepository countryRepository,
                          CountryDtoConverter converter) {
        this.countryRepository = countryRepository;
        this.converter = converter;
    }
}
