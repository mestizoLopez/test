package com.mestizo.utils;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class Utils {

    public static <T> void algo(T obj, T objDto){

    }

    public static <T> T algoMas(Class<T> objDto) throws Exception {
        return objDto.getDeclaredConstructor().newInstance();
    }

    public static <T> T convertToEntity(Object dto, Class<T> entityClass) {
        T entity  = null;
        try {
            entity = entityClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(dto,entity);
        return entity;
    }

    public static <T> T convertToDto(Object entity, Class<T> dtoClass) {
        T dto  = null;
        try {
            dto = dtoClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

}
