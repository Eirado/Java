package counter_with_locks;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		int numExec = 0;
		ReentrantLock lock = new ReentrantLock();
		while(true) {
			Counter counter = new Counter(0, lock);
			
			Incrementer inc1 = new Incrementer(counter);
			Incrementer inc2 = new Incrementer(counter);
			Incrementer inc3 = new Incrementer(counter);
			Incrementer inc4 = new Incrementer(counter);
			
			inc1.start();
			inc2.start();
			inc3.start();
			inc4.start();
			
			try {
				inc1.join();
				inc2.join();
				inc3.join();
				inc4.join();
			} catch (InterruptedException e) {
				System.out.println("Erro: Thread foi interrompida!!!");
			}
			numExec++;
			if(counter.getValue() != 4) { // resultado diferente do esperado
				System.out.println(
						 "Número de execuções: " + numExec + 
						 "\nValor final do contador: " + 
								counter.getValue());
				break;
			}
			System.out.println("================== Fim da execução ===================");
		}
		
	}

}
