package com.sbmssc.brawerry.app.sbmsscbeerservice.bootstrap;

import com.sbmssc.brawerry.app.sbmsscbeerservice.domain.Beer;
import com.sbmssc.brawerry.app.sbmsscbeerservice.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerSeed  implements CommandLineRunner {
    @Autowired
    private BeerRepository beerRepository;

    public BeerSeed() {
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObejects();
    }

    private void loadBeerObejects() {
     if(beerRepository.count()==0){
         beerRepository.save(Beer.builder()
                 .beerName("Corona Beer")
                 .beerStyle("Wheat")
                 .quantityToBrew(500)
                 .minOnHand(100)
                 .upc(10352739483036L)
                 .price(new BigDecimal(8.89))
                 .build());
         beerRepository.save(Beer.builder()
                 .beerName("Corona Beer")
                 .beerStyle("Wheat")
                 .quantityToBrew(200)
                 .minOnHand(150)
                 .upc(10352739483037L)
                 .price(new BigDecimal(9.99))
                 .build());
         beerRepository.save(Beer.builder()
                 .beerName("Corona Beer")
                 .beerStyle("Wheat")
                 .quantityToBrew(300)
                 .minOnHand(50)
                 .upc(10352739483038L)
                 .price(new BigDecimal(8.99))
                 .build());
     }
        System.out.println("Loaded Beer Objects : "+beerRepository.count());
    }
}
