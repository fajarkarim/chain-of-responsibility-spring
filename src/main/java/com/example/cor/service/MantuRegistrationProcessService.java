package com.example.cor.service;

import com.example.cor.common.ProcessStopperException;
import com.example.cor.dto.MantuInformationDto;
import com.example.cor.dto.RegistrationReqBodyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MantuRegistrationProcessService {
    @Autowired
    KeyakinanHandlerService keyakinanHandlerService;

    @Autowired
    KeluargaApprovalHandlerService keluargaApprovalHandlerService;

    @Autowired
    MapanHandlerService mapanHandlerService;

    @Autowired
    TingkatPendidikanHandlerService tingkatPendidikanHandlerService;

    public void process(RegistrationReqBodyDto registrationReqBodyDto) throws ProcessStopperException {
        keyakinanHandlerService.setNextSuccessProcess(mapanHandlerService);

        mapanHandlerService.setNextSuccessProcess(keluargaApprovalHandlerService);
        mapanHandlerService.setNextFailProcess(tingkatPendidikanHandlerService);

        tingkatPendidikanHandlerService.setNextSuccessProcess(keluargaApprovalHandlerService);

        MantuInformationDto mantuInformationDto = new MantuInformationDto();
        mantuInformationDto.setRegistrationRequest(registrationReqBodyDto);

        keyakinanHandlerService.process(mantuInformationDto);
    }
}
