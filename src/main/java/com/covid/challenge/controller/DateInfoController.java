package com.covid.challenge.controller;

import com.covid.challenge.request.DateInfoInputRequest;
import com.covid.challenge.response.DateInfoResponse;
import com.covid.challenge.service.DateInfoService;
import com.covid.challenge.service.impl.DateInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.sql.SQLException;

@Component
public class DateInfoController {

    @Autowired
    @Qualifier("dateInfoService")
    private DateInfoService dateInfoService;

    public Mono<ServerResponse> dateInfoHandler(ServerRequest serverRequest) {

        Mono<DateInfoInputRequest> dateInfoRequestMono = serverRequest.bodyToMono(DateInfoInputRequest.class);

        Mono<DateInfoResponse> dateInfoResponse = dateInfoRequestMono.flatMap((request) -> {

            try {
                return dateInfoService.dateInfoService(request);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });

        return dateInfoResponse.flatMap((response) -> {

            return ServerResponse.ok().bodyValue(response);
        });


    }

}
