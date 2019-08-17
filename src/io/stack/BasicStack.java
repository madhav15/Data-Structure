package io.stack;

public class BasicStack<X> {

	private X[] data;
	private int stackPointer;

	public BasicStack() {
		data = (X[]) new Object[1000];
		stackPointer = 0;
	}

	public void push(X item) {
		data[stackPointer++] = item;
	}

	public X pop() {
		if (stackPointer < 0) {
			throw new IllegalStateException("Stack Already empty");
		}
		return data[--stackPointer];
	}

	public boolean contains(X item) {
		boolean found = false;
		for (int i = 0; i < stackPointer; i++) {
			if (data[i].equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}

	
	public X access(X item) {
		if (contains(item)) {
			for (int i = 0; i < stackPointer; i++) {
				X popedItem = pop();
				if (item.equals(popedItem)) {
					return popedItem;
				}
			}
		}
		return null;
	}
	
	public int size() {
		return stackPointer;
	}

}
