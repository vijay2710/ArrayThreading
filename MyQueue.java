
public class MyQueue {
   // private boolean empty;
    private String[] messages;
    private int count;
    private int front;
    


    public MyQueue(int size) {
    	this.messages = new String[size];
        this.count = 0;
        this.front = 0;
        
    }

	public boolean isEmpty() {
		return (count==0);
	}
	
	public boolean isFull() {
		return (count==messages.length);
	}
	
    public synchronized String take(String message) {
        while(!(count>0)) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
       count--;
       front++;
       front = front % messages.length;
       notifyAll();
        //System.out.println("putted" +message);
        return messages[front];

    }

    public void put(String newMessage) {
        synchronized(this) {
            while(!(count < messages .length)) {
                try {
                    wait();
                } catch (InterruptedException e) {}
            }
           count++;
           int last = (front + count) % messages.length;
           this.messages[last] = newMessage;
            notifyAll();
            return ;
        }
    }
}