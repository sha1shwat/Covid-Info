package com.covid.challenge.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PInPointStateInfoInputRequest {

    private String state;
    private String date;
}
