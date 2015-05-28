package sed.algorithm.chapter1.section5;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class UF {
	private int[] id;	//分量id（以触点作为索引）
	private int count;
	
	public UF(int N){
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	
	public int count(){
		return count;
	}
	
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	//quick find 方法实现的 并查	
	/*public int find(int p){
		return id[p];
	}
	
	public void union(int p, int q){
		//将p和q归并到相同的分量中
		int pID = find(p);
		int qID = find(q);
		
		if (pID == qID) {
			return ;
		}
		
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pID) {
				id[i] = qID;
			}
		}
		
		count--;
		
		
	}*/
	
	//quick union 算法
	private int find(int p){
		//找出分量的名称
		while (p != id[p]) {
			p = id[p];
		}
		
		return p;
	} 
	
	public void union(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return ;
		}
		
		id[pRoot] = qRoot;
		count --;
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
