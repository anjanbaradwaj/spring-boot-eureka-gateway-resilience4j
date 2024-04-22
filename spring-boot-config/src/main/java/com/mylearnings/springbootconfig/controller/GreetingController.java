package com.mylearnings.springbootconfig.controller;

import com.mylearnings.springbootconfig.configuration.ConfigurationSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class GreetingController {

    @Value("${my.greeting}")
    private String greetingMsg;

    @Value("static message")
    private String staticMsg;

    @Value("${my.list.values}")
    private List<String> listValues;


    @Autowired
    ConfigurationSettings configurationSettings = new ConfigurationSettings();

    @GetMapping("/greeting")
    public String greeting() {
        return greetingMsg + " \n " + staticMsg + " \n " + configurationSettings.getConnection();
    }
}
