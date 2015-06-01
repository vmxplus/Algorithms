package sed.algorithm.chapter2.section1;
import edu.princeton.cs.algs4.Count;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class ShellCompareTimeTest {
	
	public static int count = 0;  
	
	public static void sort (Comparable[] a){
		int N = a.length;
		int h = 1;
		while (h < N / 3) h = 3*h + 1;
		
		
		while ( h >= 1) {
			
			for (int i = h ; i < N; i++) {
				
				for (int j = i; j >=h  && less(a[j], a[j-h]); j=j-h) {
					
					exch(a, j, j-h);
				}
				
			}
			
			System.out.println(count*1.0/N);
			count =0;
			h/=3;
		}
		
	}
	
	private static boolean less(Comparable v, Comparable w){
		count ++;
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
	
	private static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + "" );
		}
		
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		 
		for (int i = 100; i < 1000000000; i=i*10) {
			Double[] a = new Double[i];
			for (int j = 0; j < a.length; j++) {
				a[j]= StdRandom.uniform();
			}
			
			sort(a);
			count = 0;
		}
	}
}
