package com.suis.bootcamps.service.impl;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.suis.bootcamps.service.RestTemplateService;
import com.suis.bootcamps.service.exception.NotFoundException;

@Service
public class RestTemplateServiceImpl<T, ID> implements RestTemplateService<T, ID> {
    @Override
    public T getEntityById(String endpoint, ID id, Class<T> classType) {
        RestTemplate template = new RestTemplate();

        try {
            ResponseEntity<T> responseEntity = template.getForEntity("http://localhost:3002/" + endpoint + "/" + id,
                    classType);

            if (responseEntity.getStatusCode().equals(HttpStatusCode.valueOf(404)))
                throw new NotFoundException();

            return responseEntity.getBody();
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}
