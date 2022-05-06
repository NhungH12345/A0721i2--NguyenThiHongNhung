package com.codegym.casestudy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
@Entity
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @NotNull(message = "không được trống")
    private String title;
    private Date start_day;
    private Date end_day;
//    @NotNull(message = "không được trống")
    private int sale;
//    @NotNull(message = "không được trống")
    private String description;
    public KhuyenMai() {
    }

    public KhuyenMai(Long id, String title, Date start_day, Date end_day, int sale, String description) {
        this.id = id;
        this.title = title;
        this.start_day = start_day;
        this.end_day = end_day;
        this.sale = sale;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart_day() {
        return start_day;
    }

    public void setStart_day(Date start_day) {
        this.start_day = start_day;
    }

    public Date getEnd_day() {
        return end_day;
    }

    public void setEnd_day(Date end_day) {
        this.end_day = end_day;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
