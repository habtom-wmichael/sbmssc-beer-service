package com.sbmssc.brawerry.app.sbmsscbeerservice.web.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbmssc.brawerry.app.sbmsscbeerservice.domain.Beer;
import com.sbmssc.brawerry.app.sbmsscbeerservice.repositories.BeerRepository;
import com.sbmssc.brawerry.app.sbmsscbeerservice.web.model.BeerDto;
import com.sbmssc.brawerry.app.sbmsscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.xml.crypto.dsig.spec.XPathFilterParameterSpec;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs
@WebMvcTest(BeerController.class)
@ComponentScan(basePackages = "com.sbmssc.brawerry.app.sbmsscbeerservice.web.mapper")
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    BeerRepository beerRepository;


    private BeerDto validBeerDto;


    public BeerDto getValidBeerDto() {
        return BeerDto.builder()

                .beerName("Meloti")
                .beerStyleEnum(BeerStyleEnum.WHEAT)
                .price(new BigDecimal(4.99))
                .upc(2341142424L)
                .quantityOnHand(200)
                .build();
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void getBeerById() throws Exception {
        // given(beerRepository.findAllById(any())).willReturn(Optional.of( Beer.builder().build()));
        // mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
        mockMvc.perform(get("/api/v1/beer/{beerId}", UUID.randomUUID().toString())
                .param("userId", "Authorized userId")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())

                .andDo(document("v1/beer", pathParameters(
                        parameterWithName("beerId").description("UUID of desired beer to get.")),
                        requestParameters(
                                parameterWithName("userId").description("UUID of authorized user with token.")
                        ),
                        responseFields(
                                fieldWithPath("id").description("Id of Beer."),
                                fieldWithPath("version").description("version of Beer."),
                                fieldWithPath("createdDate").description("Date Created."),
                                fieldWithPath("lastModified").description("Last Date Modified."),
                                fieldWithPath("beerName").description("Beer Name."),
                                fieldWithPath("beerStyleEnum").description("Beer Style."),
                                fieldWithPath("upc").description("UPC of Beer."),
                                fieldWithPath("price").description("Price of Beer."),
                                fieldWithPath("quantityOnHand").description("Quantity of Beer Avialable on Hand.")
                        )
                ));


    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = getValidBeerDto();

//                BeerDto.builder().build();
        String beerJSON = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerJSON))
                .andExpect(status().isCreated())
                .andDo(document("v1/beer",
                        requestFields(
                                fieldWithPath("id").ignored(),
                                fieldWithPath("version").ignored(),
                                fieldWithPath("createdDate").ignored(),
                                fieldWithPath("lastModified").ignored(),
                                fieldWithPath("beerName").description("Beer Name."),
                                fieldWithPath("beerStyleEnum").description("Beer Style."),
                                fieldWithPath("upc").description("UPC of Beer."),
                                fieldWithPath("price").description("Price of Beer."),
                                fieldWithPath("quantityOnHand").ignored()
                        )));
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerJSON = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerJSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteBeerById() {
    }
}