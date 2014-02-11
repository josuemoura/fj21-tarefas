package br.com.caelum.tarefa.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefa.modelo.Tarefa;

public class AdicionaTarefa {
	public static void main(String [] agrs) {
		Tarefa tarefa = new Tarefa();
		
		tarefa.setDescricao("Estudar JPA E Hibernate");
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();
		System.out.println("Id da tarefa: " + tarefa.getId());
		
		manager.close();
	}
}
