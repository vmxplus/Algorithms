package sed.algorithm.chapter2.section2;

import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;


public class MergeSortedQueues {
	
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
	
	public static Queue<Comparable> mergeRaw(Comparable[] a){
		Queue<Queue> queueContainer = new Queue<>();
		for (int i = 0; i < a.length; i++) {
			Queue<Comparable> queueElement = new Queue<>();
			queueElement.enqueue(a[i]);
			queueContainer.enqueue(queueElement);
		}
		
		while (queueContainer.size()>1){
			queueContainer.enqueue(merge(queueContainer.dequeue(),queueContainer.dequeue()));
		}
		
		return queueContainer.dequeue();
	}
	
	public static void main(String[] args) {
//		Queue<Comparable> queueA = new Queue<>();
//		queueA.enqueue(new Integer(1));
//		queueA.enqueue(new Integer(3));
//		queueA.enqueue(new Integer(5));
//		Queue<Comparable> queueB = new Queue<>();
//		queueB.enqueue(new Integer(2));
//		queueB.enqueue(new Integer(4));
//		queueB.enqueue(new Integer(6));
//		queueB.enqueue(new Integer(7));
//		
//		
//		Queue<Comparable> queueResult = merge(queueA, queueB);
//		System.out.println(isSorted(queueResult));
		
		Comparable[] a = {5, 4, 3, 2, 1, 0};
		
		Queue<Comparable> queueResult = mergeRaw(a);
		System.out.println(isSorted(queueResult));
		
		while(!queueResult.isEmpty()){
			System.out.println(queueResult.dequeue());
		}
	}
}
