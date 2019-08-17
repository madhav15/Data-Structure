package io.queue;

public class BasicQueue<T> {
	
	private T[] data;
	
	private int front;
	private int end;
	
	public BasicQueue() {
		this(100);
	}
	
 	public BasicQueue(int size) {
		data = (T[]) new Object[size];
		this.front = 0;
		this.end = 0;
	}

	
	public int  size() {
		if (front == -1 && end == -1) {
			return 0;
		} else {
			return end - front + 1;
		}
	}
	
	public void enQueue(T item) {
		if ((end + 1) % data.length == front) {
			throw new IllegalStateException("Queue is Full");
		} else if (size() == 0) {
			front++;
			end++;
			data[end] = item;
		} else {
			end++;
			data[end] = item;
		}	
	}
	
	public T deQueue() {
		if (front == 0 && end == 0) {
			return null;
		}
		T item = data[front];
		front--;
		return item;
	}
}
