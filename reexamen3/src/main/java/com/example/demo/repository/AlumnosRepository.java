package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Alumnos;

@Repository
public interface AlumnosRepository extends JpaRepository<Alumnos, Long> {

}
