package counter;

public class Incrementer extends Thread {
	private Counter counter;
	
	public Incrementer(Counter counter) {
		this.counter = counter;
	}
	
	public void run() {
		this.counter.increment(this.getName());
	}
}
