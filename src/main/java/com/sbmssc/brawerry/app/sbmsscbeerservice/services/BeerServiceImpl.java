package com.sbmssc.brawerry.app.sbmsscbeerservice.services;

import com.sbmssc.brawerry.app.sbmsscbeerservice.domain.Beer;
import com.sbmssc.brawerry.app.sbmsscbeerservice.repositories.BeerRepository;
import com.sbmssc.brawerry.app.sbmsscbeerservice.web.mappers.BeerMapper;
import com.sbmssc.brawerry.app.sbmsscbeerservice.web.model.BeerDto;
import com.sbmssc.brawerry.app.sbmsscbeerservice.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return beerMapper.beerToBeerDto(beerRepository.findById(beerId)
                .orElseThrow(MyNotFoundExceptionHandler::new));
    }

    @Override
    public BeerDto updateBeerById(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId)
                .orElseThrow(MyNotFoundExceptionHandler::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyleEnum(beerDto.getBeerStyleEnum());
        beer.setPrice(beerDto.getPrice());
        beer.setQuantityToBrew(beerDto.getQuantityOnHand());
        beer.setUpc(beerDto.getUpc());
        beerRepository.save(beer);
        return beerMapper.beerToBeerDto(beer);
    }


    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }
}
