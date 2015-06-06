package sed.algorithm.chapter2.section1;

import edu.princeton.cs.introcs.StdOut;

public class FixSequenceShell {
	
	public static void sort(Comparable[] a){
		int N = a.length;
		int[] seq={1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929, 16001, 36289, 64769, 146305, 260609};
		int h = seq.length-1;
		while (seq[h] >= N){
			h--;
		}
		
		for (int i = h; i >= 0; i--) {
			int d = seq[i];
			for (int j = d; j < N; j++) {
				for (int k = j; k >=d && less(a[k], a[k- d]); k=k-d) {
					exch(a, k, k-d);
				}
			}
		}
		
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
