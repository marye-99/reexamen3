package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cursos;
import com.example.demo.repository.CursosRepository;
import com.example.demo.service.CursosService;

@Service
public class CursosServiceImpl implements CursosService{
	@Autowired
	private CursosRepository cursosRepository;
	
	@Override
	public Cursos create(Cursos c) {
		// TODO Auto-generated method stub
		return cursosRepository.save(c);
	}

	@Override
	public Cursos update(Cursos c) {
		// TODO Auto-generated method stub
		return cursosRepository.save(c);
	}

	@Override
	public Optional<Cursos> read(Long id) {
		// TODO Auto-generated method stub
		return cursosRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cursosRepository.deleteById(id);
		
	}

	@Override
	public List<Cursos> readAll() {
		// TODO Auto-generated method stub
		return cursosRepository.findAll();
	}

}
