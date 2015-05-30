package sed.algorithm.chapter1.section5;

public class PathCompressWeightedQuickUnionUF {

		private int[] id;
		private int[] sz;
		private int count;
		
		public PathCompressWeightedQuickUnionUF(int max) {
			id = new int[max];
			sz = new int[max];

			for (int i = 0; i < id.length; i++) {
				id[i]=i;
			}
			for (int i = 0; i < id.length; i++) {
				sz[i]=1;
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
				if (sz[pRoot] < sz[qRoot]) {
					id[pRoot] = qRoot;
					sz[qRoot] += sz[pRoot]; 
				}else {
					id[qRoot] = pRoot;
					sz[pRoot] += sz[qRoot];
				}
				count--;
			}
		}
		


}
