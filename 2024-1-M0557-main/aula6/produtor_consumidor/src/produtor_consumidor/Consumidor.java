package produtor_consumidor;

import java.util.Random;

public class Consumidor extends Thread {
private Armazem armazem;
	
	public Consumidor(Armazem armazem, String name) {
		// chamando construtor da classe pai
		super(name);
		this.armazem = armazem;
	}
	
	public void run() {
		// número de produtos entre 1 e 5
		int numProdutos = new Random().nextInt(5) + 1;
		System.out.println(this.getName() + " consumiu " + numProdutos + " produtos");

		for(int i = 0;i < numProdutos;i++) {
			this.consumir();
		}
		System.out.println(this.getName() + " terminou consumo");

	}
	
	public int consumir() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Thread interrompida!");
		}
		int produto = this.armazem.remover();
		return produto;
	}
}
