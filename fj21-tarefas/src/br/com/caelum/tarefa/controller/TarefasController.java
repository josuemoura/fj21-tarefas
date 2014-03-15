package br.com.caelum.tarefa.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.tarefa.dao.TarefaDAO;
import br.com.caelum.tarefa.modelo.Tarefa;

@Controller
public class TarefasController {

	private TarefaDAO dao;

	@Autowired
	public TarefasController(TarefaDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("listaTarefas")
	public ModelAndView lista(Model model) {
		ModelAndView mv = new ModelAndView();
		model.addAttribute("tarefas",dao.lista());
		mv.setViewName("tarefa/lista");
		return mv;
	}
	
	@RequestMapping("novaTarefa")
	public ModelAndView formulario() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tarefa/formulario");//Alteração feita em 19/03/2013
		return mv;
	}

	@RequestMapping("adicionaTarefa")
	public ModelAndView adiciona(@Valid Tarefa tarefa, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasFieldErrors("descricao")) {
			mv.setViewName("tarefa/formulario");
			return mv;
		}
		dao.adiciona(tarefa);
		mv.setViewName("tarefa/adicionada");
		return mv;
	}
	
	
	@RequestMapping("removeTarefa")
	public ModelAndView remove(Long id) {
		Tarefa tarefa = dao.buscaPorId(id);
		if(tarefa != null) {
			dao.remove(tarefa);
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:listaTarefas");
		return mv;
	}
	
	@RequestMapping(value="mostraTarefa/**", method = RequestMethod.GET)
	public ModelAndView mostra(HttpServletRequest request, Model model) {
		
		ModelAndView mv = new ModelAndView();
		String id = request.getParameter("id");
		Pattern pattern = Pattern.compile("[a+z]+\\s");
		Matcher matcher = pattern.matcher(id);
		
		// Se nao achar caracter faca 
		if(!matcher.find()) {
			Tarefa tarefa = dao.buscaPorId(Long.valueOf(id));
			if(tarefa!=null) {
				System.out.println("Sem caracter");
				model.addAttribute("tarefa", tarefa);
				mv.setViewName("tarefa/mostra");
			} else {
				mv.setViewName("forward:listaTarefas");
			}
		} else {
			mv.setViewName("forward:listaTarefas");
			return mv;
		}
		return mv;
	}
	
	@RequestMapping("alteraTarefa")
	public ModelAndView altera(Tarefa tarefa) {
		ModelAndView mv = new ModelAndView();
		dao.altera(tarefa);
		mv.setViewName("forward:listaTarefas");
		return mv;
	}
	
	@RequestMapping("finalizaTarefa")
	public ModelAndView finaliza(Long id, Model model) {
		ModelAndView mv = new ModelAndView();
		Tarefa tarefa = dao.buscaPorId(id);
		dao.finaliza(tarefa);
		model.addAttribute("tarefa", dao.buscaPorId(id));
		mv.setViewName("tarefa/finalizada");
		return mv;
	}
}
