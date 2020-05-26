package com.uca.capas.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	LibroDAO libroDAO;
	
	@Autowired
	CategoriaService categoriaService;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDAO.findAll();
	}

	@Override
	public Libro findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDAO.findOne(code);
	}

	@Override
	@Transactional
	public void insert(Libro libro) throws DataAccessException {
		// TODO Auto-generated method stub
		Date fFecha = new Date();
		libro.setFechaIngreso(fFecha);
		libro.setCategoria(categoriaService.findOne(libro.getC_categoria()));
		libroDAO.insert(libro);
		
		
	}

}
