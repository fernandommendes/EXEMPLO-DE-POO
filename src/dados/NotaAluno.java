package dados;

public class NotaAluno {
	
	private static int seq = 0; 
	
	private int registro;
	private String nome;
	private int nota;
	private int numeracao;
	
	public NotaAluno (int registro, String nome, int nota) {
		this.registro = registro;
		this.nome = nome;
		this.nota = nota;
		this.numeracao = ++seq;
	}

	public int getRegistro() {
		return registro;
	}

	public String getNome() {
		return nome;
	}

	public int getNota() {
		return nota;
	}


	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
	public String toString(){
		return 
				"Registro: " + registro + "\n" +
				"Nome: " + nome + "\n" +
				"Nota: " + nota + "\n";
	}
	
	
}
