package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Alumnos;
import com.example.demo.service.AlumnosService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/alumnos")
@CrossOrigin(origins = "http://localhost:4200")
public class AlumnosController {
	   @Autowired
	    private AlumnosService alumnosService;

	   @GetMapping
	    public ResponseEntity<List<Alumnos>> readAll() {
	        try {
	            List<Alumnos> alumnos = alumnosService.readAll();
	            if (alumnos.isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
	            return new ResponseEntity<>(alumnos, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @PostMapping
	    public ResponseEntity<Alumnos> crear(@Valid @RequestBody Alumnos al) {
	        try {
	            Alumnos a = alumnosService.create(al);
	            return new ResponseEntity<>(a, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Alumnos> getAlumnosById(@PathVariable("id") Long id) {
	        try {
	            Optional<Alumnos> a = alumnosService.read(id);
	            return a.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<HttpStatus> delAlumnos(@PathVariable("id") Long id) {
	        try {
	            alumnosService.delete(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Alumnos> updateAlumnos(@PathVariable("id") Long id, @Valid @RequestBody Alumnos al) {
	        Optional<Alumnos> existingAlumnos = alumnosService.read(id);
	        if (existingAlumnos.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(alumnosService.update(al), HttpStatus.OK);
	        }
	    }
}
