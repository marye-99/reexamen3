package com.example.demo.controller;

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

import com.example.demo.entity.Notas;
import com.example.demo.service.NotasService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/notas")
@CrossOrigin(origins = "http://localhost:4200")
public class NotasController {
	  @Autowired
	    private NotasService notasService;

	  @GetMapping
	    public ResponseEntity<List<Notas>> readAll() {
	        try {
	            List<Notas> notas = notasService.readAll();
	            if (notas.isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
	            return new ResponseEntity<>(notas, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @PostMapping
	    public ResponseEntity<Notas> crear(@Validated @RequestBody Notas no) {
	        try {
	            Notas n = notasService.create(no);
	            return new ResponseEntity<>(n, HttpStatus.CREATED);
	        } catch (Exception e) {
	        	e.printStackTrace();
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Notas> getNotasById(@PathVariable("id") Long id) {
	        try {
	            Optional<Notas> n = notasService.read(id);
	            return n.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<HttpStatus> delNotas(@PathVariable("id") Long id) {
	        try {
	            notasService.delete(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Notas> updateNotas(@PathVariable("id") Long id, @Validated @RequestBody Notas no) {
	        Optional<Notas> existingNotas = notasService.read(id);
	        if (existingNotas.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(notasService.update(no), HttpStatus.OK);
	        }
	    }
}
