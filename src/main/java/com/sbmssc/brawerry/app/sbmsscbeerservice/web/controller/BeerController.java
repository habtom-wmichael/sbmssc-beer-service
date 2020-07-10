package com.sbmssc.brawerry.app.sbmsscbeerservice.web.controller;

import com.sbmssc.brawerry.app.sbmsscbeerservice.repositories.BeerRepository;
import com.sbmssc.brawerry.app.sbmsscbeerservice.services.BeerService;
import com.sbmssc.brawerry.app.sbmsscbeerservice.web.mappers.BeerMapper;
import com.sbmssc.brawerry.app.sbmsscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {


    private final BeerService beerService;


    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {

        //return new ResponseEntity<>( beerMapper.beerToBeerDto(beerRepository.findById(beerId).get()), HttpStatus.OK);
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto) {


        return new ResponseEntity(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody @Validated BeerDto beerDto) {


        return new ResponseEntity(beerService.updateBeerById(beerId, beerDto), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeerById(@PathVariable("beerId") UUID beerId){
        //do impl
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
