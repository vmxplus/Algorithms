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

public class PartSortedTest {
	public static double time(String alg, Comparable[] a){
		Stopwatch timer = new Stopwatch();
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
		
		
		return timer.elapsedTime();
	}
	
	public static Integer[] generateNFSortedArray(int N){
		Integer[] a = new Integer[N];
		int i =0;
		for (; i <= N *0.95; i++) {
			a[i] = i;
		}
		
		for (int j = i; j < N; j++) {
			a[j] = StdRandom.uniform(i, N);
		}
		
		return a;
	}

	public static Integer[] generateRandomArray(int N){
		Integer[] array = new Integer[N];
		for (int i = 0; i < N; i++) {
			array[i] = StdRandom.uniform(0, N);
		}
		return array;
	}
	
	public static Integer[] generateFRSortedArray(int N){
		Integer[] a = new Integer[N];
		int i = 0;
		for (; i <= N *0.95; i++) {
			a[i] = i;
		}
		
		for (int j = i+1; j <N; j++) {
			int temp = StdRandom.uniform(j, N);
			int index = StdRandom.uniform(0, j);
			
			for (int k = index; k < j; k++) {
				a[k+1]=a[k];
			}
			
			a[index] = temp;
			
		}
		
		return a;
	}
	
	public static Integer[] generateInTenArray(int N){
		Integer[] array = new Integer[N]; 
		for (int i = 0; i < N; i++) {
			array[i] = i;
		}
		
		for (int i = 0; i < N-10; i=i+10) {
			StdRandom.shuffle(array, i, i+10);
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		String alg = args[0];
		int N = Integer.parseInt(args[1]);
		
		Integer[] ar = generateRandomArray(N);
		StdOut.println("The ar time is: "+ time(alg, ar));
		
		Integer[] aNF = generateNFSortedArray(N);
		StdOut.println("The NF time is: "+ time(alg, aNF));
		
		Integer[] aFR = generateFRSortedArray(N);
		StdOut.println("The aFR time is: "+ time(alg, aFR));
		
		Integer[] aInTen = generateInTenArray(N);
		StdOut.println("The aInTen time is: "+ time(alg, aInTen));
	}
}
