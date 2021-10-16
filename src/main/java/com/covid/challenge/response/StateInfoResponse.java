package com.covid.challenge.response;

import com.covid.challenge.model.Covid19India;
import com.covid.challenge.model.CovidVaccineStateWise;
import com.covid.challenge.model.StateWiseTestingDetails;
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
public class StateInfoResponse {

    @JsonProperty("India_Wise_Details")
    List<Covid19India> indiaResponse;
    @JsonProperty("State_Wise_Vaccine_Details")
    List<CovidVaccineStateWise> stateWiseVaccineResponse;
    @JsonProperty("State_WIse_Testing_Details")
    List<StateWiseTestingDetails> stateWiseTestingResponse;
}
