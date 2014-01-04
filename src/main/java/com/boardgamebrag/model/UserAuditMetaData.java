package com.boardgamebrag.model;

import java.util.Date;

public interface UserAuditMetaData {
    
    public void setEnteredBy(Long enteredBy);
    public Long getEnteredBy();
    public void setEnteredDate(Date enteredDate);
    public Date getEnteredDate();
    
    public void setChangedBy(Long changedBy);
    public Long getChangedBy();
    public void setChangedDate(Date changedDate);
    public Date getChangedDate();
}
