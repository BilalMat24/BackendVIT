package com.example.engine;

import com.example.engine.ControlloImmagini.ControlloreImmagini;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class EngineApplication {

    private static ControlloreImmagini controlloreImmagini;

    @SuppressWarnings("static-access")
    public EngineApplication(ControlloreImmagini controlloreImmagini){
        this.controlloreImmagini = controlloreImmagini;
    }

    public static void main(String[] args) {
        SpringApplication.run(EngineApplication.class, args);
        controlloreImmagini.start();
    }

}