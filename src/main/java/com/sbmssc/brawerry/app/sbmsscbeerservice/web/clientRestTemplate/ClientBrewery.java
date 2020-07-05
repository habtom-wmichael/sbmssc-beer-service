package com.sbmssc.brawerry.app.sbmsscbeerservice.web.clientRestTemplate;

import com.sbmssc.brawerry.app.sbmsscbeerservice.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@ConfigurationProperties(value = "mssc.brewery", ignoreInvalidFields = false)
public class ClientBrewery {
    public final String BEER_PATH_V1="/app/v1/beer";

   private RestTemplate restTemplate;
    private  String apihost;

    public ClientBrewery() {
    }

    public ClientBrewery(String apihost) {
        this.apihost = apihost;
    }

    public ClientBrewery(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost+BEER_PATH_V1+uuid,BeerDto.class);
    }

}
