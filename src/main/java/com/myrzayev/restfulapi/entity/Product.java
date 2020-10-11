package com.myrzayev.restfulapi.entity;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private int id;
    @Basic(optional = false)
    private String prodName;
    @Basic(optional = false)
    private String seventeen;
    @Basic(optional = false)
    private String thirty;
    @Basic(optional = false)
    private String fifty;
    @Basic(optional = false)
    private String oneHundred;

    public Product() {
    }

    public Product(int id, String prodName, String seventeen, String thirty, String fifty, String oneHundred) {
        this.id = id;
        this.prodName = prodName;
        this.seventeen = seventeen;
        this.thirty = thirty;
        this.fifty = fifty;
        this.oneHundred = oneHundred;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getSeventeen() {
        return seventeen;
    }

    public void setSeventeen(String seventeen) {
        this.seventeen = seventeen;
    }

    public String getThirty() {
        return thirty;
    }

    public void setThirty(String thirty) {
        this.thirty = thirty;
    }

    public String getFifty() {
        return fifty;
    }

    public void setFifty(String fifty) {
        this.fifty = fifty;
    }

    public String getOneHundred() {
        return oneHundred;
    }

    public void setOneHundred(String oneHundred) {
        this.oneHundred = oneHundred;
    }
}
