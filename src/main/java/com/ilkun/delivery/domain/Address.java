package com.ilkun.delivery.domain;

/**
 *
 * @author alexander-ilkun
 */
public class Address {
    private Integer id;
    private String postcode;
    private String city;
    private String district;
    private String street;
    private String apartments;

    public Address(Integer id, String postcode, String city, String district,
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
