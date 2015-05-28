package sed.algorithm.chapter1.section5;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class WeightedQuickUnionUF {
	private int[] id; //父链接数组（由触点索引）
	private int[] sz;	//(由触点索引的)各个根节点所对应的分量的大小
	private int count;	//连通分量的数量
	
	public WeightedQuickUnionUF(int N){
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}

		sz = new int[N];
		for (int i = 0; i < N; i++) {
			sz[i] = 1;
		}
	
	}
	
	public int count(){
		return count;
	}
	
	
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	public int find(int p){
		while(p!=id[p]){
			p = id[p];
		}
		
		return p;
	}
	
	public void union(int p, int q){
		int i = find(p);
		int j = find(q);
		if (i == j) {
			return ;
		}
		if (sz[i] < sz[j]) {
			id[i]= j;
			sz[j]+=sz[i];
		}else {
			id[j] = i; 
			sz[i]+=sz[j];
		}
		
		count-- ;
	}
	
	public static void main(String[] args){
		int N = StdIn.readInt();		//读取触点数量
		UF uf = new UF(N);				//初始化N个分量
		
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();	//读取整数对
			
			if (uf.connected(p, q)) {	//联通忽略
				continue;
			}
			
			uf.union(p, q);				//归并分量
			
			StdOut.println(p + " " + q); //打印连接
		}
		
		StdOut.println(uf.count() + "components");
	}
	
}
