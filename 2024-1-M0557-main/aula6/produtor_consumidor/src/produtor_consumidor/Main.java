package produtor_consumidor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	private static int NUM_CONSUMIDORES = 3;
	private static int NUM_PRODUTORES = 5;
	
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition armazemCheio = lock.newCondition();
		Condition armazemVazio = lock.newCondition();
		Queue<Integer> fila = new LinkedList<Integer>();
		
		Armazem armazem = new Armazem(fila, lock, armazemVazio, armazemCheio);
		
		
		for(int i = 0; i < NUM_PRODUTORES;i++) {
			// crio o produtor e inicio a thread
			new Produtor(armazem, "produtor_" + (i + 1)).start();
		}
		
		for(int i = 0; i < NUM_CONSUMIDORES;i++) {
			// crio o produtor e inicio a thread
			new Consumidor(armazem, "consumidor_" + (i + 1)).start();
		}
	}
	
}
