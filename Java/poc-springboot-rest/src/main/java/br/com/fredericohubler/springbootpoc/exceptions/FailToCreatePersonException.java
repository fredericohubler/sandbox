package br.com.fredericohubler.springbootpoc.exceptions;

public class FailToCreatePersonException extends Exception {

    private String msg;

    public FailToCreatePersonException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
