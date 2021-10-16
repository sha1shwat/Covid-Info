package com.covid.challenge.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StateWiseTestingResponse {

    private String state;
    private Integer totalSamples;
    private Integer negative;
    private Integer positive;
}
