package com.example.cor.common;

import com.example.cor.dto.MantuInformationDto;

public interface Chainable {
    void process(MantuInformationDto mantuInformationDto) throws ProcessStopperException;
}
