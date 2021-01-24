package list.linkedlist.implementation;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	
	public class Node{
		private Object data;
		private Node next;
		private Node(Object input) {
			this.data = input;
			this.next = null;
		}
	}
	
	
	public String toString() {
		if(head == null) return "[]";
		
		Node tmp = head;
		String str = "[";
		
		while(tmp.next != null) {
			str += tmp.data + ",";
			tmp = tmp.next;
		}
		str += tmp.data;
		return str + "]";
	}
	
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		head = newNode;
		size++;
		if(head.next == null) tail = newNode;		
	}
	
	public void addLast(Object input) {
		if(size == 0) {
			addFirst(input);
		}
		else {
			Node newNode = new Node(input);
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	private Node node(int index) {
		Node x = head;
		for(int i = 0;i < index;i++) x = x.next;
		return x;
	}
	
	public void add(int k, Object input) {
		if(k == 0) addFirst(input);
		else {
			Node tmp1 = node(k-1);
			Node tmp2 = tmp1.next;
			Node newNode = new Node(input);
			tmp1.next = newNode;
			newNode.next = tmp2;
			size++;
			
		if(newNode.next == null) tail = newNode;
		}
	}
	//삭제된 노드가 갖고 있었던 값을 리턴한다
	public Object removeFirst() {
		Node deleteNode = head;
		head = head.next;
		size--;
		
		Object returnData = deleteNode.data;
		deleteNode = null;
		return returnData;
	}
	
	public Object remove(int k) {
		if(k == 0) return removeFirst();
		
		Node tmp = node(k-1);
		Node toDeleteNode = tmp.next;
		tmp.next = tmp.next.next;		
		Object returnData = toDeleteNode.data;
		
		if(toDeleteNode == tail) tail = tmp;
		toDeleteNode = null;
		size--;
		return returnData;		
	}
	
	public Object removeLast() {
		return remove(size-1);
	}
	
	public int size() {
		return size;
	}
	
	public Object get(int k) {
		Node tmp = node(k);
		return tmp.data;
	}
	
	public int indexOf(Object data) {
		Node tmp = head;
		int index = 0;
		
		while(tmp.data != data) {
			index++;
			tmp = tmp.next;
			if(tmp == null) return -1;
		}
		return index;
	}
	
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	
	class ListIterator{
		private Node next;
		private Node lastReturned;
		private int nextIndex;
		
		ListIterator(){
			next = head;
		}
		
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}
		
		public boolean hasNext() {
			//return nextIndex < size;
			if(next == null) return false;
			else return true;
		}

		public void add(Object o) {
			Node newNode = new Node(o);
			
			if(lastReturned == null) {
				head = newNode;
				newNode.next = next;
			}
			else {
				lastReturned.next = newNode;
				newNode.next = next;
			}
			nextIndex++;
			size++;
		}
		
		//lastReturned가 가리키는 값을 삭제
		public void remove() {
			if(nextIndex == 0) {
				throw new IllegalStateException();
			}
			LinkedList.this.remove(nextIndex-1);
			nextIndex--;
		}
	}
}
