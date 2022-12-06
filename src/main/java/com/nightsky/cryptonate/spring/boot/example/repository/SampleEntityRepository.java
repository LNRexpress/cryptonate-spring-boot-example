package com.nightsky.cryptonate.spring.boot.example.repository;

import com.nightsky.cryptonate.spring.boot.example.model.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Chris
 */
@RepositoryRestResource
public interface SampleEntityRepository extends JpaRepository<SampleEntity, Long> {
}
