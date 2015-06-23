package sed.algorithm.chapter2.section2;


import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class ImprovingMerge {
	
	public static void sort(Comparable[] a){
		Comparable[] aux = new Comparable[a.length];
		System.arraycopy(a, 0, aux, 0, a.length);
		sort(a, aux, 0, a.length - 1);
		
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi ){
		if (hi-lo <= 7) {
			insertionSort(a,lo,hi);
			return; 
		}
		if(hi <= lo) return;
		int mid = lo+(hi -lo)/2;
		
		sort(aux, a, lo, mid);
		sort(aux, a, mid+1, hi);
		
		if (!less(aux[mid+1], aux[mid])) {
			System.arraycopy(aux, lo, a, lo, hi-lo+1);
			return ;
		}
		
		merge(a, aux, lo, mid, hi);
	}
	
	public static void insertionSort(Comparable[] a, int lo, int  hi){
		
		for (int i = lo; i <= hi; i++) {
			for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}
	
	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
		int i = lo, j = mid+1;
		
		for (int k = lo; k <= hi; k++) {
			if		(i > mid)				a[k]=aux[j++];
			else if (j > hi )				a[k]=aux[i++];
			else if (less(aux[j], aux[i]))  a[k]=aux[j++];
			else 							a[k]=aux[i++];
		}
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
	private static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " " );
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
	
	public static Comparable[] generateArray(int N){
		Comparable[] array = new Comparable[N];
		for (int i = 0; i < array.length; i++) {
			array[i]=StdRandom.uniform();
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		
		
		for (int i = 1; i <= 1024; i++) {
			Comparable[] a = generateArray(i);
			sort(a);
			if (!isSorted(a)) {
				show(a);
				System.out.println("You know!");
				break;
			}
		}
		
	}
	
}
