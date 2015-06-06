package sed.algorithm.chapter2.section1;

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class DoubleTest {
	
	public static double time(Comparable[] a, String alg){
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
		
		return stopwatch.elapsedTime();
	}
	
	public static Comparable[]  generateRandomArray(int N){
		Comparable[] array = new Comparable[N];
		for (int i = 0; i < array.length; i++) {
			array[i] = StdRandom.uniform();
		}
		return array;
	}
	
	public static void main(String[] args) {
		String alg = args[0];
		int max = 100000000;
		double costTime;
		double prevCostTime = 0;
		double param = 1;
		
		for (int i = 1000; i <= max; i=i*2) {
			Comparable[] a = generateRandomArray(i);
			costTime= time(a, alg);
			StdOut.println("The scale of Array is: " + i);
			if (prevCostTime!=0){
				param = costTime / prevCostTime;
				StdOut.println("The expected time is " + Math.pow(2.0, 1.31) * prevCostTime);
				StdOut.println("The real time is" + costTime);
				StdOut.println("Param is " + param);
			}
			StdOut.println("=========================");
			prevCostTime = costTime;
		}
	}
	
}
