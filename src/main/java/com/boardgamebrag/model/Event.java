package com.boardgamebrag.model;

// Generated Dec 29, 2013 3:45:25 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.*;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Event generated by hbm2java
 */
@Entity
@Table(name = "event", catalog = "boardgamebrag_dev")
public class Event implements Serializable {

    private Long eventId;
    private String name;
    private Long creator;
    private Date date;
    private Long enteredBy;
    private Date enteredDate;
    private Long changedBy;
    private Date changedDate;

    public Event() {
    }

    public Event(Long creator, Date date, Long enteredBy, Date enteredDate) {
        this.creator = creator;
        this.date = date;
        this.enteredBy = enteredBy;
        this.enteredDate = enteredDate;
    }

    public Event(String name, Long creator, Date date, Long enteredBy, Date enteredDate, Long changedBy, Date changedDate) {
        this.name = name;
        this.creator = creator;
        this.date = date;
        this.enteredBy = enteredBy;
        this.enteredDate = enteredDate;
        this.changedBy = changedBy;
        this.changedDate = changedDate;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "event_id", unique = true, nullable = false)
    public Long getEventId() {
        return this.eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    @Column(name = "name", length = 90)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "creator", nullable = false)
    public Long getCreator() {
        return this.creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false, length = 19)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "entered_by", nullable = false)
    public Long getEnteredBy() {
        return this.enteredBy;
    }

    public void setEnteredBy(Long enteredBy) {
        this.enteredBy = enteredBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "entered_date", nullable = false, length = 19)
    public Date getEnteredDate() {
        return this.enteredDate;
    }

    public void setEnteredDate(Date enteredDate) {
        this.enteredDate = enteredDate;
    }

    @Column(name = "changed_by")
    public Long getChangedBy() {
        return this.changedBy;
    }

    public void setChangedBy(Long changedBy) {
        this.changedBy = changedBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "changed_date", length = 19)
    public Date getChangedDate() {
        return this.changedDate;
    }

    public void setChangedDate(Date changedDate) {
        this.changedDate = changedDate;
    }
}