package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class precint  {
    private String districtID;
    private String precintID;
    private String countyID;
    private ArrayList<precint> neighbours;
    private double compactness;
    private ArrayList< ArrayList<Double> > coordinates;







    public precint() {
    }

    public precint(String districtID, String precintID, String countyID, ArrayList<ArrayList<Double>> coordinates) {
        this.districtID = districtID;
        this.precintID = precintID;
        this.countyID = countyID;
        this.coordinates = coordinates;
    }

    public precint(String districtID, String precintID, String countyID, ArrayList<precint> neighbours, double compactness, ArrayList<ArrayList<Double>> coordinates) {
        this.districtID = districtID;
        this.precintID = precintID;
        this.countyID = countyID;
        this.neighbours = neighbours;
        this.compactness = compactness;
        this.coordinates = coordinates;
    }

    @Id
//    @SequenceGenerator(
//            name ="precint_sequence",
//            sequenceName = "precint_sequence",
//            allocationSize = 1
//
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "precint_sequence"
//    )
    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public String getPrecintID() {
        return precintID;
    }

    public void setPrecintID(String precintID) {
        this.precintID = precintID;
    }

    public String getCountyID() {
        return countyID;
    }

    public void setCountyID(String countyID) {
        this.countyID = countyID;
    }

    @ManyToMany
    public ArrayList<precint> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<precint> neighbours) {
        this.neighbours = neighbours;
    }

    @Transient
    public double getCompactness() {
        return compactness;
    }

    public void setCompactness(double compactness) {
        this.compactness = compactness;
    }

    @ElementCollection
    public ArrayList<ArrayList<Double>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<ArrayList<Double>> coordinates) {
        this.coordinates = coordinates;
    }

}
