package model;

/**
 * Classe para armazenar os atributos e m�todos do objeto Locacao
 *
 * @author Diego Almeida da Silva
 * @since 18 de fev. de 2021
 */
public class Locacao {

	// M�todo construtor da classe
	public Locacao() {
	}

	// declarando os atributos 
	private int codigo;
	private Data dataLocacao;
	private Data dataDevolucao;
	private Livro livro[];
	private Usuario usuario;
	
	// M�todos getters e setters para acessar os atributos
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Data getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Data dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public Data getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Data dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public Livro[] getLivro() {
		return livro;
	}
	public void setLivro(Livro[] livro) {
		this.livro = livro;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
