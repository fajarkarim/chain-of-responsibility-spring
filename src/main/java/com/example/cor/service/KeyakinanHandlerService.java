package com.example.cor.service;

import com.example.cor.common.BaseHandler;
import com.example.cor.common.ProcessStopperException;
import com.example.cor.dto.DukcapilResponseDto;
import com.example.cor.dto.MantuInformationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KeyakinanHandlerService extends BaseHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void process(MantuInformationDto mantuInformationDto) throws ProcessStopperException {
        logger.info("Keyakinan process");
        DukcapilResponseDto mantuDukcapilInfo = getMantuDukcapilInfo(mantuInformationDto);

        String kepercayaanMantu = mantuDukcapilInfo.getBelieve();

        if (kepercayaanMantu.equals("MIE SEDAP")) {
            throw new ProcessStopperException("KEYAKINAN");
        }

        mantuInformationDto.setDukcapilInformation(mantuDukcapilInfo);
        this.nextSuccessProcess(mantuInformationDto);
    }

    private DukcapilResponseDto getMantuDukcapilInfo(MantuInformationDto mantuInformationDto) {
        DukcapilResponseDto dukcapilResponseDto;

        dukcapilResponseDto = getRejectDukcapil();
        String nikMantu = mantuInformationDto.getRegistrationRequest().getNik();

        if (nikMantu.equals("123")) {
            dukcapilResponseDto = getApprovedDukcapil();
        }
        return  dukcapilResponseDto;
    }

    private DukcapilResponseDto getApprovedDukcapil() {
        return new DukcapilResponseDto("Fajar", "25", "INDOMIE", "S1");
    }

    private DukcapilResponseDto getRejectDukcapil() {
        return new DukcapilResponseDto("Karim", "25", "MIE SEDAP", "TK");
    }
}
