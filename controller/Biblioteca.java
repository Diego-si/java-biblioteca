package controller;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import model.Autor;
import model.Data;
import model.Editora;
import model.Livro;
import model.Locacao;
import model.Usuario;

/**
 * Classe para armazenar os atributos e m�todos do objeto Biblioteca
 *
 * @author Diego Almeida da Silva
 * @since 18 de fev. de 2021
 */
public class Biblioteca {

	// vetor para armazena os livros cadastrados
	private Livro livros[];

	// vetor para armazenar os clientes
	private Usuario usuarios[];

	// vetor para armazenar as locacoes feitas
	private Locacao locacoes[];

	// variaveis de controle para os tamanho
	private int tamanhoLivros = 0;
	private int tamanhoUsuarios = 0;
	private int tamanhoLocacoes = 0;
	// variavel para receber o codigo do usuario
	private int codigoTeste = 0;

	// m�todo construtor Biblioteca
	public Biblioteca() {
		processando();
	}

	// m�todo principal do programa
	public void processando() {
		// obtendo o tamanho de cadastro de livros
		tamanhoLivros = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de livros: "));

		// atribuindo o tamanho de cadastro de livros
		livros = new Livro[tamanhoLivros];

		// obtendo o tamanho de cadastro de usuarios
		tamanhoUsuarios = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de usu�rios: "));

		// atribuindo o tamanho de cadastro de usuarios
		usuarios = new Usuario[tamanhoUsuarios];

		// obtendo o tamanho dos livros que quer locar
		tamanhoLocacoes = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de loca��es: "));

		// setando o tamanho da loca��o em locacoes
		locacoes = new Locacao[tamanhoLocacoes];

		// looping para o processamento
		while (true) {
			desejoMenu();
		}
	}

	// m�todo para obeter a op��o do usuario
	public void desejoMenu() {
		String hamburguer = "Escolha uma op��o:\n\n" + "OP��O 1: Cadastrar livro\n" + "OP��O 2: Cadastrar usu�rio\n"
				+ "OP��O 3: Efetuar loca��o de livros\n" + "OP��O 4: Efetuar devolu��o de livros\n"
				+ "OP��O 5: Listar todos os livros cadastrados\n" + "OP��O 6: Listar todos os usu�rios cadastrados\n"
				+ "OP��O 7: Pesquisar livros por editora\n" + "OP��O 8: Pesquisar livros por autor\n"
				+ "OP��O 9: Pesquisar loca��es por data\n" + "OP��O 10: Sair do sistema";

		int desejo = Integer.parseInt(JOptionPane.showInputDialog(hamburguer));
		desejoProcessa(desejo);
	}

	// m�todo para indicar a opniao do usuario
	public void desejoProcessa(int opniao) {
		switch (opniao) {
		case 1:
			cadastrarLivro();
			break;

		case 2:
			cadastrarUsuario();
			break;

		case 3:
			efetuarLocacaoDeLivros();
			break;

		case 4:
			efetuarDevolucaoDeLivros();
			break;

		case 5:
			listarTodosOsLivrosCadastrados();
			break;

		case 6:
			listarTodosOsUsuariosCadastrados();
			break;

		case 7:
			pesquisarLivrosPorEditora();
			break;

		case 8:
			pesquisarLivrosPorAutor();
			break;

		case 9:
			pesquisarLocacoesPorData();
			break;

		case 10:
			sairDoSistema();
			break;

		default:
			JOptionPane.showMessageDialog(null, "Op��o inv�lida!", "BIBLIOTECA", 0);// 0 == erro
			break;
		}
	}

