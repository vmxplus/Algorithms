package sed.algorithm.chapter2.section1;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class Selection {
	public static void sort(Comparable[] a){
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i+1; j < N; j++) {
				if (less(a[j], a[min])) {
					min =j;
				}
			}
			
			exch(a, i, min);
//			showAnimation(a);
			
			showPathAnimation(a, i+1 , i , min);
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
			StdOut.print(a[i] + "" );
		}
		
		StdOut.println();
	}
	
	private static void showAnimation(Comparable[] a){
		Double[] aTemp = (Double[]) a;
		StdDraw.clear();
		int N = aTemp.length;
		for (int i = 0; i < a.length; i++) {
			
			double x = 1.0 * i/N;
			double y = aTemp[i]/2.0;
			double rw = 0.4/N;
			double rh = aTemp[i]/2.0;
			
			StdDraw.filledRectangle(x, y, rw, rh);
		}
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void showPathAnimation(Comparable[] a, int count, int curMin, int preMin){
		Double[] aTemp = (Double[]) a;

		int N = aTemp.length;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N);
		for (int i = 0; i < a.length; i++) {
			int x  = i;
			int y  = N - count;
			if (i==curMin || i == preMin) {
				StdDraw.setPenColor(StdDraw.RED);
			}else {
				StdDraw.setPenColor(StdDraw.BLACK);
			}
			StdDraw.text(x, y, aTemp[i].toString().substring(2, 3));
						
		}
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
//		String[] a = In.readStrings();
//		sort(a);
//		assert isSorted(a);
//		show(a);
		int N =10;
		Double[] a = new Double[N];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.random();
		}
		
		sort(a);
	}
	
	
	
}
