package sed.algorithm.chapter2.section1;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.introcs.StdOut;

public class MultiTypeSortTest {
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
	
	public static StringAsKey[]  generateStringAsKey(int N){
		StringAsKey[] strKeyArray = new StringAsKey[N];
		for (int i = 0; i < N; i++) {
			strKeyArray[i]= new StringAsKey();
		}
		return strKeyArray;
	}
	
	public static DoubleAsKey[] generateDoubleAsKey(int N){
		DoubleAsKey[] doubleKeyArray = new DoubleAsKey[N];
		for (int i = 0; i < N; i++) {
			doubleKeyArray[i] = new DoubleAsKey();
		}
		
		return doubleKeyArray;
	}
	
	public static IntAsKey[] generateInAsKey(int N){
		IntAsKey[] intKeyArray = new IntAsKey[N];
		for (int i = 0; i < N; i++) {
			intKeyArray[i] = new IntAsKey(N);
		}
		
		return intKeyArray;
	}
	
	public static void main(String[] args) {
		String alg = args[0];
		Integer N = Integer.parseInt(args[1]);
		
		StringAsKey[] strKeyArray = generateStringAsKey(N);
		StdOut.println("String As key "+time(alg, strKeyArray));
		DoubleAsKey[] doubleKeyArray = generateDoubleAsKey(N);
		StdOut.println("Double As key" + time(alg,doubleKeyArray ));
		IntAsKey[] intKeyArray = generateInAsKey(N);
		StdOut.println("Int As key" + time(alg,intKeyArray ));
	}
}
