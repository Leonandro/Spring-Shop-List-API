package com.project.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository<T, PK> extends JpaRepository<T, PK> {
    /**
     * find all active objects
     *
     * @return objects
     */
    @Override
    @Query(value = "select * from #{#entityName} where active = true", nativeQuery = true)
    List<T> findAll();

    /**
     * find am active object by id
     *
     * @param arg0
     * @return object
     */
    @Override
    @Query(value = "select * from #{#entityName} where id = ?1 and active = true", nativeQuery = true)
    Optional<T> findById(PK arg0);

    /**
     * find a deleted object by id
     *
     * @param arg0
     * @return object
     */
    @Query(value = "select * from #{#entityName} where id = ?1 and active = false", nativeQuery = true)
    Optional<T> findDeletedById(PK arg0);
}