package remetente_destinatario;

import java.util.concurrent.ThreadLocalRandom;

public class Destinatario extends Thread {
	private Dado dado;
	
	public Destinatario(Dado dado) {
		this.dado = dado;
	}
	
	public void run() {
		while(true) {

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
			String mensagemRecebida = this.dado.receber();

			if(mensagemRecebida.equals("FIM")) {
				break;
			}
		}
	}
}
