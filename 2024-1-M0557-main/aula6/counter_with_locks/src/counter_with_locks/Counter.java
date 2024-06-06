package counter_with_locks;

import java.util.concurrent.locks.Lock;

public class Counter {
	private Integer value;
	private Lock lock;
	
	public Counter(Integer value, Lock lock) {
		this.value = value;
		this.lock = lock;
	}
	
	public void increment(String threadName) {
		// adquirindo trava
		this.lock.lock();
		// início da seção crítica
		
		System.out.println(threadName + " entrou no método increment!");
		this.value++;
		System.out.println(threadName + " saiu do método increment!");
		
		// fim da seção crítica
		// liberando trava
		this.lock.unlock();
	}
	
	
	
	
	public Integer getValue() {
		return this.value;
	}
}
