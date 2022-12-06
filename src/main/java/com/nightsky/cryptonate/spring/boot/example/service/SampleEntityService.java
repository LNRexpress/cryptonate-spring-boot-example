package com.nightsky.cryptonate.spring.boot.example.service;

import com.nightsky.cryptonate.spring.boot.example.model.SampleEntity;
import java.util.Optional;

/**
 *
 * @author Chris
 */
public interface SampleEntityService {

    public SampleEntity create(SampleEntity dto);

    public Optional<SampleEntity> getById(Long id);

    public void update(SampleEntity dto);

    public void delete(SampleEntity dto);

}
