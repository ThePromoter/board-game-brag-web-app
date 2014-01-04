package com.boardgamebrag.model;

// Generated Dec 29, 2013 3:45:25 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.*;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * GameResult generated by hbm2java
 */
@Entity
@Table(name = "game_result", catalog = "boardgamebrag_dev", uniqueConstraints = { @UniqueConstraint(columnNames = "source_user_id"), @UniqueConstraint(columnNames = "event_id"), @UniqueConstraint(columnNames = "game_id") })
public class GameResult implements Serializable {

    private Long gameResultId;
    private Game game;
    private User userBySourceUserId;
    private User userByWinningUserId;
    private Event event;
    private Long enteredBy;
    private Date enteredDate;
    private Long changedBy;
    private Date changedDate;

    public GameResult() {
    }

    public GameResult(Game game, User userBySourceUserId, User userByWinningUserId, Event event, Long enteredBy, Date enteredDate) {
        this.game = game;
        this.userBySourceUserId = userBySourceUserId;
        this.userByWinningUserId = userByWinningUserId;
        this.event = event;
        this.enteredBy = enteredBy;
        this.enteredDate = enteredDate;
    }

    public GameResult(Game game, User userBySourceUserId, User userByWinningUserId, Event event, Long enteredBy, Date enteredDate, Long changedBy, Date changedDate) {
        this.game = game;
        this.userBySourceUserId = userBySourceUserId;
        this.userByWinningUserId = userByWinningUserId;
        this.event = event;
        this.enteredBy = enteredBy;
        this.enteredDate = enteredDate;
        this.changedBy = changedBy;
        this.changedDate = changedDate;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "game_result_id", unique = true, nullable = false)
    public Long getGameResultId() {
        return this.gameResultId;
    }

    public void setGameResultId(Long gameResultId) {
        this.gameResultId = gameResultId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", unique = true, nullable = false)
    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_user_id", unique = true, nullable = false)
    public User getUserBySourceUserId() {
        return this.userBySourceUserId;
    }

    public void setUserBySourceUserId(User userBySourceUserId) {
        this.userBySourceUserId = userBySourceUserId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winning_user_id", nullable = false)
    public User getUserByWinningUserId() {
        return this.userByWinningUserId;
    }

    public void setUserByWinningUserId(User userByWinningUserId) {
        this.userByWinningUserId = userByWinningUserId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", unique = true, nullable = false)
    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
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