	// m�todo para efetuar o cadastro de um novo livro
	public void cadastrarLivro() {
		// variavel auxiliar para verificar se ja foi salvo o livro
		boolean salvo = false;

		// loop para verificar se tem espa�o para mais livros
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] == null) {
				livros[i] = novoLivro();
				salvo = true;
				break;
			}
		}

		// exibindo para o usuarioa o resultado
		if (salvo) {
			JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso", "Cadastro de Livros", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Estoque cheio de livros", "Cadastro de Livros", 2);
		}
	} // fim do m�todo cadastraLivros

	// m�todo para armazenar um livros
	public Livro novoLivro() {
		// inicializando os objeto
		Editora editora = new Editora();
		Data data = new Data();
		Autor autor = new Autor();
		Livro livro = new Livro();

		// recebendo os dados da editora
		editora.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo da Editora")));
		editora.setNome(JOptionPane.showInputDialog("Informe o nome da Editora"));
		editora.setPais(JOptionPane.showInputDialog("Informe o nome do Pa�s"));

		// recebendo a data
		data.setDia(Integer.parseInt(JOptionPane.showInputDialog("Informe o dia do cadastro:")));
		data.setMes(Integer.parseInt(JOptionPane.showInputDialog("Informe o m�s do cadastro:")));
		data.setAno(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do cadastro:")));

		// recebendo os dados do Autor
		autor.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do Autor")));
		autor.setNome(JOptionPane.showInputDialog("Informe o nome do Autor"));
		autor.setNacionalidade(JOptionPane.showInputDialog("Informe a nacionalidade do Autor"));

		// recebendo dados do livro
		livro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do livro")));
		livro.setTitulo(JOptionPane.showInputDialog("Informe o titulo do livro"));
		livro.setAnoPublicacao(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de publica��o do livro")));

		// atribuindo editora ao livro
		livro.setEditora(editora);

		// atribuindo autor ao livro
		livro.setAutor(autor);

		// o usuario vai informa se o livro esta disponivel para locacao ou nao
		int disponivel = Integer.parseInt(
				JOptionPane.showInputDialog("1 - Dispon�vel para loca��o\n" + "2 - N�o dispon�vel para loca��o"));

		// atribuindo a opcao de de disponivel para locacao
		if (disponivel == 1) {
			livro.setDisponivel(true);
		} else {
			livro.setDisponivel(false);
		}

		return livro;
	}

	// m�todo para cadastrar usuario
	public void cadastrarUsuario() {
		// variavel auxiliar para verificar se ja foi salvo o usuario
		boolean salvoUsuario = false;

		// loop para verificar se tem espa�o para mais Usuarios
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] == null) {
				usuarios[i] = novoUsuario();
				salvoUsuario = true;
				break;
			}
		}

		// exibindo para o usuario o resultado
		if (salvoUsuario) {
			JOptionPane.showMessageDialog(null, "Usuario cadastrados com sucesso", "Cadastro de Usuarios", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Atingiu o limite de Usuarios", "Cadastro de Usuarios", 2);
		}
	} // fim do m�todo cadastraUsuario

	// m�todo para cadastrar um Usuario
	public Usuario novoUsuario() {
		// inicializando os objeto
		Usuario usuario = new Usuario();
		Data data = new Data();

		// recebendo os dados do usuario
		usuario.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do usu�rio")));
		usuario.setNome(JOptionPane.showInputDialog("Informe o nome do usu�rio"));
		usuario.setTelefone(JOptionPane.showInputDialog("Informe o telefone do usu�rio"));
		usuario.setEmail(JOptionPane.showInputDialog("Informe o email do usu�rio"));

		// recebendo a data
		data.setDia(Integer.parseInt(JOptionPane.showInputDialog("Informe o dia do seu nascimento:")));
		data.setMes(Integer.parseInt(JOptionPane.showInputDialog("Informe o m�s do seu nascimento:")));
		data.setAno(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do seu nascimento:")));

		// usuario recebendo data
		usuario.setDataNascimento(data);

		return usuario;
	}

	// m�todo para Efetuar loca��o de livros
	public void efetuarLocacaoDeLivros() {
		// inicializando o objeto Locacao
		Locacao locacao = new Locacao();

		// inicializando o objeto data
		Data data = new Data();

		// criando vetor de livrosLocacao
		Livro livrosLocacao[];

		// inicializando a mensagem de exibi��o
		String mensagem = "";

		// recebendo codigo de usuario
		int codigoUsuario = Integer.parseInt(JOptionPane.showInputDialog("Informe seu codigo de usuario"));

		// boolean para auxiliar na conprova��o do for
		boolean aux = false;

		// for para verificar se o codigo que o usuario passou existe usuario igual
		for (int i = 0; i < usuarios.length; i++) {
			if ((usuarios[i] != null) && (usuarios[i].getCodigo() == codigoUsuario)) {
				locacao.setUsuario(usuarios[i]);
				aux = true;
			}
		}
		// se o usuario tiver codigo igual e usado o boolean para entrar neste if
		if (aux) {

			// recebendo o tamanho de quantos livros vai locar
			int tamanhoLocacao = Integer.parseInt(JOptionPane.showInputDialog("Informe quantos livros quer alugar"));

			// inicializando o objeto de livrosLocado com a quantidade de livros que vai
			livrosLocacao = new Livro[tamanhoLocacao];

			// for para verificar se o livro esta disponivel para locacao
			for (int i = 0; i < tamanhoLocacao; i++) {
				for (int j = 0; j < livros.length; j++) {
					if ((livros[j] != null) && (livros[j].isDisponivel() == true)) {
						mensagem += "Codigo: " + livros[j].getCodigo() + " - " + livros[j].getTitulo() + "\n";

					}

				}

				// recebendo o codigo de qual livro quer alugar
				int auxLivro = Integer.parseInt(
						JOptionPane.showInputDialog("Informe o codigo do livro que voc� quer locar\n" + mensagem));

				// auxiliar para validar o livro locado
				boolean auxiliarLivroLocado = false;

				// for para verificar a existencia do codigo e se pode locar
				for (int j = 0; j < livros.length; j++) {
					if ((livros[j] != null) && (livros[j].getCodigo() == auxLivro)
							&& (livros[j].isDisponivel() == true)) {
						livros[j].setDisponivel(false);
						auxiliarLivroLocado = true;

						// setando na posicao i dos llivros o livros da posicao j , o livros que foi
						// locado
						livrosLocacao[i] = livros[j];

						// pegando a data local do momento em que o livro foi devolvido
						GregorianCalendar calenda = new GregorianCalendar();
						int dia = calenda.get(GregorianCalendar.DAY_OF_MONTH);
						int mes = calenda.get(GregorianCalendar.MONTH);
						int ano = calenda.get(GregorianCalendar.YEAR);

						// setando os dia mes ano
						data.setDia(dia);
						data.setMes(mes + 1);
						data.setAno(ano);
						// setando a data
						locacao.setDataLocacao(data);

					}

					mensagem = "";
				}
				// validando a locacao do livro
				if (auxiliarLivroLocado) {
					codigoTeste++;
					JOptionPane.showMessageDialog(null, "Livro alugado com sucesso", "BIBLIOTECA", 1);
				} else {
					JOptionPane.showMessageDialog(null, "Livro n�o disponivel", "BIBLIOTECA", 2);
				}

			}

			// setando qual livro foi locado
			locacao.setLivro(livrosLocacao);
			// setando o codigo do usuario em locacao
			locacao.setCodigo(codigoTeste);

			// for para setar na posicao se for null o valor da locacao
			for (int i = 0; i < locacoes.length; i++) {
				if (locacoes[i] == null) {
					locacoes[i] = locacao;
					break;
				}
			}

		}
		// caso o usuario nao esteja cadastrado
		else {
			JOptionPane.showMessageDialog(null, "Usuario n�o cadastrado");
		}

	}

	// m�todo para Efetuar devolu��o de livros
	public void efetuarDevolucaoDeLivros() {

		// inicializando os objeto
		Locacao locacao = new Locacao();
		Data data = new Data();

		// mensagem para exibicao
		String mensagem = "";

		// contador dos codigos
		int valor = 0;
		// variavel para receber o codigo do usuario
		// int codigoUsuario = 0;

		// recebendo o codigo do usuario
		int codigoUsuario = Integer.parseInt(JOptionPane.showInputDialog("Informe seu codigo de usuario"));

		// boolean para ajudar na validacao
		boolean aux = false;

		// for para verificar de o codigo e igual ao que o usuario informou
		for (int i = 0; i < locacoes.length; i++) {
			if ((locacoes[i] != null) && (locacoes[i].getUsuario().getCodigo() == codigoUsuario)) {
				aux = true;
				valor = i;
			}
		}
		// validando a informa��o do codigo
		if (aux) {

			// boolean para ajudar na validacao
			boolean auxiliarLivroDevolvido = false;

			// for para verificar se o codigo do livro e igual ao qual o usuario passou
			for (int j = 0; j < locacoes.length; j++) {
				if ((locacoes[j] != null) && (locacoes[j].getUsuario().getCodigo() == codigoUsuario)) {
					for (int i = 0; i < locacoes[j].getLivro().length; i++) {
						mensagem += "C�digo " + locacoes[i].getLivro()[j].getCodigo() + " - "
								+ locacoes[j].getLivro()[i].getTitulo() + "\n";
					}
				}
			}

			// recebendo o codigo de qual livro vai devolver
			int auxLivro = Integer.parseInt(
					JOptionPane.showInputDialog(mensagem + "Informe o codigo do livro que voc� quer devolver \n"));

			for (int j = 0; j < livros.length; j++) {
				if (livros[j] != null && livros[j].getCodigo() == auxLivro && livros[j].isDisponivel() == false) {
					// setando o livro como disponivel apos ser devolvido
					livros[j].setDisponivel(true);
					auxiliarLivroDevolvido = true;

					// pegando a data local do momento em que o livro foi devolvido
					GregorianCalendar calenda = new GregorianCalendar();
					int dia = calenda.get(GregorianCalendar.DAY_OF_MONTH);
					int mes = calenda.get(GregorianCalendar.MONTH);
					int ano = calenda.get(GregorianCalendar.YEAR);

					// setando os dia mes ano
					data.setDia(dia);
					data.setMes(mes + 1);
					data.setAno(ano);

					// setando a data de devolucao
					locacao.setDataDevolucao(data);
				}
			}

			// exibindo sobre a validacao da devolucao do livro
			if (auxiliarLivroDevolvido) {
				locacoes[valor] = null;
				JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso", "BIBLIOTECA", 1);
			} else {
				JOptionPane.showMessageDialog(null, "Livro nao devolvido", "BIBLIOTECA", 2);
			}
			// caso nao tenha usuario
		} else {
			JOptionPane.showMessageDialog(null, "Usuario n�o cadastrado");
		}
	}

	// m�todo para Listar todos os livros cadastrados
	public void listarTodosOsLivrosCadastrados() {

		// variavel auxiliar para exibir dados livros
		String mensagem = "";

		// auxiliar na valida��o dos livros
		boolean auxiliarListaLivro = false;

		// for para verificar se tem livros
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null) {
				mensagem += "T�tulo - " + livros[i].getTitulo() + " - " + " Autor: " + livros[i].getAutor().getNome()
						+ "\n";
				auxiliarListaLivro = true;
			}
		}
		// auxiliar na valida��o dos livros cadastrados
		if (auxiliarListaLivro) {
			JOptionPane.showMessageDialog(null, mensagem, "Livros Cadastrado", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum livros cadastrado", "BIBLIOTECA", 2);
		}
	}

	// m�todo para Listar todos os usu�rios cadastrados
	public void listarTodosOsUsuariosCadastrados() {

		// variavel auxiliar para exibir dados usuario
		String mensagem = "";

		// boolean para auxiliar na valida��o do usuario
		boolean auxiliarListaUsuario = false;

		// for para verificar se tem usuarios
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				mensagem += "Codigo " + usuarios[i].getCodigo() + " - " + "Nome " + " - " + usuarios[i].getNome() + "\n"
						+ "Data de nascimento " + usuarios[i].getDataNascimento() + "Telefone"
						+ usuarios[i].getTelefone() + "Email " + usuarios[i].getEmail() + "\n\n";
				auxiliarListaUsuario = true;
			}
		}
		// validando a informa�ao se existe usuario
		if (auxiliarListaUsuario) {
			JOptionPane.showMessageDialog(null, mensagem, "Usu�rios Cadastrados", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum usu�rio cadastrado", "BIBLIOTECA", 2);
		}
	}

	// m�todo para Pesquisar livros por editora
	public void pesquisarLivrosPorEditora() {

		// recebendo qual editora pesquisar
		String editora = JOptionPane.showInputDialog("Informe qual a editora procurar");

		// variavel auxiliar para exibir a mensagem
		String mensagem = "Pesquisa por Editora\n\n";

		// variavel auxiliar para verificar se existe editora
		boolean tem = false;

		// percorrendo o vetor e verificando a editora
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null && livros[i].getEditora().getNome().equals(editora)) {
				mensagem += mensagem(livros[i]);
				tem = true;
			}
		}

		// exibindo o resultado da pesquisa ao usuario
		if (tem) {
			JOptionPane.showMessageDialog(null, mensagem, "BIBLIOTECA", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Editora n�o encontrada", "BIBLIOTECA", 2);
		}

	}

	// m�todo para Pesquisar livros por autor
	public void pesquisarLivrosPorAutor() {

		// recebendo qual Autor pesquisar
		String autor = JOptionPane.showInputDialog("Informe qual o Autor procurar");

		// variavel auxiliar para exibir a mensagem
		String mensagem = "Pesquisa por Autor\n\n";

		// variavel auxiliar para verificar se existe Autor
		boolean temAutor = false;

		// percorrendo o vetor e verificando a editora
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null && livros[i].getAutor().getNome().equals(autor)) {
				mensagem += mensagem(livros[i]);
				temAutor = true;
			}
		}

		// exibindo o resultado da pesquisa ao usuario
		if (temAutor) {
			JOptionPane.showMessageDialog(null, mensagem, "BIBLIOTECA", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Autor n�o encontrado", "BIBLIOTECA", 2);
		}
	}

	// m�todo para Pesquisar loca��es por data
	public void pesquisarLocacoesPorData() {
		// metodo data
		Data data = new Data();
		// mensagem para concatenar
		String mensagem = "";
		// setando os dia mes e ano
		data.setDia(Integer.parseInt(JOptionPane.showInputDialog("Informe o dia da loca��o:")));
		data.setMes(Integer.parseInt(JOptionPane.showInputDialog("Informe o m�s da loca��o:")));
		data.setAno(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano da loca��o:")));
		// gravar a pesquisa
		boolean teste = false;
		// for para verificar se tem livros locado na data que o usuario passou
		for (int i = 0; i < locacoes.length; i++) {
			if ((locacoes[i] != null) && (locacoes[i].getDataLocacao().toString().equals(data.toString()))) {
				// for para pegar todos os livros naquela data
				for (int j = 0; j < locacoes[i].getLivro().length; j++) {
					mensagem += "T�tulo: " + locacoes[i].getLivro()[j].getTitulo() + "\n" + " Data de Loca��o: "
							+ locacoes[i].getDataLocacao() + "\n";
					teste = true;
				}
			}
		}
		// exibindo o resultado da pesquisa ao usuario
		if (teste) {
			JOptionPane.showMessageDialog(null, mensagem, "BIBLIOTECA", 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o existe livro alugado nesta data", "BIBLIOTECA", 2);
		}
	}

	// mensagem para o usuario
	private String mensagem(Livro livro) {

		// variavel auxiliar para retorna a mensagem
		String sms = "\n";

		// mensagem para o usuario formatada
		sms += "T�tulo: " + livro.getTitulo() + "\n";
		sms += "Editora: " + livro.getEditora().getNome() + "\n";
		sms += "Autor: " + livro.getAutor().getNome() + "\n";
		sms += "Ano de Publica��o: " + livro.getAnoPublicacao() + "\n";

		// retornando a variavel formatada
		return sms;
	}

	// m�todo para Sair do sistema
	public void sairDoSistema() {
		System.exit(0);
	}

}
