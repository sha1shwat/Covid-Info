package com.covid.challenge.routes;

import com.covid.challenge.controller.DateInfoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private DateInfoController dateInfoController;

    public RouterFunction<ServerResponse> routerFunction(){

        return RouterFunctions.route().POST("xyz",dateInfoController::dateInfoHandler).build();
    }


}
