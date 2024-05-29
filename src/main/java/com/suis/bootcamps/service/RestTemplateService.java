package com.suis.bootcamps.service;

public interface RestTemplateService<T, ID> {
    T getEntityById(String endpoint, ID id, Class<T> classType);
}