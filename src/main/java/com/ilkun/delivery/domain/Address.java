package com.ilkun.delivery.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alexander-ilkun
 */
@Entity
@Table(name = "addresses")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postcode;
    private String city;
    private String district;
    private String street;
    private String apartments;

    public Address() {
    }

    public Address(Long id, String postcode, String city, String district,
            String street, String apartments) {
        this.id = id;
        this.postcode = postcode;
        this.city = city;
        this.district = district;
        this.street = street;
        this.apartments = apartments;
    }

    public Address(String postcode, String city, String district,
            String street, String apartments) {
        this.postcode = postcode;
        this.city = city;
        this.district = district;
        this.street = street;
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", postcode=" + postcode + ", city=" + city + ", district=" + district + ", street=" + street + ", apartments=" + apartments + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartments() {
        return apartments;
    }

    public void setApartments(String apartments) {
        this.apartments = apartments;
    }
}
