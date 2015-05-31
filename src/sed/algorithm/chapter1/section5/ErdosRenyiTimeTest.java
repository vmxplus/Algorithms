package sed.algorithm.chapter1.section5;

import sed.algorithm.chapter1.section4.Timer;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class ErdosRenyiTimeTest {
	
	public static void main(String[] args) {
		int MAX = 1000000;
		
		StdDraw.setXscale(0, MAX/10);
		StdDraw.setYscale(0, 10);
		StdDraw.setPenRadius(0.005);
		
		for (int N = 200; N < MAX; N=N*2) {
			QuickFindUF uf = new QuickFindUF(N);
			QuickUnionUF ufq = new QuickUnionUF(N);
			double ufTime=0;
			double ufQTime=0;
			
			while (uf.count() != 1) {
				int p = StdRandom.uniform(N);
				int q = StdRandom.uniform(N);
				Timer timer1  = new Timer();
				
				if (! uf.connect(p, q)) {
					uf.union(p, q);
				}
				
				ufTime +=timer1.elapsedTime();
				Timer timer2 = new Timer();
				if (! ufq.connected(p, q)) {
					ufq.union(p, q);
				}
				
				ufQTime += timer2.elapsedTime();
				
				timer1 = null;
				timer2 = null;
			}
			
			
			
			
			StdOut.println("TimeUf: " + ufTime +" TimeUFQ: " +ufQTime);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(N, ufTime);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.point(N, ufQTime);
		}
	}
}
