package fr.modded.api.model;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorModel {
    private final String error;
    private final String errorMessage;
    private String cause;

    public ErrorModel(String error, String errorMessage) {
        this.error = error;
        this.errorMessage = errorMessage;
    }

    public ErrorModel(String error, String errorMessage, Throwable cause) {
        this.error = error;
        this.errorMessage = errorMessage;

        final StringWriter sw = new StringWriter();
        cause.printStackTrace(new PrintWriter(sw));
        this.cause = sw.toString();
    }

    public String getError() {
        return error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
