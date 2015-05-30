package sed.algorithm.chapter1.section5;


import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class QuickFindUF {
	private int[] uf ;
	private int count;
	
	public QuickFindUF(int max) {
		this.uf = new int[max];
		this.count=max;
		for (int i = 0; i < uf.length; i++) {
			this.uf[i] = i;
		}
	}
	
	public int count(){
		return this.count;
	}
	public int find(int p){
		
		return this.uf[p];
	}
	
	public boolean connect(int p , int q){
		return find(p)==find(q);
	}
	
	public void union(int p, int q){
		int pRep = find(p);
		int qRep = find(q);
		
		if (pRep != qRep) {
			for (int i = 0; i < uf.length; i++) {
				if (this.uf[i]==pRep) {
					this.uf[i]=qRep;
					count--;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF uf = new UF(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
			StdOut.println(p+" : " +q);
			
		}
		
		StdOut.println("count : " + uf.count());
	}
}
