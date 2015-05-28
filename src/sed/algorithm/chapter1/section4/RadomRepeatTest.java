package sed.algorithm.chapter1.section4;


import edu.princeton.cs.introcs.StdRandom;

public class RadomRepeatTest {
	
	public static void main(String[] args) {
		for(int N=200; ; N = N+N  ){
			long[] status = new long[N];		
			long count=0;
			while (true) {
				count++;
				int temp = StdRandom.uniform(N);
				if (status[temp] == 1) {
					System.out.println("count: "+count +" Theory: " + Math.sqrt(Math.PI*N/2) );
					System.out.println("count / Theory "+ count*count  / Math.PI*N/2 );
					break;
				}else {
					status[temp] = 1;
				}
			}
			
			status =null;
		}
	}
}
