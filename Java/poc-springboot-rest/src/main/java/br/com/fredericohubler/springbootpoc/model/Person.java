package br.com.fredericohubler.springbootpoc.model;

public class Person {
    private String name, level, birthDate;
    private Integer id;

    public Person(String name, String level, String birthDate, Integer id) {
        this.name = name;
        this.level = level;
        this.birthDate = birthDate;
        this.id = id;
    }

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
