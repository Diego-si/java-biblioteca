package model;

/**
 * Classe para armazenar os atributos e m�todos do objeto Livro
 *
 * @author Diego Almeida da Silva
 * @since 18 de fev. de 2021
 */
public class Livro {

	// M�todo construtor da classe
	public Livro() {
	}
	
	// declarando os atributos
	private int codigo;
	private String titulo;
	private Editora editora;
	private Autor autor;
	private int anoPublicacao;
	private boolean disponivel;


	// M�todos getters e setters para acessar os atributos
	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	
}
