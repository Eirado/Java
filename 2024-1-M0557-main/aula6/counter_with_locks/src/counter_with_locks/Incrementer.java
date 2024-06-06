package counter_with_locks;

public class Incrementer extends Thread {
	private Counter counter;
	
	public Incrementer(Counter counter) {
		this.counter = counter;
	}
	
	public void run() {
		this.counter.increment(this.getName());
	}
}
