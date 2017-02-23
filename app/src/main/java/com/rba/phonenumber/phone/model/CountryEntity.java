package com.rba.phonenumber.phone.model;

/**
 * Created by Ricardo Bravo on 23/02/17.
 */

public class CountryEntity {

    private String name;
    private String iso;
    private int dialCode;

    public CountryEntity(String name, String iso, int dialCode) {
        setName(name);
        setIso(iso);
        setDialCode(dialCode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso.toUpperCase();
    }

    public int getDialCode() {
        return dialCode;
    }

    public void setDialCode(int dialCode) {
        this.dialCode = dialCode;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof CountryEntity) && (((CountryEntity) o).getIso().toUpperCase().equals(this.getIso().toUpperCase()));
    }
}
