package com.example.cor.service;

import com.example.cor.common.BaseHandler;
import com.example.cor.common.ProcessStopperException;
import com.example.cor.dto.MantuInformationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KeluargaApprovalHandlerService extends BaseHandler {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void process(MantuInformationDto mantuInformationDto) throws ProcessStopperException {
        logger.info("Keluarga approval process");

        final String mantuName = mantuInformationDto.getDukcapilInformation().getName();

        if (!mantuName.equals("Fajar")) {
            throw new ProcessStopperException("KELUARGA");
        }

    }
}
