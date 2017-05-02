package com.mptravel.reservation.model;

import com.mptravel.vacation.entity.Vacation;

import java.util.Set;

public class ReservationViewModel {

    private long id;

    private String name;

    private String email;

    private String phoneNumber;

    private int touristsNumber;

    private Set<Vacation> vacations;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getTouristsNumber() {
        return touristsNumber;
    }

    public void setTouristsNumber(int touristsNumber) {
        this.touristsNumber = touristsNumber;
    }

    public Set<Vacation> getVacations() {
        return vacations;
    }

    public void setVacations(Set<Vacation> vacations) {
        this.vacations = vacations;
    }
}
