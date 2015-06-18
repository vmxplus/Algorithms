package sed.algorithm.chapter2.section2;

import java.util.Arrays;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class TestMerge {
	private static Comparable[] aux;
	private static int count=0;
	public static void sortBU(Comparable[] a){
		//进行logN次的两两归并
		int N = a.length;
		aux = new Comparable[N];
		for (int sz = 1; sz < N; sz = sz+sz) {
			for (int lo = 0; lo < N-sz; lo +=sz+sz) {
				merge(a, lo, lo+sz-1, Math.min(lo+sz*2-1, N-1));
			}
		}
		
	}

	public static void sortUB(Comparable[] a){
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi){
		if(hi <= lo) return;
		int mid = lo+(hi -lo)/2;
		sort(a, lo, mid);
		sort(a,mid+1, hi);
		merge(a, lo, mid, hi);
	}
	
	public static void merge(Comparable[] a, int lo, int mid, int hi){
	
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
			count += 2;
		}
		
		for (int k = lo; k <= hi; k++) {
			if		(i > mid)				{a[k]=aux[j++];count +=2;}
			else if (j > hi )				{a[k]=aux[i++];count +=2;}
			else if (less(aux[j], aux[i]))  {a[k]=aux[j++];count +=4;}
			else 							{a[k]=aux[i++];count +=4;}
		}
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	

	private static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " " );
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
	
	public static Comparable[] generateArray(int N){
		Comparable[] array = new Comparable[N];
		for (int i = 0; i < array.length; i++) {
			array[i]=StdRandom.uniform();
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		
		
		for (int i = 1; i <= 512; i++) {
			Comparable[] aOrigin = generateArray(i);
			Comparable[] aCopy = Arrays.copyOfRange(aOrigin, 0, i);
			sortUB(aOrigin);
			StdDraw.setPenRadius(0.005);
			StdDraw.setXscale(0,550);
			StdDraw.setYscale(0,30000);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.point(i, count);
			count = 0;
			sortBU(aCopy);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(i, count);
			count = 0;
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.point(i, Math.log(i*1.0)*i*6);
		}
		
		
	}
}
