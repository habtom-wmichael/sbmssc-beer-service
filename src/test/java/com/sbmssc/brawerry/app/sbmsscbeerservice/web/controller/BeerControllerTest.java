package com.sbmssc.brawerry.app.sbmsscbeerservice.web.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbmssc.brawerry.app.sbmsscbeerservice.web.model.BeerDto;
import com.sbmssc.brawerry.app.sbmsscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;
@Autowired
    ObjectMapper objectMapper;

private BeerDto validBeerDto;



    public BeerControllerTest() {
        this.validBeerDto = validBeerDto=BeerDto.builder()
                .beerName("Meloti")
                .beerStyleEnum(BeerStyleEnum.WHEAT)
                .build();
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void saveNewBeer() throws  Exception {
        BeerDto beerDto= validBeerDto;

//                BeerDto.builder().build();
        String beerJSON=objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
        .content(beerJSON))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception{
        BeerDto beerDto= validBeerDto;
        String beerJSON=objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/"+UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
        .content(beerJSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteBeerById() {
    }
}