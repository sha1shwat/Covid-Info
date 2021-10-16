package com.covid.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Covid19India {

    private Integer sNo;
    private String date;
    private String state;
    private Integer confirmedIndianNational;
    private Integer confirmedForeignNational;
    private Integer cured;
    private Integer deaths;
    private Integer confirmed;
}
