package com.company.bazinis;

import java.util.Date;

public class Balsuotojai {
    private int id;
    private String vardas;
    private String pavarde;
    private String gimimo_metai;
    private String apygarda;
    private String tautybe;

    public Balsuotojai(int id, String vardas, String pavarde, String gimimo_metai, String apygarda, String tautybe) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.gimimo_metai = gimimo_metai;
        this.apygarda = apygarda;
        this.tautybe = tautybe;
    }

    public Balsuotojai(String vardas, String pavarde, String gimimo_metai, String apygarda, String tautybe) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.gimimo_metai = gimimo_metai;
        this.apygarda = apygarda;
        this.tautybe = tautybe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getGimimo_metai() {
        return gimimo_metai;
    }

    public void setGimimo_metai(String gimimo_metai) {
        this.gimimo_metai = gimimo_metai;
    }

    public String getApygarda() {
        return apygarda;
    }

    public void setApygarda(String apygarda) {
        this.apygarda = apygarda;
    }

    public String getTautybe() {
        return tautybe;
    }

    public void setTautybe(String tautybe) {
        this.tautybe = tautybe;
    }

    @Override
    public String toString() {
        return "Balsuotojai{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", gimimo_metai=" + gimimo_metai +
                ", apygarda='" + apygarda + '\'' +
                ", tautybe='" + tautybe + '\'' +
                '}';
    }
}
