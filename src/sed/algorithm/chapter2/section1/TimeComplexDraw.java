package sed.algorithm.chapter2.section1;

import java.awt.Color;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class TimeComplexDraw {
	
	
	
	public static double time(Comparable[] a, String alg) throws Exception{
		Stopwatch stopwatch = new Stopwatch();
		
		if ("Insertion".equals(alg)) {
			Insertion.sort(a);
		}
		
		if ("Selection".equals(alg)) {
			Selection.sort(a);
		}
		
		if ("Shell".equals(alg)) {
			Shell.sort(a);
		}
		
		if ("Merge".equals(alg)) {
			Merge.sort(a);
		}
		
		if ("Quick".equals(alg)) {
			Quick.sort(a);
		}
		
		if ("Heap".equals(alg)) {
			Heap.sort(a);
		}
		
		if ("FixSequenceShell".equals(alg)){
			FixSequenceShell.sort(a);
		}
		
		return stopwatch.elapsedTime();
	}
	
	public static Comparable[]  generateRandomArray(int N){
		Comparable[] array = new Comparable[N];
		for (int i = 0; i < array.length; i++) {
			array[i] = StdRandom.uniform();
		}
		return array;
	}
	
	public static double getAverageTime(String alg, int max , int interval, int T, int N ) throws Exception{
		double avgTime = 0;
		for (int j = 0; j < T; j++) {
			Comparable[] a = generateRandomArray(N);
			avgTime+=time(a, alg);
		}
		
		return avgTime/T;
	}
	
	public static void drawLine (String alg, int max, int interval, int T, Color color) throws Exception{
		double timeCost=0;
		double prevTime=0;
		StdDraw.setPenColor(color);
		for (int i = interval; i <=max; i=i+interval) {
			timeCost =getAverageTime(alg, max, interval, T, i);
			StdOut.println(timeCost);
			StdDraw.point(i, timeCost);
			if(Math.abs(prevTime-0) > 0.00001){
				StdDraw.line(i-interval, prevTime, i, timeCost);
			}
			prevTime= timeCost;
		}
	
	}
	
	public static void main(String[] args) throws Exception {
		
		String alg = args[0];
		int max = Integer.parseInt(args[1]);
		int interval = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		
		StdDraw.setXscale(0, max);
		StdDraw.setYscale(0, 0.2);
		alg = "Selection";
		drawLine(alg, max, interval, T, StdDraw.BLACK);
		alg = "Insertion";
		drawLine(alg, max, interval, T, StdDraw.BLUE);
		alg = "Shell";
		drawLine(alg, max, interval, T, StdDraw.RED);
	}
	
}
