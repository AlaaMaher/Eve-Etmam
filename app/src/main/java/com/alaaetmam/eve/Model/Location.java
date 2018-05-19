package com.alaaetmam.eve.Model;

import java.io.Serializable;

public class Location implements Serializable {
    private int DistrictId;
    private String DistrictName;
    private int CityId;
    private String CityName;
    private int CountryId;
    private String CountryName;

    public Location(int DistrictId,String DistrictName,int CityId,String CityName,int CountryId,String CountryName){
        this.DistrictId=DistrictId;
        this.DistrictName=DistrictName;
        this.CityId=CityId;
        this.CityName=CityName;
        this.CountryId=CountryId;
        this.CountryName=CountryName;
    }


    public int getDistrictId() {
        return DistrictId;
    }

    public void setDistrictId(int districtId) {
        DistrictId = districtId;
    }

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String districtName) {
        DistrictName = districtName;
    }

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int cityId) {
        CityId = cityId;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }
}
