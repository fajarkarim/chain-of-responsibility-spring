package com.example.cor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MantuInformationDto {
    private RegistrationReqBodyDto registrationRequest;
    private DukcapilResponseDto dukcapilInformation;
    private WorkInformationDto workInformation;
}
