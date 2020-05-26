package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;

@Controller
public class MainController {
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping("/index")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		String mensaje ="";
		mav.addObject("mensaje", mensaje);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/verLibros")
	public ModelAndView verLibros() {
		ModelAndView mav = new ModelAndView();
		
		List<Libro> libros = null;
		
		try {
			libros = libroService.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		mav.addObject("libros", libros);
		mav.setViewName("listaLibros");
		return mav;
	}
	@RequestMapping("/insertarCategoria")
	public ModelAndView ingresarCategoria() {
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		mav.addObject("categoria", categoria);
		mav.setViewName("agregarCategoria");
		return mav;
	}
	
	@PostMapping("/agregarCategoria")
	public ModelAndView guardarCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.addObject("categoria", categoria);
			mav.setViewName("agregarCategoria");
		}else {
			try { categoriaService.insert(categoria); }
			catch(Exception e) { e.printStackTrace(); }
			String mensaje ="Categoría guardada con éxito";
			mav.addObject("mensaje", mensaje);
			mav.setViewName("index");		
		}
		return mav;
	}
	
	@RequestMapping("/insertarLibro")
	public ModelAndView ingresarLibro() {
		ModelAndView mav = new ModelAndView();
		Libro libro = new Libro();
		List<Categoria> categorias = categoriaService.findAll();
		mav.addObject("categorias", categorias);
		mav.addObject("libro", libro);
		mav.setViewName("agregarLibro");
		return mav;
	}
	
	@PostMapping("/agregarLibro")
	public ModelAndView guardarLibro(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			List<Categoria> categorias = categoriaService.findAll();
			mav.addObject("categorias", categorias);
			mav.addObject("libro", libro);
			mav.setViewName("agregarLibro");
		}else {
			try { libroService.insert(libro); }
			catch(Exception e) { e.printStackTrace(); }
			String mensaje ="Libro guardado con éxito";
			mav.addObject("mensaje", mensaje);
			mav.setViewName("index");		
		}
		return mav;
	}
	
	
	
}
