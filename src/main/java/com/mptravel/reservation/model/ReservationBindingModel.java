package com.mptravel.reservation.model;

import com.mptravel.vacation.entity.Vacation;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ReservationBindingModel {

    private long id;

    @Size(min = 5, message = "Invalid name. It should be at least 5 symbols.")
    private String name;

    @Pattern(regexp = "^.+[@].+.[.].+$", message =
            "Invalid Email. It should contain @ sign and a period.")
    private String email;

    @Pattern(regexp = "[0-9]{8,}", message = "Invalid phone number. It should be ay least 8 digits.")
    private String phoneNumber;

    @Size(min = 1, message = "Invalid price. It should be a positive number greater or equal to 1.")
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
