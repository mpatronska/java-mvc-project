package com.mptravel.reservation.model;

import com.mptravel.vacation.entity.Vacation;

public class ReservationViewModel {

    private long id;

    private String name;

    private String email;

    private String phoneNumber;

    private int touristsNumber;

    private Vacation vacation;

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

    public Vacation getVacation() {
        return vacation;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
    }
}
