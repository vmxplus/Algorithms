package sed.algorithm.chapter1.section4;

import edu.princeton.cs.introcs.StdOut;

public class FibonacciSearch{
	
	private static final int MAXSIZE = 13; 
	
	public static void fibonacci(int[] f){
		f[0] = 1;
		f[1] = 1;
		StdOut.print(f[0] + " ");
		StdOut.print(f[1] + " ");
		
		
		for (int i = 2; i < MAXSIZE; i++) {
			f[i] = f[i-1] + f[i-2];
			StdOut.print(f[i] + " ");
		}
		
		StdOut.println();
		
	} 
	
	public static int fibonacci_search(int[] a, int key, int n){
		int low = 0, high = n-1;
		int mid = 0;
		int k = 0;
		int[] F =  new  int[MAXSIZE];
		fibonacci(F);
		
		while( n > F[k]-1){ //ȷ��fibonacci�����е�ֵ���Ա�ʾ���������������е�λ��
			++k;
		}
		
		//������������Ĺ�ģ��չΪF[k]-1��ԭ������Ĳ�����a[high]���
		int[] tempArray = new int[F[k]-1];
		
		for (int i = n; i < F[k]-1; i++) {
			tempArray[i] = a[high];
		}
		
		for (int i = 0; i < n; i++) {
			tempArray[i] = a[i];
		}
		
		a = tempArray;
		
		//���ڹ�ģΪF[k]-1������
		//�ƽ�ָ������� ÿ�ν������Ϊ�����֣�
		//��һ����Ϊ��low����������ʼ��F[k-1]-1��Ԫ�أ���mid-1��������Ϊֹ; 
		//�ڶ����ּ�Ϊ������a[mid],���� mid = low+F[k-1]-1;
		//��������Ϊ �Ӱ�mid+1 ����������ʼ��F[k-2]-1��Ԫ�أ���highΪֹ
		//ÿ��ѭ������ѭ��һ����
		
		while(low <= high){
			mid = low + F[k-1] -1;
			if (a[mid] > key) {
				high = mid -1;
				k = k - 1;
			}else if (a[mid] < key){
				low = mid + 1;
				k = k - 2;
			}else{
				if (mid <= high) {
					return mid;
				}else {
					return -1;
				}
			}
				
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] a = {5,15,19,20,25,31,38,41,45,49,52,55,57};
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		
		StdOut.println();
		StdOut.println(fibonacci_search(a,57,13));
	}
	
}