package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Precinct implements Serializable{

    private District defaultDistrictID;
    private List<District> DistrictCollection;
    private String precinctID;
    private Long totalPopulation;
    private Long AfricanAmericanPopulation;
    private Long AsianPopulation;
    private Long HispanicPopulation;
    private County countyID;
    private List<Precinct> neighbours;
    private double compactness;
    @ElementCollection
    private ArrayList< ArrayList<Double> > coordinates;
    private String incumbentName;

    private Boolean onEdge; //map by index to the list of districts DistrictID

    private String currentDistrictingId;

    private String currentDistrictId = this.defaultDistrictID.getDistrictID();


    public Precinct() {
    }

    public Precinct(String precinctID) {
        this.precinctID = precinctID;
    }

    public Precinct(String precinctID, Long totalPopulation) {
        this.precinctID = precinctID;
        this.totalPopulation = totalPopulation;
    }

    public Precinct(String precinctID, List<Precinct> neighbours) {
        this.precinctID = precinctID;
        this.neighbours = neighbours;
    }

//    public Precinct(String precinctID, Long totalPopulation, Long AfricanAmericanPopulation, Long AsianPopulation, Long HispanicPopulation, List<S> neighbours, ArrayList<ArrayList<Double>> coordinates) {
//        this.precinctID = precinctID;
//        this.totalPopulation = totalPopulation;
//        this.AfricanAmericanPopulation = AfricanAmericanPopulation;
//        this.AsianPopulation = AsianPopulation;
//        this.HispanicPopulation = HispanicPopulation;
//        this.neighbours = neighbours;
//        this.coordinates = coordinates;
//    }
//
//    public Precinct(String precinctID, Long totalPopulation, Long AfricanAmericanPopulation, Long AsianPopulation, Long HispanicPopulation, County countyID, ArrayList<String> neighbours, ArrayList<ArrayList<Double>> coordinates) {
//        this.precinctID = precinctID;
//        this.totalPopulation = totalPopulation;
//        this.AfricanAmericanPopulation = AfricanAmericanPopulation;
//        this.AsianPopulation = AsianPopulation;
//        this.HispanicPopulation = HispanicPopulation;
//        this.countyID = countyID;
//        this.neighbours = neighbours;
//        this.coordinates = coordinates;
//    }

    //    @SequenceGenerator(
//            name ="precinct_sequence",
//            sequenceName = "precinct_sequence",
//            allocationSize = 1
//
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "precinct_sequence"
//    )



    @Id
    public String getPrecinctID() {
        return precinctID;
    }

    public void setPrecinctID(String precinctID) {
        this.precinctID = precinctID;
    }

    public District getDefaultDistrictID() {
        return defaultDistrictID;
    }

    public void setDefaultDistrictID(District defaultDistrictID) {
        this.defaultDistrictID = defaultDistrictID;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    public List<District> getDistrictCollection() {
        return DistrictCollection;
    }

    public void setDistrictCollection(List<District> districtID) {
        DistrictCollection = districtID;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public County getCountyID() {
        return countyID;
    }


    public String getIncumbentName() {
        return incumbentName;
    }

    public void setIncumbentName(String incumbentName) {
        this.incumbentName = incumbentName;
    }

    public void setCountyID(County countyID) {
        this.countyID = countyID;
    }

    public Long getTotalPopulation() {
        return totalPopulation;
    }

    public void setTotalPopulation(Long totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public Long getAfricanAmericanPopulation() {
        return this.AfricanAmericanPopulation;
    }

    public void setAfricanAmericanPopulation(Long africanAmericanPopulation) {
        AfricanAmericanPopulation = africanAmericanPopulation;
    }

    public Long getAsianPopulation() {
        return AsianPopulation;
    }

    public void setAsianPopulation(Long asianPopulation) {
        AsianPopulation = asianPopulation;
    }

    public Long getHispanicPopulation() {
        return HispanicPopulation;
    }

    public void setHispanicPopulation(Long hispanicPopulation) {
        HispanicPopulation = hispanicPopulation;
    }

//    public District getDistrictID() {
//        return districtID;
//    }
//
//    public void setDistrictID(District districtID) {
//        this.districtID = districtID;
//    }

    @ManyToMany()
    public List<Precinct> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Precinct> neighbours) {
        this.neighbours = neighbours;
    }

    @Transient
    public double getCompactness() {
        return compactness;
    }

    public void setCompactness(double compactness) {
        this.compactness = compactness;
    }


    public ArrayList<ArrayList<Double>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<ArrayList<Double>> coordinates) {
        this.coordinates = coordinates;
    }


    @Transient
    public String getCurrentDistrictingId() {
        return currentDistrictingId;
    }

    public void setCurrentDistrictingId(String currentDistrictingId) {
        this.currentDistrictingId = currentDistrictingId;
        for (int i = 0; i < this.getDistrictCollection().size(); i++){
            District district = this.getDistrictCollection().get(i);
            if (district.getDistrictingID().getDistrictingID() == currentDistrictingId){
                this.setCurrentDistrictId(district.getDistrictID());
                break;
            }
        }
    }

    @Transient
    public String getCurrentDistrictId() {
        return currentDistrictId;
    }

    public void setCurrentDistrictId(String currentDistrictId) {
        this.currentDistrictId = currentDistrictId;
    }

    @Transient
    public Boolean getOnEdge() {
        return onEdge;
    }

    public void setOnEdge(Boolean onEdge) {
        this.onEdge = onEdge;
    }

    public void onEdge(){
        for (int i = 0; i < this.getNeighbours().size(); i++){
            Precinct neighbour = this.getNeighbours().get(i);
            if (this.getCurrentDistrictId() == neighbour.getCurrentDistrictId()){
                this.setOnEdge(false);
            }
            else{
                this.setOnEdge((true));
                break;
            }
        }
    }



//    /*calculates the arrayList of on edge*/
//    public void onEdge(){
//        for (int i = 0; i < this.getDistrictID().size(); i++){
//            boolean onEdge = false;
//            District currentDistrict = this.getDistrictID().get(i);
//            String districtingID = currentDistrict.getDistrictingID();
//            for (int j = 0; j < this.getNeighbours().size(); j++){
//                Precinct neighbour = this.getNeighbours().get(j);
//                for (int k = 0; k < neighbour.getDistrictID().size(); k++){
//                    District neighbourDistrict = neighbour.getDistrictID().get(k);
//                    String neighbourDistrictingID = neighbourDistrict.getDistrictingID();
//                    if (districtingID == neighbourDistrictingID){
//                        if(currentDistrict.getDistrictID() != neighbourDistrict.getDistrictID()){
//                            this.getOnEdge().add(i, true);
//                        }
//                        else{
//                            this.getOnEdge().add(i, false);
//                        }
//                    }
//                }
//            }
//        }
//    }

}
