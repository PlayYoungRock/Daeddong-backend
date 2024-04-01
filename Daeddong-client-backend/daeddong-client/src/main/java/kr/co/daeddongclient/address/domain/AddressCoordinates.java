package kr.co.daeddongclient.address.domain;

import lombok.Builder;
import lombok.Getter;
@Getter
public class AddressCoordinates {
    private double  distance; // 오차 범위 (미터)
    private double  latitude; // 위도 변화량
    private double  longitude; // 경도 변화량

    private double latMin;

    private double latMax;

    private double lonMin;

    private double lonMax;


    @Builder
    public AddressCoordinates(double distance,double latitude, double longitude){
        this.distance = distance;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // 1도의 위도 변화량 (약 111km)
    public double latDegreeChange(){
        return distance / 111000.0;
    }

    // 1도의 경도 변화량 (약 111km, 적도에서는 동일하나 극지방에서는 변화)
    public double lonDegreeChange(){
        return distance / (111000.0 * Math.cos(Math.toRadians(latitude)));
    }

    public void latMinValue(){
        latMin = latitude - latDegreeChange();
    }
    public void latMaxValue(){
        latMax = latitude + latDegreeChange();
    }
    public void lonMinValue(){
        lonMin = longitude - lonDegreeChange();
    }
    public void lonMaxValue(){
        lonMax = longitude + lonDegreeChange();
    }




}
