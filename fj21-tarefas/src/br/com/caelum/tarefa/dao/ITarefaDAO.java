package br.com.caelum.tarefa.dao;

import java.util.List;

import br.com.caelum.tarefa.modelo.Tarefa;

public interface ITarefaDAO {
	Tarefa buscaPorId(Long id);

	List<Tarefa> lista();

	void adiciona(Tarefa tarefa);

	void altera(Tarefa tarefa);

	void remove(Tarefa tarefa);

	void finaliza(Long id);
}
