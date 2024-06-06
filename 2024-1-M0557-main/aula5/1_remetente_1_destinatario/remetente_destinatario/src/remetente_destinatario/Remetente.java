package remetente_destinatario;

import java.util.concurrent.ThreadLocalRandom;

public class Remetente extends Thread {
	private Dado dado;
	private String[] mensagens;
	
	public Remetente(Dado dado, String[] mensagens) {
		this.dado = dado;
		this.mensagens = mensagens;
	}
	
	public void run() {
		// para cada mensagem da lista de mensagens
		for(String mensagem: this.mensagens) {
			this.dado.enviar(mensagem);
			// delay "aleatório" entre 5 e 10 s
			int delayAleatorio = 
					ThreadLocalRandom.current().
					nextInt(5000, 10000);
			try {
				Thread.sleep(delayAleatorio);
			} catch (InterruptedException e) {
				System.out.println(
						"Thread interrompida!!!");
			}
		}
	}
}
