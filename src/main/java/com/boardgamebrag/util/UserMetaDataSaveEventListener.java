package com.boardgamebrag.util;

import java.util.Date;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;

import com.boardgamebrag.model.UserAuditMetaData;

public class UserMetaDataSaveEventListener implements PreInsertEventListener, PreUpdateEventListener {
    
    private static final Log log = LogFactory.getLog(UserMetaDataSaveEventListener.class);
    
    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        if (event.getEntity() instanceof UserAuditMetaData) {
            UserAuditMetaData entity = (UserAuditMetaData) event.getEntity();

            if (entity.getEnteredBy() == null) {
                Long currentUserId = 1L;// SessionUtils.currentUser().getUserId();
                Date now = new Date();
                
                String[] propertyNames = event.getPersister().getEntityMetamodel().getPropertyNames();
                Object[] state = event.getState();
                entity.setEnteredBy(currentUserId);
                entity.setEnteredDate(now);
                setValue(state, propertyNames, "enteredBy", currentUserId, entity);
                setValue(state, propertyNames, "enteredDate", now, entity);
            }
        }

        return false;
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        if (event.getEntity() instanceof UserAuditMetaData) {
            UserAuditMetaData entity = (UserAuditMetaData) event.getEntity();
            
            if (entity.getChangedBy() == null) {
                Long currentUserId = 1L;// SessionUtils.currentUser().getUserId();
                Date now = new Date();
                
                String[] propertyNames = event.getPersister().getEntityMetamodel().getPropertyNames();
                Object[] state = event.getState();
                setValue(state, propertyNames, "enteredBy", entity.getEnteredBy(), entity);
                setValue(state, propertyNames, "enteredDate", entity.getEnteredDate(), entity);
                
                entity.setChangedBy(currentUserId);
                entity.setChangedDate(now);
                setValue(state, propertyNames, "changedBy", currentUserId, entity);
                setValue(state, propertyNames, "changedDate", now, entity);
            }
        }
        return false;
    }

    void setValue(Object[] currentState, String[] propertyNames, String propertyToSet, Object value, Object entity) {
        int index = ArrayUtils.indexOf(propertyNames, propertyToSet);
        if (index >= 0) {
            currentState[index] = value;
        } else {
            log.error("Field '" + propertyToSet + "' not found on entity '" + entity.getClass().getName() + "'.");
        }
    }
}