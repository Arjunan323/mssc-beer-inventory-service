package com.arjunan.msscbeerinventoryservice.web.controllers;

import com.arjunan.msscbeerinventoryservice.repositories.BeerInventoryRepository;
import com.arjunan.msscbeerinventoryservice.web.mappers.BeerInventoryMapper;
import com.arjunan.msscbeerinventoryservice.web.model.BeerInventoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class BeerInventoryController {

    private final BeerInventoryMapper beerInventoryMapper;
    private final BeerInventoryRepository beerInventoryRepository;

    public BeerInventoryController(BeerInventoryMapper beerInventoryMapper, BeerInventoryRepository beerInventoryRepository) {
        this.beerInventoryMapper = beerInventoryMapper;
        this.beerInventoryRepository = beerInventoryRepository;
    }

    @GetMapping
   public ResponseEntity<List<BeerInventoryDto>> listBeerById(@PathVariable UUID beerId){

        log.info("Finding Inventory for Beer by Id : "+ beerId);

        return new ResponseEntity<>(beerInventoryRepository.findAllByBeerId(beerId)
                .stream().map(beerInventoryMapper::beerInventoryToBeerInventoryDto)
                .collect(Collectors.toList()), HttpStatus.OK
        );
    }
}
