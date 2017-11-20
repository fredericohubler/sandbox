package br.com.fredericohubler.springbootpoc.exceptions;

public class PersonNotFoundException extends Exception {

    private String msg;

    public PersonNotFoundException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
