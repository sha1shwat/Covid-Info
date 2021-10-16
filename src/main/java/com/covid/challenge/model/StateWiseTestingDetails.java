package com.covid.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StateWiseTestingDetails {

    private String date;
    private String state;
    private Integer totalSamples;
    private Integer negative;
    private Integer positive;
}
