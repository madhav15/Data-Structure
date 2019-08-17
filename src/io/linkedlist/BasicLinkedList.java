package io.linkedlist;

public class BasicLinkedList<T> {
	private Node first;
	private Node last;
	private int nodeCount;

	public BasicLinkedList() {
		first = null;
		last = null;
		nodeCount = 0;
	}

	public void add(T data) {
		if (first == null) {
			first = new Node(data);
			last = first;
		} else {
			Node node = new Node(data);
			last.setNextNode(node);
			last = node;
		}
		nodeCount++;
	}
	
	public void insertAt(T data, int position) throws Exception {
		if (position > size()) {
			throw new Exception("Invalid Position");
		}
		
		Node currentNode = first;
		for (int i = 1; i < position && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();
		}
		Node newNode = new Node(data);
		Node nextNode = currentNode.getNextNode();
		currentNode.setNextNode(newNode);
		newNode.setNextNode(nextNode);
		nodeCount++;
	}
	
	public T removeAt(int position) throws Exception {
		if (position > size()) {
			throw new Exception("Invalid Position");
		}
		
		Node currentNode = first;
		Node prevNode = first;
		
		for (int i = 1; i < position && currentNode != null; i++) {
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		T item = currentNode.getItem();
		prevNode.setNextNode(currentNode.getNextNode());
		nodeCount--;
		return item;
	}

	/* Remove First Node */
	public T remove() throws Exception {
		if (first == null)
			throw new Exception("List is empty. Nothing to remove");
		Node node = first;
		first = first.getNextNode();
		nodeCount--;
		return node.getItem();

	}
	
	public T get(int position) {
		if (first == null) {
			throw new IllegalAccessError("List is Empty");
		}
		Node currentNode = first;
		for (int i = 1; i < size() && currentNode != null; i++) {
			if (i == position) {
				return currentNode.getItem();
			}
			currentNode = currentNode.getNextNode();
		}
		// If we don't find the position
		return null;
	}
	
	public int find(T item) {
		if (first == null) {
			throw new IllegalAccessError("List is Empty");
		} 
		Node currentNode = first;
		for (int i = 1; i < size() && currentNode != null; i++) {
			if (currentNode.getItem().equals(item)) {
				return i;
			}
			currentNode = currentNode.getNextNode();
		}
		return -1;
	}

	public int size() {
		return nodeCount;
	}
	
	

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		Node currentNode = first;
		
		while(currentNode != null) {
			stringBuffer.append(currentNode.getItem());
			currentNode = currentNode.getNextNode();
			
			if (currentNode != null) {
				stringBuffer.append(", ");
			}
		}
		return stringBuffer.toString();
	}



	private class Node {

		private Node nextNode;
		private T item;

		public Node(T item) {
			this.item = item;
			this.nextNode = null;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}

	}

}
