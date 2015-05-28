package sed.algorithm.chapter1.section4;

public class FixedCapacityStackOfInts {
	private int[] elements = new int[100000];
	private int size = 0;
	
	public boolean isFull(){
		if (this.elements.length == size) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isEmpty(){
		if (size == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void push(int element) throws Exception{
		if (!isFull()) {
			this.elements[size++]= element;
		}else {
			throw new Exception("Full Stack");
		}
	}
	
	public int pop() throws Exception{
		if (!isEmpty()) {
			size--;
			return this.elements[size];
		}else {
			throw new Exception("Empty Stack");
		}
	}
	
}
