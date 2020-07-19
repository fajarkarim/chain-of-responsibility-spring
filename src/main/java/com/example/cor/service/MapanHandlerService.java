package com.example.cor.service;

import com.example.cor.common.BaseHandler;
import com.example.cor.common.ProcessStopperException;
import com.example.cor.dto.MantuInformationDto;
import com.example.cor.dto.WorkInformationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MapanHandlerService extends BaseHandler {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void process(MantuInformationDto mantuInformationDto) throws ProcessStopperException {
        logger.info("Mapan process");
        WorkInformationDto mantuWorkInformation = getMantuWorkInformation(mantuInformationDto);
        int salaryMantu = mantuWorkInformation.getSalaryPerMonth();

        if (salaryMantu < 100) {
            this.nextFailProcess(mantuInformationDto);
            return;
        }

        mantuInformationDto.setWorkInformation(mantuWorkInformation);
        this.nextSuccessProcess(mantuInformationDto);
    }

    private WorkInformationDto getMantuWorkInformation(MantuInformationDto mantuInformationDto) {
        final String nik = mantuInformationDto.getRegistrationRequest().getNik();
        if (nik.equals("123")) {
            return new WorkInformationDto(101);
        }
        return new WorkInformationDto(90);
    }
}
