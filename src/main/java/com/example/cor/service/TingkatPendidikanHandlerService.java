package com.example.cor.service;

import com.example.cor.common.BaseHandler;
import com.example.cor.common.ProcessStopperException;
import com.example.cor.dto.MantuInformationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TingkatPendidikanHandlerService extends BaseHandler {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void process(MantuInformationDto mantuInformationDto) throws ProcessStopperException {
        logger.info("Tingkat pendidikan process");
        String mantuEducation = mantuInformationDto.getDukcapilInformation().getEducation();

        if (mantuEducation.equals("SD")) {
            throw new ProcessStopperException("TINGKAT PENDIDIKAN");
        }

        this.nextSuccessProcess(mantuInformationDto);
    }
}
