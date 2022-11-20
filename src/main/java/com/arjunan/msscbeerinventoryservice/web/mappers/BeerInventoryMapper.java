package com.arjunan.msscbeerinventoryservice.web.mappers;

import com.arjunan.msscbeerinventoryservice.domain.BeerInventory;
import com.arjunan.msscbeerinventoryservice.web.model.BeerInventoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    @Mapping(target = "version", ignore = true)
    BeerInventory beerInventoryDtoTOBeerInventory(BeerInventoryDto beerInventoryDto);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
