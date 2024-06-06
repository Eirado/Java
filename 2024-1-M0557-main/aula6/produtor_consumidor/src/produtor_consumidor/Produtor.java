package produtor_consumidor;

import java.util.Random;

public class Produtor extends Thread {
	private Armazem armazem;
	
	public Produtor(Armazem armazem, String name) {
		// chamando construtor da classe pai
		super(name);
		this.armazem = armazem;
	}
	
	public void run() {
		// número de produtos entre 1 e 5
		int numProdutos = new Random().nextInt(5) + 1;
		System.out.println(this.getName() + " produziu " + numProdutos + " produtos");

		for(int i = 0;i < numProdutos;i++) {
			this.produzir();
		}
		System.out.println(this.getName() + " terminou produção");

	}
	
	public void produzir() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Thread interrompida!");
		}
		int produto = new Random().nextInt(1000);
		this.armazem.adicionar(produto);
	}
	
}
