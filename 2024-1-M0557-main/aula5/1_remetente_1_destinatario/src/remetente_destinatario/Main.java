package remetente_destinatario;

public class Main {
	public static void main(String[] args) {
		Dado dado = new Dado();
		String[] mensagens = {
				"mensagem 1",
				"mensagem 2",
				"mensagem 3",
				"mensagem 4",
				"FIM"
		};
		
		Remetente r1 = new Remetente(dado, mensagens);
		Destinatario d1 = new Destinatario(dado);
		
		r1.start();
		d1.start();
	}
}
