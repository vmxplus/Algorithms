package sed.algorithm.chapter1.section5;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class WeightedQuickUnionUF {
	private int[] id;
	private int[] sz;
	private int count;
	
	public WeightedQuickUnionUF(int max) {
		this.id = new int[max];
		this.sz = new int[max];
		
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
		
		for (int i = 0; i < sz.length; i++) {
			sz[i] = 1;
		}
		
	}
	
	public int find(int p){
		while(id[p] != p){
			p = id[p];
		}
		
		return p;
	}
	
	public boolean connected(int p , int q){
		return find(p) == find(q);
	}
	
	public void union(int p , int q){
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot!=qRoot) {
			if (sz[pRoot] < sz[qRoot]) {
				id[pRoot] = qRoot;
				sz[qRoot]=sz[qRoot]+sz[pRoot];
			}else {
				id[qRoot] = pRoot;
				sz[pRoot] = sz[pRoot]+sz[qRoot];
			}
			count --;
		}
	}
	
}
