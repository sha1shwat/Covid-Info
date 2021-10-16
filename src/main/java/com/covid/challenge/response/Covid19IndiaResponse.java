package com.covid.challenge.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Covid19IndiaResponse {


    private String state;
    private Integer confirmedIndianNational;
    private Integer confirmedForeignNational;
    private Integer cured;
    private Integer deaths;
    private Integer confirmed;
}
