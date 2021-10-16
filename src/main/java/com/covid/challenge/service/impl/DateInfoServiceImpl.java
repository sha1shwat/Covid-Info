package com.covid.challenge.service.impl;

import com.covid.challenge.dB.Database;
import com.covid.challenge.request.DateInfoInputRequest;
import com.covid.challenge.response.Covid19IndiaResponse;
import com.covid.challenge.response.CovidVaccineStateWiseResponse;
import com.covid.challenge.response.DateInfoResponse;
import com.covid.challenge.response.StateWiseTestingResponse;
import com.covid.challenge.service.DateInfoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service("dateInfoService")
public class DateInfoServiceImpl implements DateInfoService {

    private Database database;

    @PostConstruct
    void init() throws SQLException {
        try {
            database = new Database();
            Path path1 = Paths.get("src/main/resources/covid_19_india.csv");
            database.read(path1);
            Path path2 = Paths.get("src/main/resources/covid_vaccine_statewise.csv");
            database.read(path2);
            Path path3 = Paths.get("src/main/resources/StatewiseTestingDetails.csv");
            database.read(path3);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public Mono<DateInfoResponse> dateInfoService(DateInfoInputRequest dateInfoInputRequest) throws SQLException {

        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();

        String query1 = "select * from " + "covid_19_india" + "where date=" + dateInfoInputRequest.getDate();
        ResultSet resultSet = statement.executeQuery(query1);

        List<Covid19IndiaResponse> covid19IndiaResponseList = getCovid19ResponseList(resultSet);

        String query2 = "select * from " + "covid_vaccine_statewise" + "where updated_on=" + dateInfoInputRequest.getDate();
        ResultSet resultSet1 = statement.executeQuery(query2);
        List<CovidVaccineStateWiseResponse> covidVaccineStateWiseResponseList = getcovidVaccineStateWiseResponseList(resultSet);


        String query3 = "select * from " + "StatewiseTestingDetails" + "where date=" + dateInfoInputRequest.getDate();
        ResultSet resultSet2 = statement.executeQuery(query1);
        List<StateWiseTestingResponse> stateWiseTestingResponseList = getstateWiseTestingResponseList(resultSet);

        DateInfoResponse dateInfoResponse = new DateInfoResponse();
        dateInfoResponse.setIndiaResponse(covid19IndiaResponseList);
        dateInfoResponse.setStateWiseTestingResponse(stateWiseTestingResponseList);
        dateInfoResponse.setStateWiseVaccineResponse(covidVaccineStateWiseResponseList);
        return Mono.just(dateInfoResponse);

    }

    private List<StateWiseTestingResponse> getstateWiseTestingResponseList(ResultSet resultSet) throws SQLException {
        List<StateWiseTestingResponse> stateWiseTestingResponseList = new ArrayList<>();
        while (resultSet.next()) {
            StateWiseTestingResponse stateWiseTestingResponse = new StateWiseTestingResponse();
            stateWiseTestingResponse.setState(resultSet.getString("State"));
            stateWiseTestingResponse.setNegative(Integer.getInteger(resultSet.getString("Negative")));
            stateWiseTestingResponse.setPositive(Integer.getInteger(resultSet.getString("Positive")));
            stateWiseTestingResponse.setTotalSamples(Integer.getInteger(resultSet.getString("TotalSamples")));

            stateWiseTestingResponseList.add(stateWiseTestingResponse);
        }

        return stateWiseTestingResponseList;
    }

    private List<CovidVaccineStateWiseResponse> getcovidVaccineStateWiseResponseList(ResultSet resultSet) throws SQLException {

        List<CovidVaccineStateWiseResponse> covidVaccineStateWiseResponseList = new ArrayList<>();
        while (resultSet.next()) {
            CovidVaccineStateWiseResponse covidVaccineStateWiseResponse = new CovidVaccineStateWiseResponse();
            covidVaccineStateWiseResponse.setState(resultSet.getString("State"));
            covidVaccineStateWiseResponse.setCovidShield(Integer.getInteger(resultSet.getString("CovidShield")));
            covidVaccineStateWiseResponse.setAefi(Integer.getInteger(resultSet.getString("AEFI")));
            covidVaccineStateWiseResponse.setCovaxin(Integer.getInteger(resultSet.getString("Covaxin")));
            covidVaccineStateWiseResponse.setAboveSixty(Integer.getInteger(resultSet.getString("AboveSixty")));
            covidVaccineStateWiseResponse.setFemale(Integer.getInteger(resultSet.getString("Female")));
            covidVaccineStateWiseResponse.setBetweenEighteenAndFortyFive(Integer.getInteger(resultSet.getString("BetweenEighteenAndFortyFive")));
            covidVaccineStateWiseResponse.setBetweenFortyFiveAndSixty(Integer.getInteger(resultSet.getString("BetweenFortyFiveAndSixty")));
            covidVaccineStateWiseResponse.setFirstDose(Integer.getInteger(resultSet.getString("FirstDose")));
            covidVaccineStateWiseResponse.setMale(Integer.getInteger(resultSet.getString("Male")));
            covidVaccineStateWiseResponse.setSecondDose(Integer.getInteger(resultSet.getString("SecondDose")));
            covidVaccineStateWiseResponse.setTransgender(Integer.getInteger(resultSet.getString("Transgender")));
            covidVaccineStateWiseResponse.setTotalSites(Integer.getInteger(resultSet.getString("TotalSites")));
            covidVaccineStateWiseResponse.setSputnik(Integer.getInteger(resultSet.getString("Sputnik")));
            covidVaccineStateWiseResponse.setTotalDosesAdministered(Double.valueOf(resultSet.getString("TotalDosesAdministered")));
            covidVaccineStateWiseResponse.setTotalIndividualsVaccinated(Double.valueOf(resultSet.getString("TotalIndividualsVaccinated")));
            covidVaccineStateWiseResponse.setTotalSessionsConducted(Double.valueOf(resultSet.getString("TotalSessionsConducted")));

            covidVaccineStateWiseResponseList.add(covidVaccineStateWiseResponse);
        }

        return covidVaccineStateWiseResponseList;
    }

    private List<Covid19IndiaResponse> getCovid19ResponseList(ResultSet resultSet) throws SQLException {

        List<Covid19IndiaResponse> covid19IndiaResponseList = new ArrayList<>();

        while (resultSet.next()) {

            Covid19IndiaResponse covid19IndiaResponse = new Covid19IndiaResponse();
            covid19IndiaResponse.setConfirmed(Integer.getInteger(resultSet.getString("Confirmed")));
            covid19IndiaResponse.setConfirmedIndianNational(Integer.getInteger(resultSet.getString("ConfirmedIndianNational")));
            covid19IndiaResponse.setCured(Integer.getInteger(resultSet.getString("Cured")));
            covid19IndiaResponse.setDeaths(Integer.getInteger(resultSet.getString("Deaths")));
            covid19IndiaResponse.setState(resultSet.getString("State"));
            covid19IndiaResponseList.add(covid19IndiaResponse);
        }

        return covid19IndiaResponseList;
    }
}
