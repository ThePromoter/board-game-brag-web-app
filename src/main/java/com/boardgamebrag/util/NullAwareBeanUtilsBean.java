package com.boardgamebrag.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtilsBean;

public class NullAwareBeanUtilsBean extends BeanUtilsBean {
    
    public static void copyPropertiesIgnoreNull(Object dest, Object orig) throws IllegalAccessException, InvocationTargetException {
        NullAwareBeanUtilsBean util = new NullAwareBeanUtilsBean();
        util.copyProperties(dest, orig);
    }
    
    @Override
    public void copyProperty(Object dest, String name, Object value) throws IllegalAccessException, InvocationTargetException {
        if (value == null) return;
        super.copyProperty(dest, name, value);
    }
}
