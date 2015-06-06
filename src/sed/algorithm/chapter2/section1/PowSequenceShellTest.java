package sed.algorithm.chapter2.section1;

import edu.princeton.cs.introcs.StdOut;

public class PowSequenceShellTest {
	public static void sort(Comparable[] a){
		int N = a.length;
		
		
	}
	
	private static boolean less(Comparable w, Comparable v){
		return w.compareTo(v)<0;
	}
	
	private static void  exch(Comparable[] a, int i, int j){
		Comparable temp= a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i]);
		}
	}
	
	public static boolean isSorted(Comparable[] a){
		for (int i = 0; i < a.length -1; i++) {
			if (less(a[i+1], a[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Integer[] a = {3, 2, 1, 5,7};
		sort(a);
		StdOut.println(isSorted(a));
		show(a);
		
		
	}
}
