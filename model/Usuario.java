package model;

/**
 * Classe para armazenar os atributos e métodos do objeto Usuario
 *
 * @author Diego Almeida da Silva
 * @since 18 de fev. de 2021
 */
public class Usuario {

	// Método construtor da classe
	public Usuario() {
	}
	
	// declarando os atributos
	private int codigo;
	private String nome;
	private Data dataNascimento;
	private String telefone;
	private String email;
	
	// Métodos getters e setters para acessar os atributos
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Data getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
