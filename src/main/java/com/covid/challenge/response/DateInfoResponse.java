package com.covid.challenge.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DateInfoResponse {

    @JsonProperty("India_Wise_Details")
    List<Covid19IndiaResponse> indiaResponse;
    @JsonProperty("State_Wise_Vaccine_Details")
    List<CovidVaccineStateWiseResponse> stateWiseVaccineResponse;
    @JsonProperty("State_WIse_Testing_Details")
    List<StateWiseTestingResponse> stateWiseTestingResponse;
}
