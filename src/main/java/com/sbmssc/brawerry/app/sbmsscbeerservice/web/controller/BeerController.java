package com.sbmssc.brawerry.app.sbmsscbeerservice.web.controller;

import com.sbmssc.brawerry.app.sbmsscbeerservice.web.model.BeerDto;
import com.sun.istack.NotNull;
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

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@NotNull @PathVariable("beerId") UUID beerId) {
        //do impl
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer( @RequestBody @Validated BeerDto beerDto) {
        //to impl
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PutMapping("/{beerId}")

    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody @Validated BeerDto beerDto){
        //do impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeerById(@PathVariable("beerId") UUID beerId){
        //do impl
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //handiling the the validation error using error handler
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler( ConstraintViolationException e) {

        List<String> errors=new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath()+" : "+constraintViolation.getMessage());
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
