package pe.edu.i202220224.entity;

import jakarta.persistence.*;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ESTRATEGIA DE GENERACION DE PK
    private Integer ID;

    private String Name;
    private String District;
    private Integer Population;

    //MAPEAMOS Y ESTABLECEMOS LA RELACION -------------
    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false) // ESTABLECEMOS LA PK
    private Country country;

    //constructor vacio-------------------
    public City() {
    }

    //cosntrutor llno---------------


    public City(Integer ID, String name, String district, Integer population, Country country) {
        this.ID = ID;
        Name = name;
        District = district;
        Population = population;
        this.country = country;
    }

    //----------------------------

    @Override
    public String toString() {
        return "City{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", District='" + District + '\'' +
                ", Population=" + Population +
                '}';
    }


    //generacion de get and set------------------------

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public Integer getPopulation() {
        return Population;
    }

    public void setPopulation(Integer population) {
        Population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
