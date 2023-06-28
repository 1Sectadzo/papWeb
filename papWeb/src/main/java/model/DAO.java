package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	
ArrayList<Funcionarios> funcionarios = new ArrayList<>();
ArrayList<Projetos> projetos = new ArrayList<>();
ArrayList<ProjetoFuncionarios> projetoFuncionarios = new ArrayList<>();
	
	private String driver = "com.mysql.jdbc.Driver";
	Funcionarios funcionario = new Funcionarios();
	Projetos projeto = new Projetos();
	ProjetoFuncionarios projetoFuncionario = new ProjetoFuncionarios();
	
	private Connection conectar() throws ClassNotFoundException {
		Connection con = null;
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "pap","root","");
			System.out.println("Conexao estabelecida");
			return con;
		}catch(SQLException erro){
			System.out.println(erro);			
		}
		return con;
	}
	
	public void testarConexao() {
		try {
			Connection con = conectar();
			System.out.print(con);
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//Listar
	
	public ArrayList<Funcionarios> listarFuncionarios(){
		funcionarios.clear();
		String read = "SELECT * FROM funcionarios ORDER BY id";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				funcionarios.add(new Funcionarios(id,nome));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return funcionarios;
	}
	
	public ArrayList<Projetos> listarProjetos(){
		projetos.clear();
		String read = "SELECT * FROM projetos ORDER BY id";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String descricao = rs.getString(3);
				projetos.add(new Projetos(id,nome,descricao));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return projetos;
	}
	
	public ArrayList<ProjetoFuncionarios> listarProjFuncs(ProjetoFuncionarios pf){
		projetoFuncionarios.clear();
		String read = "SELECT * FROM projeto_funcionarios WHERE idProjeto = " + pf.getIdProjeto();
		try {
			Connection con = conectar();	
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String idFuncionario = rs.getString(1);
				String idProjeto = rs.getString(2);
				String nome = rs.getString(3);
				String funcao = rs.getString(4);
				projetoFuncionarios.add(new ProjetoFuncionarios(idFuncionario, idProjeto, nome, funcao));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return projetoFuncionarios;
	}
	
	//Criar
	public void inserirFuncionario(Funcionarios funcionario) {
		String create = "INSERT INTO funcionarios"
				+ "(nome) VALUES(?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, funcionario.getNome());
			pst.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void inserirProjeto(Projetos projeto) {
		String create = "INSERT INTO projetos"
				+ "(nome, descricao) VALUES(?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, projeto.getNome());
			pst.setString(2, projeto.getDescricao());
			pst.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void inserirFuncProj(ProjetoFuncionarios pf) {
		String create = "INSERT INTO projeto_funcionarios"
				+ "(nome, funcao, idFuncionario, idProjeto) VALUES(?,?,?,?)";
		try{
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, pf.getNome());
			pst.setString(2, pf.getFuncao());
			pst.setString(3, pf.getIdFuncionario());
			pst.setString(4, pf.getIdProjeto());
			pst.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//selecionar
	public void selecionarFuncionario(Funcionarios funcionario){
        String read = "SELECT * FROM funcionarios WHERE id = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            pst.setString(1, funcionario.getId());
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
            	funcionario.setId(rs.getString("id"));
            	funcionario.setNome(rs.getString("nome"));
            }            
            con.close();                        
        }catch(Exception e) {
            System.out.println(e);
        }        
    }
	
	public void selecionarProjeto(Projetos projeto) {
		String read = "SELECT * FROM projetos WHERE id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1,projeto.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
            	projeto.setId(rs.getString("id"));
            	projeto.setNome(rs.getString("nome"));
            	projeto.setDescricao(rs.getString("descricao"));
            }            
            con.close(); 
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void selecionarProjFunc(ProjetoFuncionarios pf) {
		String read = "SELECT * FROM projeto_funcionarios WHERE idProjeto = ?"
				+ "AND idFuncionario = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1,pf.getIdProjeto());
			pst.setString(2,pf.getIdFuncionario());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
            	pf.setIdFuncionario(rs.getString("idFuncionario"));
            	pf.setIdProjeto(rs.getString("idProjeto"));
            	pf.setNome(rs.getString("nome"));
            	pf.setFuncao(rs.getString("funcao"));
            }            
            con.close(); 
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	//editar
	public void alterarFuncionario(Funcionarios funcionario) {
        String create = "UPDATE funcionarios"
                    + " SET nome=? WHERE id = ?";
        
        String create1 = "UPDATE projeto_funcionarios"
                + " SET nome=? WHERE idFuncionario = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, funcionario.getNome());
            pst.setString(2,funcionario.getId());
            pst.executeUpdate();
            con.close();
            
            Connection con1 = conectar();
            PreparedStatement pst1 = con1.prepareStatement(create1);
            pst1.setString(1, funcionario.getNome());
            pst1.setString(2,funcionario.getId());
            pst1.executeUpdate();
            con1.close();  
        }catch(Exception e) {
            System.out.println(e);
        }                                
    }
	
	public void alterarProjeto(Projetos projeto) {
		String create = "UPDATE projetos"
                + " SET nome=?, descricao=? WHERE id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1,projeto.getNome());
			pst.setString(2,projeto.getDescricao());
			pst.setString(3,projeto.getId());
			pst.executeUpdate();
			con.close();                 
		}catch(Exception e) {
			System.out.println(e);
		} 
	}
	
	public void alterarFuncProj(ProjetoFuncionarios pf) {
		String create = "UPDATE projeto_funcionarios"
                + " SET funcao=? WHERE idFuncionario = ? AND idProjeto = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1,pf.getFuncao());
			pst.setString(2,pf.getIdFuncionario());
			pst.setString(3,pf.getIdProjeto());
			pst.executeUpdate();
			con.close();                 
		}catch(Exception e) {
			System.out.println(e);
		} 
	}

	
	//excluir
	public void deletarFuncionario(Funcionarios funcionario) {
        String delete = "DELETE FROM funcionarios WHERE id = ?";
    
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setString(1,funcionario.getId());
            pst.executeUpdate();
            con.close();                        
        }catch(Exception e) {
            System.out.println(e);
        }                                
    }
	
	public void deletarProjeto(Projetos projeto) {
        String delete = "DELETE FROM projetos WHERE id = ?";
    
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setString(1,projeto.getId());
            pst.executeUpdate();
            con.close();                        
        }catch(Exception e) {
            System.out.println(e);
        }                                
    }
	
	public void deletarFuncProj(ProjetoFuncionarios pf) {
        String delete = "DELETE FROM projeto_funcionarios WHERE idFuncionario = ?"
        		+ "AND idProjeto = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setString(1,pf.getIdFuncionario());
            pst.setString(2,pf.getIdProjeto());
            pst.executeUpdate();
            con.close();                        
        }catch(Exception e) {
            System.out.println(e);
        }                                
    }
}
