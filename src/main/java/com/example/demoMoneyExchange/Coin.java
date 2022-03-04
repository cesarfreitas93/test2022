package com.example.demoMoneyExchange;
//import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
public class Coin implements Serializable {
    private Long id;
    private String name;
    private String code;
    private double value;

    public Coin(Long id, String name, String code, double value) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.value = value;
    }

    public Coin(String name, String code, double value) {
        this.name = name;
        this.code = code;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
