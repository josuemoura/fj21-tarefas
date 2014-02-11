package br.com.caelum.tarefa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefa.modelo.Tarefa;

public class CarregarTarefa {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		Tarefa tarefaEncontrada = manager.find(Tarefa.class, 1L);
		System.out.println(tarefaEncontrada.getDescricao());
		
		manager.close();
	}
}
