package com.firetower.data_generator.Controllers;

import com.firetower.data_generator.services.CycleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratorController {

    @GetMapping(value = "/start")
    public void start(){
        if(CycleService.paused){
            CycleService.paused = false;
        }
    }
    @GetMapping(value = "/stop")
    public void stop(){

        if(!CycleService.paused){
            CycleService.paused = true;
        }
    }
}
