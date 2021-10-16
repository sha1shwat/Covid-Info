package com.covid.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CovidVaccineStateWise {

    private String updatedOn;
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
