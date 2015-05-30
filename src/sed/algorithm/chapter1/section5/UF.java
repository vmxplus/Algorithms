package sed.algorithm.chapter1.section5;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class UF {
	private int[] id;	//����id���Դ�����Ϊ����
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
	
	
	//quick union �㷨
	private int find(int p){
		//�ҳ����������
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
		int N = StdIn.readInt();		//��ȡ��������
		UF uf = new UF(N);				//��ʼ��N������
		
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();	//��ȡ�����
			
			if (uf.connected(p, q)) {	//��ͨ����
				continue;
			}
			
			uf.union(p, q);				//�鲢����
			
			StdOut.println(p + " " + q); //��ӡ����
		}
		
		StdOut.println(uf.count() + "components");
	}
}
