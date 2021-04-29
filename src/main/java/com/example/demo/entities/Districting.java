package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
public class Districting implements Serializable{
    private String districtingID;

    private List<District> districts;
    private double deviationFromAverage;
    private double deviationFromEnactedPop;
    private double deviationFromEnactedArea;
    private double objectiveFunctionScore;
    private double similarityToEnactedScore;
    private ArrayList<District> majorityMinorityDistricts;
    private int numberOfMajorityMinorityDistricts;
    private double compactness;
    //incumbentDistribution: Map<district: District, List<incumbent>> Ignore
    private int majorityMinorityDistrictsNumber;
    private int populationEqualityDifference;
    private double splitCountyScore;
    private Long tempPopulationByType;
    private HashMap<County, Integer> splitCountyDetails;

    public Districting(){

    }

    public Districting(String districtingID, ArrayList<District> districts){
        this.districtingID = districtingID;
        this.districts = districts;
    }
    @Id
    public String getDistrictingID() {
        return districtingID;
    }

    public void setDistrictingID(String districtingID) {
        this.districtingID = districtingID;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    @Transient
    public double getDeviationFromAverage() {
        return deviationFromAverage;
    }

    public void setDeviationFromAverage(double deviationFromAverage) {
        this.deviationFromAverage = deviationFromAverage;
    }
    @Transient
    public double getDeviationFromEnactedPop() {
        return deviationFromEnactedPop;
    }

    public void setDeviationFromEnactedPop(double deviationFromEnactedPop) {
        this.deviationFromEnactedPop = deviationFromEnactedPop;
    }
    @Transient
    public double getDeviationFromEnactedArea() {
        return deviationFromEnactedArea;
    }

    public void setDeviationFromEnactedArea(double deviationFromEnactedArea) {
        this.deviationFromEnactedArea = deviationFromEnactedArea;
    }
    @Transient
    public double getObjectiveFunctionScore() {
        return objectiveFunctionScore;
    }

    public void setObjectiveFunctionScore(double objectiveFunctionScore) {
        this.objectiveFunctionScore = objectiveFunctionScore;
    }
    @Transient
    public double getSimilarityToEnactedScore() {
        return similarityToEnactedScore;
    }

    public void setSimilarityToEnactedScore(double similarityToEnactedScore) {
        this.similarityToEnactedScore = similarityToEnactedScore;
    }
    @Transient
    public ArrayList<District> getMajorityMinorityDistricts() {
        return majorityMinorityDistricts;
    }

    public void setMajorityMinorityDistricts(ArrayList<District> majorityMinorityDistricts) {
        this.majorityMinorityDistricts = majorityMinorityDistricts;
    }
    @Transient
    public int getNumberOfMajorityMinorityDistricts() {
        return numberOfMajorityMinorityDistricts;
    }

    public void setNumberOfMajorityMinorityDistricts(int numberOfMajorityMinorityDistricts) {
        this.numberOfMajorityMinorityDistricts = numberOfMajorityMinorityDistricts;
    }
    @Transient
    public double getCompactness() {
        return compactness;
    }

    public void setCompactness(double compactness) {
        this.compactness = compactness;
    }
    @Transient
    public int getMajorityMinorityDistrictsNumber() {
        return majorityMinorityDistrictsNumber;
    }

    public void setMajorityMinorityDistrictsNumber(int majorityMinorityDistrictsNumber) {
        this.majorityMinorityDistrictsNumber = majorityMinorityDistrictsNumber;
    }
    @Transient
    public int getPopulationEqualityDifference() {
        return populationEqualityDifference;
    }

    public void setPopulationEqualityDifference(int populationEqualityDifference) {
        this.populationEqualityDifference = populationEqualityDifference;
    }
    @Transient
    public double getSplitCountyScore() {
        return splitCountyScore;
    }

    public void setSplitCountyScore(double splitCountyScore) {
        this.splitCountyScore = splitCountyScore;
    }
    @Transient
    public Long getTempPopulationByType() {
        return tempPopulationByType;
    }

    public void setTempPopulationByType(Long tempPopulationByType) {
        this.tempPopulationByType = tempPopulationByType;
    }
    @Transient
    public HashMap<County, Integer> getSplitCountyDetails() {
        return splitCountyDetails;
    }

    public void setSplitCountyDetails(HashMap<County, Integer> splitCountyDetails) {
        this.splitCountyDetails = splitCountyDetails;
    }
}