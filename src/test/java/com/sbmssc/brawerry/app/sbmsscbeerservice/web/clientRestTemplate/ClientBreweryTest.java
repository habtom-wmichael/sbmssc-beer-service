package com.sbmssc.brawerry.app.sbmsscbeerservice.web.clientRestTemplate;

import com.sbmssc.brawerry.app.sbmsscbeerservice.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ClientBreweryTest {
@Autowired
    ClientBrewery clientBrewery;
    @Test
    void getBeerById() {
        BeerDto beerDto= clientBrewery.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }
}