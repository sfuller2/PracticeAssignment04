
public class ArrayQueue implements Queue{

	private Object[] array;
	private int head;
	private int tail;
	
	public ArrayQueue() {
		this.array = new Object[10];
		this.head = 0;
		this.tail = 0;
	}
	
	public boolean empty() {
		if(head == tail) {
			return true;
		}
		return false;
	}
	
	private boolean full() {
		if((tail + 1) % array.length == head) {
			return true;
		}
		return false;
	}
	
	private void grow() {
		Object[] newarr = new Object[array.length * 2];
		if(tail <= head) {
			System.arraycopy(array, head, newarr, 0, array.length - head);
		}
		System.arraycopy(array, 0, newarr, head - 1, tail);
		array = newarr;
	}
	
	public void enqueue(Object item) {
		if(full()) {
			grow();
		}
		array[tail++] = item;
		if(tail == array.length){
			tail = 0;
		}
	}
	
	public Object dequeue() {
		if(empty()) {
			return null;
		}
		Object item = array[head];
		head++;
		if(head == array.length) {
			head = 0;
		}
		return item;
	}
}
