package com.mylearnings.microservices.limitsservice.controller;


import com.mylearnings.microservices.limitsservice.bean.LimitConfiguration;
import com.mylearnings.microservices.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations(){
        return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
    }
}
