package com.covid.challenge.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CovidVaccineStateWiseResponse {

    private Double totalSessionsConducted;
    private Double totalDosesAdministered;
    private Double totalIndividualsVaccinated;
    private Integer aboveSixty;
    private Integer betweenFortyFiveAndSixty;
    private Integer betweenEighteenAndFortyFive;
    private Integer aefi;
    private Integer sputnik;
    private Integer covidShield;
    private Integer covaxin;
    private Integer transgender;
    private Integer female;
    private Integer male;
    private Integer secondDose;
    private Integer firstDose;
    private Integer totalSites;
    private String state;
}
