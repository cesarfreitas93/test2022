package com.example.demoMoneyExchange;

import javax.persistence.*;

@Entity
@Table

public class DtoCoin {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, length = 3)
    private String code;
    @Column(nullable = false)
    private double value;

    public DtoCoin() {
    }

    public DtoCoin(String name, String code, double value) {
        this.name = name;
        this.code = code;
        this.value = value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
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
