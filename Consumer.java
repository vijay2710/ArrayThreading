import java.util.concurrent.ArrayBlockingQueue;

public class Consumer implements Runnable {
	private ArrayBlockingQueue queue;
	
	public Consumer(ArrayBlockingQueue q) {
		//ArrayBlockingQueue<String> q = null;
		this.queue = q;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
		try{
		for(String message = (String)queue.take(); !message.equals("DONE"); message = (String) queue.take()) {
			System.out.println(message);
		}
		
		}catch (InterruptedException e){
			System.out.println("ist interrupted");
		}
	}
}
