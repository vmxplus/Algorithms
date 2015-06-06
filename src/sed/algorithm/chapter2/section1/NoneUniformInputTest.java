package sed.algorithm.chapter2.section1;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class NoneUniformInputTest {
	
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
	
	public static Integer[] generateTwoKeysArray(int N){
		Integer[] array = new Integer[N];
		for (int i = 0; i < N; i++) {
			if (i%2==0) {
				array[i] = 0;
			}else {
				array[i] = 1;
			}
		}
		
		StdRandom.shuffle(array);
		
		return array;
	}
	
	public static Integer[] generateThreeKeysArray(int N){
		Integer[] array = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			if (i %4 == 0 && i % 8!= 0) {
				array[i]=1;
			}else if(i % 4 == 0 && i % 8 != 0) {
				array[i]=2;
			}else {
				array[i]=0;
			}
		}
		
		StdRandom.shuffle(array);
		return array;
	}
	
	public static Integer[] generateRandomArray(int N){
		Integer[] array = new Integer[N];
		for (int i = 0; i < N; i++) {
			array[i] = StdRandom.uniform(0, N);
		}
		
		return array;
	}
	public static Integer[] generateHalfRandomArray(int N){
		Integer[] array = new Integer[N];
		for (int i = 0; i < N; i++) {
			if (i %2==0) {
				array[i] = StdRandom.uniform(1,N);
			}else {
				array[i] = 0;
			}
		}
		
		StdRandom.shuffle(array);
		
		return array;
	}
	
	public static void main(String[] args) {
		String alg = args[0];
		int N = Integer.parseInt(args[1]);
		
		Integer[] aRandom = generateRandomArray(N);
		Integer[] aTwoKey = generateTwoKeysArray(N);
		Integer[] halfRandom = generateHalfRandomArray(N);
		Integer[] threeKey = generateThreeKeysArray(N);
		StdOut.println("random time: "+time(alg, aRandom));
		
		StdOut.println("two Key time: "+time(alg, aTwoKey));
		StdOut.println("halfRandom time: "+time(alg, halfRandom));
		StdOut.println("three key time: "+time(alg, threeKey));
	}
}

