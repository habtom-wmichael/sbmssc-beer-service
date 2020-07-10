package com.sbmssc.brawerry.app.sbmsscbeerservice.services;

import com.sbmssc.brawerry.app.sbmsscbeerservice.web.model.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {
    BeerDto updateBeerById(UUID beerId, BeerDto beerDto);

    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);
}
