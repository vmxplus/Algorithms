package sed.algorithm.chapter1.section5;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class ErdosRenyi {
	public static void main(String[] args) {
		int N =1000000;
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
	}
}
