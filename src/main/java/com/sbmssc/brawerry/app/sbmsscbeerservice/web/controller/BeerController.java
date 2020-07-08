package com.sbmssc.brawerry.app.sbmsscbeerservice.web.controller;

import com.sbmssc.brawerry.app.sbmsscbeerservice.repositories.BeerRepository;
import com.sbmssc.brawerry.app.sbmsscbeerservice.web.mapper.BeerMapper;
import com.sbmssc.brawerry.app.sbmsscbeerservice.web.model.BeerDto;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private BeerMapper beerMapper;

    private BeerRepository beerRepository;


    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {

        //return new ResponseEntity<>( beerMapper.beerToBeerDto(beerRepository.findById(beerId).get()), HttpStatus.OK);
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer( @RequestBody @Validated BeerDto beerDto) {

        // beerRepository.save(beerMapper.beerDtoToBeer(beerDto));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody @Validated BeerDto beerDto) {
        beerRepository.findById(beerId).ifPresent(beer -> {
            beer.setBeerName(beerDto.getBeerName());
            beer.setBeerStyle(beerDto.getBeerStyleEnum().name());
            beer.setUpc(beerDto.getUpc());
            beer.setPrice(beerDto.getPrice());
            beerRepository.save(beer);
        });

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeerById(@PathVariable("beerId") UUID beerId){
        //do impl
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
