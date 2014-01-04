package com.boardgamebrag.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class CustomIntegrator implements Integrator {
    
    @SuppressWarnings("unchecked")
    @Override
    public void integrate(Configuration configuration, SessionFactoryImplementor implementor, SessionFactoryServiceRegistry registry) {
        final EventListenerRegistry eventRegistry = registry.getService(EventListenerRegistry.class);

        eventRegistry.prependListeners(EventType.PRE_INSERT, UserMetaDataSaveEventListener.class);
        eventRegistry.prependListeners(EventType.PRE_UPDATE, UserMetaDataSaveEventListener.class);
    }

    @Override
    public void integrate(MetadataImplementor metadata, SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
    }

    @Override
    public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
    }
}
