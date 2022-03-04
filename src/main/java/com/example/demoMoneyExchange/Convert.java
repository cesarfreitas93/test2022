package com.example.demoMoneyExchange;
import java.io.Serializable;
public class Convert implements Serializable {
    private Long id_o;
    private Long id_d;
    private double value;

    public Convert(Long id_o, Long id_d, double value) {
        this.id_o = id_o;
        this.id_d = id_d;
        this.value = value;
    }

    public double getId_o() {
        return id_o;
    }

    public void setId_o(long id_o) {
        this.id_o = id_o;
    }

    public double getId_d() {
        return id_d;
    }

    public void setId_d(long id_d) {
        this.id_d = id_d;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
