package com.boardgamebrag.model;

import java.util.Date;

import com.boardgamebrag.util.CustomJsonDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class GameSession {
    private Long[] gameIds;
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date scheduleDate;
    private Long[] invitedUserIds;
    
    public Long[] getGameIds() {
        return gameIds;
    }
    public void setGameIds(Long[] gameIds) {
        this.gameIds = gameIds;
    }
    public Date getScheduleDate() {
        return scheduleDate;
    }
    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
    public Long[] getInvitedUserIds() {
        return invitedUserIds;
    }
    public void setInvitedUserIds(Long[] invitedUserIds) {
        this.invitedUserIds = invitedUserIds;
    }
}
