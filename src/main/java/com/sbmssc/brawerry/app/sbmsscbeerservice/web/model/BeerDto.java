package com.sbmssc.brawerry.app.sbmsscbeerservice.web.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @Null
    private UUID id;
    @Null
    private Integer version;
    @Null
    private OffsetDateTime createdDate;
    @Null
    private OffsetDateTime lastModified;
    @NotBlank
    @Size(min=3, max = 100)
    private String beerName;
   @NotNull
    private BeerStyleEnum beerStyleEnum;
    @Positive
    @NotNull
    private Long upc;
    @NotNull
    @Positive
    private BigDecimal price;
    @Positive
    @NotNull
    private Integer quantityOnHand;

}
