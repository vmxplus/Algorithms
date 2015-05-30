package sed.algorithm.chapter1.section5;

public class PathCompressQuickUnionUF {
	private int[] id;

	
	private int count;
	
	public PathCompressQuickUnionUF(int max) {
		id = new int[max];

		for (int i = 0; i < id.length; i++) {
			id[i]=i;
		}
		count = max;
	}
	
	public int count(){
		return count;
	}
	
	
	public int find(int p){
		int pParent = p;
		while(id[pParent]!=pParent){
			pParent=id[pParent];
		}
		while(id[p]!= p){
			p=id[p];
			id[p]=pParent;
		}
		
		return pParent;
	}
	
	
	public boolean connected(int p, int q){
		return find(p)== find(q);
	}
	
	public void union(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		
		if (pRoot!=qRoot) {
			id[pRoot]=qRoot;
			count --;
		}
	}
	
}
