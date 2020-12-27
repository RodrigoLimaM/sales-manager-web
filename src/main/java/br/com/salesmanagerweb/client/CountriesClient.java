package br.com.salesmanagerweb.client;

import br.com.salesmanagerweb.model.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "CountriesClient", url = "${rest-countries.url}")
public interface CountriesClient {

    @GetMapping("/rest/v2/all")
    List<Country> getCountries(@RequestParam String fields);
}
