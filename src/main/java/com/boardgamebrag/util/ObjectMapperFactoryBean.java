package com.boardgamebrag.util;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactoryBean extends AbstractFactoryBean<ObjectMapper>
{
    public Class<ObjectMapper> getObjectType()
    {
        return ObjectMapper.class;
    }
    
    public ObjectMapper createInstance()
    {
        // create and return ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(Include.NON_DEFAULT);
        
        return mapper;
    }
}