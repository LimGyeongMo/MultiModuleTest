package com.project.network.request;

public class BusSearchKeyword {

    private String searchGbn;
    private String searchName;
    private String categoryName;
    private String distance;
    private String lon;
    private String lat;
    private String roadAddress;
    private String jibunAddress;
    private String stationId;

    public String getSearchGbn() {
        return searchGbn;
    }

    public void setSearchGbn(String searchGbn) {
        this.searchGbn = searchGbn;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getRoadAddress() {
        return roadAddress;
    }

    public void setRoadAddress(String roadAddress) {
        this.roadAddress = roadAddress;
    }

    public String getJibunAddress() {
        return jibunAddress;
    }

    public void setJibunAddress(String jibunAddress) {
        this.jibunAddress = jibunAddress;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }
}
