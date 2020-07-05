package com.sbmssc.brawerry.app.sbmsscbeerservice.repositories;

import com.sbmssc.brawerry.app.sbmsscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
//you don't need to add @Repository annotations

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
