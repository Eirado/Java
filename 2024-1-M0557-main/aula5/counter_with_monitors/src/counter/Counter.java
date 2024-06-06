package counter;

public class Counter {
	private Integer value;
	
	public Counter(Integer value) {
		this.value = value;
	}
	
	public synchronized void increment(String threadName) {
		System.out.println(threadName + " entrou no método increment!");
		this.value++;
		System.out.println(threadName + " saiu do método increment!");
	}
	
	public Integer getValue() {
		return this.value;
	}
}
