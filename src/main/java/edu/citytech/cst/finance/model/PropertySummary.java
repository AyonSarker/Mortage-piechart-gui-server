package edu.citytech.cst.finance.model;


import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "propertysummary_vw")
public class PropertySummary {

    @Id
    @Column(name= "state")
    private String state;
    @Column(name= "netincome")
    private float netIncome;


    public String getState() {
        return state;
    }

    public float getNetIncome() {
        return netIncome;
    }

    @Override
    public String toString() {
        return "PropertySummary{" +
                "state='" + state + '\'' +
                ", netIncome=" + netIncome +
                '}';
    }
}
