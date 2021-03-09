package com.example.demo;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@RunWith(io.cucumber.junit.Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "junit:build/cucumber-junit.xml", "html:build/cucumber.html"},
        features = "classpath:/"
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class CucumberTest {

}
