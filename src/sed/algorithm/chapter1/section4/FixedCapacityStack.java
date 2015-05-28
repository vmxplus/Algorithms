package sed.algorithm.chapter1.section4;

public class FixedCapacityStack<Item> {
	private Item[] itemArray = (Item[]) new Object[100000];
	private int size;
	
	public boolean isEmpty(){
		if (size == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean isFull(){
		if (size == itemArray.length) {
			return true;
		}else {
			return false;
		}
	}
	
	public void push(Item item) throws Exception{
		if (!isFull()) {
			itemArray[size++]= item;
		}else {
			throw new Exception("Full Stack");
		}
	}
	
	public Item pop() throws Exception{
		if (!isEmpty()) {
			size--;
			return itemArray[size];
		}else {
			throw new Exception("Empty Stack!");
		}
		
	}
}
