package com.example.cor.controller;

import com.example.cor.common.ProcessStopperException;
import com.example.cor.dto.MantuRegisteredResponseDto;
import com.example.cor.dto.RegistrationReqBodyDto;
import com.example.cor.service.MantuRegistrationProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MantuRegistrationController {
    @Autowired
    MantuRegistrationProcessService mantuRegistrationProcessService;

    @PostMapping(value = "/mantu/register")
    public MantuRegisteredResponseDto registerMantu(@RequestBody RegistrationReqBodyDto registrationReqBodyDto) {

        try {
            mantuRegistrationProcessService.process(registrationReqBodyDto);
            return new MantuRegisteredResponseDto("Mantu Registration Success");
        } catch (ProcessStopperException exception) {
            String failedReason =
                "Mantu Registration Failed in : " + exception.getProcessName();
            return new MantuRegisteredResponseDto(failedReason);
        }

    }

}
