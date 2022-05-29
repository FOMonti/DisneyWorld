package com.alkemy.disneyworld.repository;

import com.alkemy.disneyworld.entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeneroRepository extends JpaRepository<GeneroEntity, Long> {

    @Modifying
    @Query
            (
                    value = "DELETE FROM genero WHERE nombre =?1",
                    nativeQuery = true
            )
    void hardDelete(String id);

    GeneroEntity getByNombre(String nombre);

    Optional<GeneroEntity> findOptionalByNombre(String nombre);
}
