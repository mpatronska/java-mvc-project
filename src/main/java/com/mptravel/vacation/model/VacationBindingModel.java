package com.mptravel.vacation.model;


import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;


public class VacationBindingModel {

    private long id;

    @NotNull
    @Size(min = 5, message = "Invalid title. It should be at least 5 symbols.")
    private String title;

    @NotNull
    @Size(min = 20, message = "Invalid description. It should be at least 20 symbols.")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date endDate;

    @NotNull
    @Size(min = 0, message = "Invalid price. It should be a positive number with precision up to 2 digits after floating point.")
    @Column(precision = 2)
    private double price;

    @Pattern(regexp = "^(http|https)://.+", message = "Invalid image thumbnail. It should start with http://, https:// or be null.")
    private String imageUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
