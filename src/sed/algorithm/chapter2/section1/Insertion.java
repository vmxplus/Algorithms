package sed.algorithm.chapter2.section1;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class Insertion {
	public static void sort(Comparable[] a){
		int N = a.length;
		int min = 0;
		
//	with a guard, smallest element is arranged at a[0] at first
//		for (int i = 1; i < a.length; i++) {
//			if (less(a[i], a[min])) {
//				min=i;
//			}
//		}
//		exch(a, 0, min);
//		for (int i = 2; i < N; i++) {
//			for (int j = i; less(a[j], a[j-1]); j--) {
//				exch(a, j, j - 1);
//			}
//		}
		
//	Traditional kind		
		for (int i = 0; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}
	
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
	public static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + "" );
		}
		
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a){
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
