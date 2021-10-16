package com.covid.challenge.service;

import com.covid.challenge.request.DateInfoInputRequest;
import com.covid.challenge.response.DateInfoResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.sql.SQLException;

//@Service
public interface DateInfoService {

    public Mono<DateInfoResponse> dateInfoService(DateInfoInputRequest dateInfoInputRequest) throws SQLException;
}
