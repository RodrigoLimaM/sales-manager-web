package br.com.salesmanagerweb.service;

import br.com.salesmanagerweb.client.CountriesClient;
import br.com.salesmanagerweb.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountriesService {

    private static String COUNTRIES_FIELDS_DEFAULT_PARAM_VALUE = "name";

    @Autowired
    CountriesClient countriesClient;

    public List<String> getCountries() {
        return countriesClient.getCountries(COUNTRIES_FIELDS_DEFAULT_PARAM_VALUE)
                .stream()
                .map(Country::getName)
                .collect(Collectors.toList());
    }

}
