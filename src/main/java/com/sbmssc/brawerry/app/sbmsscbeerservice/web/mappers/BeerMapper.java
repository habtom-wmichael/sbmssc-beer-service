package com.sbmssc.brawerry.app.sbmsscbeerservice.web.mappers;

import com.sbmssc.brawerry.app.sbmsscbeerservice.domain.Beer;
import com.sbmssc.brawerry.app.sbmsscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);

}
