package com.csgbd.model;

import java.util.Calendar;

/**
 * Created by gabriel on 09/05/17.
 */
public class Geoname {
    private Long geonameid;
    private String name, asciiname, alternatenames;
    private float latitude;
    private float longitude;
    private String fclass, fcode, country, cc2, admin1, admin2, admin3, admin4;
    private Long population;
    private int elevation;
    private int gtopo30;
    String timezone;
    Calendar moddate;

    public Geoname () {}

    public Geoname (Long geonameid, String name, String asciiname, String alternatenames,
                    float latitude, float longitude, String fclass, String fcode, String country, String cc2, String admin1,
                    String admin2, String admin3, String admin4, Long population, int elevation, int gtopo30,
                    String timezone, Calendar moddate) {
        this.geonameid = geonameid;
        this.name = name;
        this.asciiname = asciiname;
        this.alternatenames = alternatenames;
        this.latitude = latitude;
        this.longitude = longitude;
        this.fclass = fclass;
        this.fcode = fcode;
        this.country = country;
        this.cc2 = cc2;
        this.admin1 = admin1;
        this.admin2 = admin2;
        this.admin3 = admin3;
        this.admin4 = admin4;
        this.population = population;
        this.elevation = elevation;
        this.gtopo30 = gtopo30;
        this.timezone = timezone;
        this.moddate = moddate;
    }

    public Long getGeonameid() {
        return geonameid;
    }

    public void setGeonameid(Long geonameid) {
        this.geonameid = geonameid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsciiname() {
        return asciiname;
    }

    public void setAsciiname(String asciiname) {
        this.asciiname = asciiname;
    }

    public String getAlternatenames() {
        return alternatenames;
    }

    public void setAlternatenames(String alternatenames) {
        this.alternatenames = alternatenames;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getFclass() {
        return fclass;
    }

    public void setFclass(String fclass) {
        this.fclass = fclass;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCc2() {
        return cc2;
    }

    public void setCc2(String cc2) {
        this.cc2 = cc2;
    }

    public String getAdmin1() {
        return admin1;
    }

    public void setAdmin1(String admin1) {
        this.admin1 = admin1;
    }

    public String getAdmin2() {
        return admin2;
    }

    public void setAdmin2(String admin2) {
        this.admin2 = admin2;
    }

    public String getAdmin3() {
        return admin3;
    }

    public void setAdmin3(String admin3) {
        this.admin3 = admin3;
    }

    public String getAdmin4() {
        return admin4;
    }

    public void setAdmin4(String admin4) {
        this.admin4 = admin4;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public int getGtopo30() {
        return gtopo30;
    }

    public void setGtopo30(int gtopo30) {
        this.gtopo30 = gtopo30;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Calendar getModdate() {
        return moddate;
    }

    public void setModdate(Calendar moddate) {
        this.moddate = moddate;
    }
}






