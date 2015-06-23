package sed.algorithm.chapter2.section2;

import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;

public class NaturalMerge {
	
	public static Queue<Comparable> merge (Queue<Comparable> queueA, Queue<Comparable> queueB){
		Queue<Comparable> resultQueue = new Queue<>();
		
		while (!(queueA.isEmpty() && queueB.isEmpty())) {
			
			if (queueA.isEmpty() && !queueB.isEmpty()) {
				resultQueue.enqueue(queueB.dequeue());
			}else if ( !queueA.isEmpty() && queueB.isEmpty()) {
				resultQueue.enqueue(queueA.dequeue());
				
			}else if ( less(queueB.peek(),queueA.peek()) ){
				
				resultQueue.enqueue(queueB.dequeue());
			}else {
		
				resultQueue.enqueue(queueA.dequeue());
			}
		}
		
		return resultQueue;
		
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	
	public static boolean isSorted(Queue<Comparable> queue){
		if (queue.size() <= 1) {
			return true;
		}
		Iterator<Comparable> iterator = queue.iterator();
		Comparable prevElement = iterator.next();
		
		while(iterator.hasNext()){
			Comparable curElement = iterator.next();
			if (less(curElement, prevElement)) {
				return false;
			}
			prevElement = curElement;
		}
		
		return true;
	}
	
	public static Queue<Comparable> naturalMerge(Comparable[] a){
		Queue<Queue> queueContainer = new Queue<>();
		
		Queue<Comparable> queueElement = new Queue<>();
		
		if (a.length == 0) {
			return queueElement;
		}
		
		if (a.length == 1) {
			queueElement.enqueue(a[0]);
			return queueElement;
		}
		
		
		for (int i = 0; i < a.length - 1; i++) {
			
			queueElement.enqueue(a[i]);
			if (less(a[i+1], a[i])) {
				queueContainer.enqueue(queueElement);
				queueElement = new Queue<>();
			}
		}

		queueElement.enqueue(a[a.length-1]);
		queueContainer.enqueue(queueElement);
		
		
		
		while (queueContainer.size()>1){
			queueContainer.enqueue(merge(queueContainer.dequeue(),queueContainer.dequeue()));
		}
		
		return queueContainer.dequeue();
	}
	
	public static void main(String[] args) {
		Comparable[] a = {2, 4, 3, 2, 0, 1,6};
		
		Queue<Comparable> queueResult = naturalMerge(a);
		System.out.println(isSorted(queueResult));
		
		while(!queueResult.isEmpty()){
			System.out.println(queueResult.dequeue());
		}
	}
	
}
