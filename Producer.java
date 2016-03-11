import java.util.concurrent.ArrayBlockingQueue;

public class Producer extends Thread {
	private ArrayBlockingQueue<String> queue;
	
	public Producer(ArrayBlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
		String[] msgs = {"Romeo","Romeo","wherefore", "art", "thou?", "the", "message", "was", "right"};
		
		for(String message : msgs) {
			try{
				queue.put(message);
			}catch (InterruptedException e) {}
			
		}
		
		try{
			queue.put("DONE");
			
		}catch (InterruptedException e) {}
		
	}
}
