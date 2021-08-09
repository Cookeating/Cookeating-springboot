package com.tistory.cookeat.cookeating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CookeatingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CookeatingApplication.class, args);
    }

}
