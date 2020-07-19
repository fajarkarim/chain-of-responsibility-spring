package com.example.cor.common;

import com.example.cor.dto.MantuInformationDto;

public abstract class BaseHandler implements Chainable {
    private BaseHandler nextSuccessProcess;
    private BaseHandler nextFailProcess;

    public BaseHandler setNextSuccessProcess(BaseHandler nextSuccessProcess) {
        this.nextSuccessProcess = nextSuccessProcess;
        return nextSuccessProcess;
    }

    public BaseHandler setNextFailProcess(BaseHandler nextFailProcess) {
        this.nextFailProcess = nextFailProcess;
        return nextFailProcess;
    }

    protected void nextSuccessProcess(MantuInformationDto mantuInformationDto)
        throws ProcessStopperException {
        if (nextSuccessProcess != null) {
            this.nextSuccessProcess.process(mantuInformationDto);
        }
    }

    protected void nextFailProcess(MantuInformationDto mantuInformationDto)
        throws ProcessStopperException {
        if (nextFailProcess != null) {
            this.nextFailProcess.process(mantuInformationDto);
        }
    }
}
