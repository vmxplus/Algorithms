package sed.algorithm.chapter2.section1;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class IntAsKey implements Comparable<IntAsKey> {
	public int key;
	public int[] value;
	
	public IntAsKey(int N) {
		this.key = StdRandom.uniform(N);
		this.value = new int[20];
		for (int i = 0; i < 20; i++) {
			this.value[i] = StdRandom.uniform(N);
		}
	}
	
	public int compareTo(IntAsKey o){
		if (this.key < o.key) {
			return -1;
		}else if(this.key > o.key){
			return 1;
		}else {
			return 0;
		}
	}
	
}
