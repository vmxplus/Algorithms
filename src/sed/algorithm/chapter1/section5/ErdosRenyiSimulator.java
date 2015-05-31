package sed.algorithm.chapter1.section5;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class ErdosRenyiSimulator {

		public static void main(String[] args) {
			int MAX = 1000000;
			
			StdDraw.setXscale(0, MAX);
			StdDraw.setYscale(0, 10*MAX);
			StdDraw.setPenRadius(0.005);
			
			for (int N = 200; N < MAX; N=N*2) {
				PathCompressWeightedQuickUnionUF uf = new PathCompressWeightedQuickUnionUF(N);
				int linkCount=0;
				while (uf.count() != 1) {
					int p = StdRandom.uniform(N);
					int q = StdRandom.uniform(N);
					StdOut.println(p+" : "+q);
					if (! uf.connected(p, q)) {
						uf.union(p, q);
					}
					linkCount++;
				}
				StdOut.println("Link Count : " + linkCount);
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.point(N, 1/2.0*N*Math.log(N*1.0));
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.point(N, linkCount);
			}
			
			
			
		
			
		}
}


