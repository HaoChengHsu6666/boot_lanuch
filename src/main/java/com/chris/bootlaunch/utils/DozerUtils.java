package com.chris.bootlaunch.utils;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DozerUtils {

    static Mapper mapper = DozerBeanMapperBuilder.buildDefault();


    //作用於遍歷"原List<T>"，使用Dozer的map方法將其轉換為 "目標List<T>"
    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass){
        List destinationList = Lists.newArrayList();
        for (Iterator i$ = sourceList.iterator(); i$.hasNext();){
            Object sourceObject = i$.next();
            Object destinationObject = mapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;

    }
}
