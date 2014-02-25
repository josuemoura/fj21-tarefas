package br.com.caelum.tarefa.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.tarefa.modelo.Tarefa;

@Repository
public class JpaTarefaDAO implements ITarefaDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public Tarefa buscaPorId(Long id) {
		return manager.find(Tarefa.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Tarefa> lista() {
		return manager.createQuery("select t from Tarefa t").getResultList();
	}

	public void adiciona(Tarefa tarefa) {
		manager.persist(tarefa);
	}

	public void altera(Tarefa tarefa) {
		manager.merge(tarefa);
	}

	public void remove(Tarefa tarefa) {
		manager.remove(manager.getReference(Tarefa.class, tarefa.getId()));
	}

	public void finaliza(Long id) {
		Tarefa tarefa = buscaPorId(id);
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());
	}

}
