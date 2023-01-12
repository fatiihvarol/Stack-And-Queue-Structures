package deneme;

public class Queue {
	private int rear,front;
	private Object[] elements;
	 Queue(int capacity) {
		elements= new Object[capacity];
		rear=-1;
		front=0;
		
	}
	 void enqueue(Object data) {
		 if (isFull()) {
			 System.out.println("Queue is overflow");
			
		}
		 else {
			rear++;
			elements[rear]=data;
		}
	 }
	Object dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return null;
		}
		else {
			Object retData=elements[front];
			front++;
			return retData;
		}
	}
	Object peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		else return elements[front];
	}
	boolean isFull() {
		return(rear+1==elements.length);
	}
	boolean isEmpty() {
		return(rear<front);
	}
	int size() {
		return rear-front+1;
	}

}
