
public class ArrayStack implements Stack{

	private Object[] array;
	private int top;
	
	public ArrayStack(){
		this.array = new Object[10];
		this.top = 0;
	}
	
	private void grow() {
		Object[] newarr = new Object[array.length*2];
		System.arraycopy(array, 0, newarr, 0, array.length);
		array = newarr;
	}
	
	public boolean empty() {
		if(top == 0) {
			return true;
		}
		return false;
	}
	
	public void push(Object item) {
		if(top == array.length) {
			grow();
		}
		array[top++] = item;
	}
	
	public Object pop() {
		if(empty()) {
			return null;
		}
		return array[--top];
	}
	
	public Object peek() {
		if(empty()) {
			return null;
		}
		return array[top-1];
	}
	
	
	
}
