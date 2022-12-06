package com.nightsky.cryptonate.spring.boot.example.service;

import com.nightsky.cryptonate.spring.boot.example.model.SampleEntity;
import com.nightsky.cryptonate.spring.boot.example.repository.SampleEntityRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Chris
 */
@Service
@Transactional
public class DefaultSampleEntityService implements SampleEntityService {

    @Autowired
    private SampleEntityRepository repository;

    @Override
    public SampleEntity create(SampleEntity dto) {
        return repository.save(dto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SampleEntity> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void update(SampleEntity dto) {
        repository.save(dto);
    }

    @Override
    public void delete(SampleEntity dto) {
        SampleEntity se = repository.getById(dto.getId());
        repository.delete(se);
    }

}
