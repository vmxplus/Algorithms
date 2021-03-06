package sed.algorithm.chapter1.section5;



import org.junit.Test;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class QuickUnionUFTest {

	@Test
	public void test() {
		In in = new In("resources/mediumUF.txt");
		int N = in.readInt();
		QuickUnionUF uf = new QuickUnionUF(N);
		while (!in.isEmpty()) {
			int p = in.readInt();
			int q = in.readInt();
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
			StdOut.println(p+" : " +q);
			
		}
		
		StdOut.println("count : " + uf.count());
	}

}
