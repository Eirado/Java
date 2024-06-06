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
		
		String[] mensagens2 = {
				"so long",
				"and thanks for all the fish",
				"FIM"
		};
		
		Remetente r1 = new Remetente(dado, mensagens);
		Remetente r2 = new Remetente(dado, mensagens2);

		Destinatario d1 = new Destinatario(dado, 2);
		
		r1.start();
		r2.start();
		d1.start();
	}
}
