package sed.algorithm.chapter1.section5;

public class QuickUnionUF {
	private int[] ufArray;
	private int count;
	
	public QuickUnionUF(int max){
		this.ufArray = new int[max];
		
		for (int i = 0; i < ufArray.length; i++) {
			ufArray[i] = i;
		}
		
		this.count = max;
	}
	
	
	public int find(int p){
		while (ufArray[p]!=p) {
			p=ufArray[p];
		}
		return p;
	}
	
	public boolean connected(int p, int q){
		return find(p)==find(q);
	}
	
	public void union(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot!=qRoot) {
			ufArray[pRoot]=qRoot;
			count--;
		}
	}
}
