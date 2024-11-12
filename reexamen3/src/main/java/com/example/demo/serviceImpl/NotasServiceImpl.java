package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Notas;
import com.example.demo.repository.NotasRepository;
import com.example.demo.service.NotasService;

@Service
public class NotasServiceImpl implements NotasService {
	 @Autowired
	    private NotasRepository notasRepository;

	    @Override
	    public Notas create(Notas n) {
	        return notasRepository.save(n);
	    }

	    @Override
	    public Notas update(Notas n) {
	        return notasRepository.save(n);
	    }

	    @Override
	    public Optional<Notas> read(Long id) {
	        return notasRepository.findById(id);
	    }

	    @Override
	    public void delete(Long id) {
	        notasRepository.deleteById(id);
	    }

	    @Override
	    public List<Notas> readAll() {
	        return notasRepository.findAll();
	    
	    }
}
