package com.alkemy.disneyworld.repository;

import com.alkemy.disneyworld.entity.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long> {
}
