package br.com.caelum.tarefa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caelum.tarefa.modelo.Tarefa;

@Repository
public class TarefaDAO {
	
private final Connection connection;
	
	@Autowired
	public TarefaDAO(DataSource dataSource){
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void adiciona(Tarefa tarefa){
		String sql = "insert into tarefas (descricao) " +
					"values (?)";
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			//stmt.setDate(2, new Date(tarefa.getDataFinalizacao().getTimeInMillis())); // Alterado dia 19/03/2013
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Tarefa> lista(){
		try{
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			PreparedStatement stmt = this.connection.prepareStatement
			("select * from tarefas");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				
				if(rs.getDate("dataFinalizacao") != null)
				{
				//montando data atraves do calendar
				Calendar dataFinalizacao = Calendar.getInstance();
				dataFinalizacao.setTime(rs.getDate("dataFinalizacao"));
				
				tarefa.setDataFinalizacao(dataFinalizacao);
				}
				//adicionar objeto a lista
				tarefas.add(tarefa);
			}
			rs.close();
			stmt.close();
			return tarefas;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Tarefa tarefa){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from tarefas where id = ?");
			
			stmt.setLong(1, tarefa.getId());
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Tarefa buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from tarefas");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				if(id == rs.getLong("id"))
				{
					//criando objeto tarefa
					Tarefa tarefa = new Tarefa();
					tarefa.setId(rs.getLong("id"));
					tarefa.setDescricao(rs.getString("descricao"));
					tarefa.setFinalizado(rs.getBoolean("finalizado"));
					
					if(rs.getDate("dataFinalizacao") != null)
					{
						//montando data atraves do calendar
						Calendar dataFinalizacao = Calendar.getInstance();
						dataFinalizacao.setTime(rs.getDate("dataFinalizacao"));
					
						tarefa.setDataFinalizacao(dataFinalizacao);
					}
					return tarefa;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	public void altera(Tarefa tarefa){
		
		String sql = "update tarefas set descricao=?, finalizado=?, dataFinalizacao=? where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			if(tarefa.getDataFinalizacao() != null)
			{
				stmt.setDate(3, new Date
					(tarefa.getDataFinalizacao().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(3, null);
			}
			
			stmt.setLong(4, tarefa.getId());
				
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void finaliza(Tarefa tarefa){
		
		String sql = "update tarefas set finalizado=?, dataFinalizacao=? where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setBoolean(1, true);
			
			stmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			
			stmt.setLong(3, tarefa.getId());
				
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		
	}
}
