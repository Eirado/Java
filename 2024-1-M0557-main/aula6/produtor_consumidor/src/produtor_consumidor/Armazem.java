package produtor_consumidor;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Armazem {
	static private int CAPACIDADE = 10;
	private Queue<Integer> fila;
	private ReentrantLock lock;
	private Condition armazemVazio;
	private Condition armazemCheio;
	
	public Armazem(Queue<Integer> fila,
				   ReentrantLock lock,
				   Condition armazemVazio,
				   Condition armazemCheio) {
		this.fila = fila;
		this.lock = lock;
		this.armazemCheio = armazemCheio;
		this.armazemVazio = armazemVazio;
	}
	
	public void adicionar(int produto) {
		this.lock.lock();
		// enquanto meu armazém estiver cheio
		while(this.fila.size() == CAPACIDADE) {
			// espero algum item ser removido por uma thread consumidor
			try {
				this.armazemCheio.await();
			} catch (InterruptedException e) {
				System.out.println("Thread interrompida!");
			}
		}
		
		System.out.println("Adicionando produto: " + produto);
		this.fila.add(produto);
		// aviso para threads dos consumidores que armazém não está mais vazio
		this.armazemVazio.signalAll();
		
		this.lock.unlock();
	}
	
	public int remover() {
		try {
			this.lock.lock();
			// enquanto meu armazém estiver cheio
			while(this.fila.size() == 0) {
				// espero algum item ser adicionado
				// por uma thread de um produtor
				try {
					this.armazemVazio.await();
				} catch (InterruptedException e) {
					System.out.println("Thread interrompida!");
				}
			}
			
			int produto = this.fila.remove();
			System.out.println("Removendo produto: " + produto);
			
			// aviso para threads dos produtores
			// que armazém não está mais cheio
			this.armazemCheio.signalAll();
			return produto;

		} finally {
			this.lock.unlock();
		}
		
	}
	
	
	
	
	
	
	
	
}
