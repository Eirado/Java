package remetente_destinatario;

public class Dado {
	private String mensagem;
	private boolean estaEnviando = true;
	
	
	public synchronized void enviar(String mensagem) {
		// enquanto tiver recebendo...
		while(!estaEnviando) {
			System.out.println("Esperando recebimento...");
			// espero...
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Thread interrompida!");
			}
		}
		// enviar a mensagem
		this.mensagem = mensagem;
		System.out.println("Mensagem enviada: " + this.mensagem);
		
		// fim do envio
		estaEnviando = false;
		
		notify();
	}
	
	public synchronized String receber() {
		while(estaEnviando) {
			System.out.println("Esperando envio...");
			// espero...
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Thread interrompida!");
			}
		}
		// receber a mensagem
		String mensagemRecebida = this.mensagem;
		System.out.println("Mensagem recebida: " + mensagemRecebida);
		
		// fim do recebimento
		estaEnviando = true;

		// notifico a thread do remetente
		notify();
		return mensagemRecebida;
	}
}
