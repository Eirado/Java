package remetente_destinatario;

import java.util.concurrent.ThreadLocalRandom;

public class Destinatario extends Thread {
	private Dado dado;
	private Integer numRemetentes;
	
	public Destinatario(Dado dado, Integer numRemetentes) {
		this.dado = dado;
		this.numRemetentes = numRemetentes;
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
				this.numRemetentes--;
				if(this.numRemetentes == 0) {
					break;
				}
			}
		}
	}
}
