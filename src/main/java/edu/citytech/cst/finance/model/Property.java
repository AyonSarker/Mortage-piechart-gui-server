package edu.citytech.cst.finance.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "properties")
public class Property {

    @Id
    @Column(name= "id")
    private  String id;

    @Column(name= "cost")
    private  float cost;

    @Column(name= "downpayment")
    private  float downPayment;
    @Column(name= "state")
    private  String state;
    @Column(name= "netincome")
    private  float netIncome;
    @Column(name= "profityear")
    private  int profitYear;

    public Property(){}
    public Property(String id, float cost, float downPayment, String state, float netIncome, int profitYear) {

        this.id = id;
        this.cost = cost;
        this.downPayment=downPayment;
        this.state= state;
        this.netIncome=netIncome;
        this.profitYear=profitYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(float downPayment) {
        this.downPayment = downPayment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(float netIncome) {
        this.netIncome = netIncome;
    }

    public int getProfitYear() {
        return profitYear;
    }

    public void setProfitYear(int profitYear) {
        this.profitYear = profitYear;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id='" + id + '\'' +
                ", cost=" + cost +
                ", downPayment=" + downPayment +
                ", state='" + state + '\'' +
                ", netIncome=" + netIncome +
                ", profitYear=" + profitYear +
                '}';
    }
}
