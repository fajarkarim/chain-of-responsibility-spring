package com.example.cor.common;

public class ProcessStopperException extends Exception {
    private String processName;

    public ProcessStopperException(String processName) {
        this.processName = processName;
    }

    public String getProcessName() {
        return processName;
    }
}
