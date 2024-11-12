package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Alumnos;
import com.example.demo.repository.AlumnosRepository;
import com.example.demo.service.AlumnosService;

@Service
public class AlumnosServiceImpl implements AlumnosService{
	@Autowired
	private AlumnosRepository alumnosRepository;
	
	
	@Override
	public Alumnos create(Alumnos a) {
		// TODO Auto-generated method stub
		return alumnosRepository.save(a);
	}

	@Override
	public Alumnos update(Alumnos a) {
		// TODO Auto-generated method stub
		return alumnosRepository.save(a);
	}

	@Override
	public Optional<Alumnos> read(Long id) {
		// TODO Auto-generated method stub
		return alumnosRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		alumnosRepository.deleteById(id);
	}

	@Override
	public List<Alumnos> readAll() {
		// TODO Auto-generated method stub
		return alumnosRepository.findAll();
	}

}
