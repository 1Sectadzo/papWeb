package model;

public class ProjetoFuncionarios {
	
    private String nome;
    private String funcao;
    private String idFuncionario;
    private String idProjeto;
	
    public ProjetoFuncionarios() {
        super();
    }

	public ProjetoFuncionarios(String idFuncionario, String idProjeto, String nome, String funcao) {
		super();
		this.nome = nome;
		this.funcao = funcao;
		this.idFuncionario = idFuncionario;
		this.idProjeto = idProjeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(String idProjeto) {
		this.idProjeto = idProjeto;
	}
    
}