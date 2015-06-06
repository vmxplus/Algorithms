package sed.algorithm.chapter2.section1;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class RareCaseTest {
	
	public static double time(String alg, Comparable[] a){
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

	public static Integer[] generateSortedArray(int N){
		Integer[] array = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			array[i] = i;
		}
		
		return array;
	} 
	
	public static Integer[] generateReversedArray(int N){
		Integer[] array = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			array[i] = N-i;
		}
		
		return array;
	}
	
	public static Integer[] generateSameKeyArray(int N){
		Integer[] array = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			array[i] = 1;
		}
		
		return array;
	}
	
	public static Double[] generateGaussArray(int N){
		Double[] array = new Double[N];
		for (int i = 0; i < N; i++) {
			array[i]= StdRandom.gaussian();
			
		}
		
		return array;
	}
	public static Integer[] generatePoissonArray(int N, int lambda){
		Integer[] array = new Integer[N];
		for (int i = 0; i < N; i++) {
			array[i] = StdRandom.poisson(lambda);
		}
		return array;
	}
	public static Integer[] generateGeometricArray(int N, double p){
		Integer[] array = new Integer[N];
		for (int i = 0; i < N; i++) {
			array[i] = StdRandom.geometric(p);
		}
		return array;
	}
	

	
	public static Integer[] generateEmptyArray(){
		return new Integer[0];
	}
	
	public static Integer[] generateOneElementArray(){
		Integer[] array = new Integer[1];
		array[0] = 1;
		return array;
	}
	
	
	public static void main(String[] args) {
		String alg = args[0];
		int N = Integer.parseInt(args[1]);
		int T = Integer.parseInt(args[2]);
		double avg = 0;
		Comparable[] a = generateEmptyArray();
		StdOut.println("empty array : "+ time(alg, a));
		a=generateOneElementArray();
		StdOut.println("one element array ："+ time(alg, a));
		a=generateSortedArray(N);
		StdOut.println("sorted array ： "+ time(alg, a));

		a=generateSameKeyArray(N);
		StdOut.println("same key array ： "+ time(alg, a));
	
		a=generateReversedArray(N);
		StdOut.println("Reverse array ： "+ time(alg, a));
		
		a=generateGaussArray(N);
		StdOut.println("Gauss array ： "+ time(alg, a));
		
		a=generatePoissonArray(N, 2);
		StdOut.println("Poisson array ： "+ time(alg, a));
		
		a=generateGeometricArray(N, 0.3);
		StdOut.println("Geometric array ： "+ time(alg, a));
		
	}
	

}
