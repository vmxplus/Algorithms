package sed.algorithm.chapter1.section4;

import java.io.File;
import java.io.PrintStream;

public class MatrixLocalMinimum {
	public static int[] findLocalMinimumElement(int[][] matrix)throws Exception{
		int[] minimumIndex = new int[2];
		int currentMinimumValue = Integer.MAX_VALUE;
		
		
		 minimumIndex=findLocalMinimumElement(matrix, 0, 0, matrix.length-1, matrix.length-1, currentMinimumValue, minimumIndex);
		
		
		return  minimumIndex;
	}
	
	
	public static int[] findLocalMinimumElement(int[][] matrix ,
			int startRow , int startColumn , int endRow, int endColumn , 
			int currentMinimumValue, int[] minimumIndex) throws Exception{
			int minimumRowColValue = Integer.MAX_VALUE;
			

			if (startRow > endRow || startColumn > endColumn) {
				return null;
			}
			
			if (startRow == endRow && startColumn == endColumn) {
				return minimumIndex;
			}
			
			
			for (int i = startRow; i <= endRow; i++) {
				
				if (matrix[i][(startColumn+endColumn)/2] < minimumRowColValue) {
					minimumRowColValue = matrix[i][(startColumn+endColumn)/2];
					minimumIndex[0] = i;
					minimumIndex[1] = (startColumn+endColumn)/2;
				}
				
			}
			
			
			for (int j = startColumn; j <= endColumn; j++) {
				if (matrix[(startRow+endRow)/2][j] < minimumRowColValue) {
					minimumRowColValue = matrix[(startRow+endRow)/2][j] ;
					minimumIndex[0]= (startRow+endRow)/2;
					minimumIndex[1]= j;
				}
			}
			
			
			int[] miniNeighborIndex	= new int[2];
			int miniNeighborValue = Integer.MAX_VALUE;
			if (matrix[minimumIndex[0]][minimumIndex[1]-1] < miniNeighborValue) {
				miniNeighborValue =matrix[minimumIndex[0]][minimumIndex[1]-1];
				miniNeighborIndex[0] = minimumIndex[0];
				miniNeighborIndex[1] = minimumIndex[1]-1;
			}
			if (matrix[minimumIndex[0]-1][minimumIndex[1]] < miniNeighborValue) {
				miniNeighborValue =matrix[minimumIndex[0]-1][minimumIndex[1]];
				miniNeighborIndex[0] = minimumIndex[0]-1;
				miniNeighborIndex[1] = minimumIndex[1];
			}
			
			if (matrix[minimumIndex[0]][minimumIndex[1]+1] < miniNeighborValue) {
				miniNeighborValue =matrix[minimumIndex[0]][minimumIndex[1]+1];
				miniNeighborIndex[0] = minimumIndex[0];
				miniNeighborIndex[1] = minimumIndex[1]+1;
			}
			
			if (matrix[minimumIndex[0]+1][minimumIndex[1]] < miniNeighborValue) {
				miniNeighborValue =matrix[minimumIndex[0]+1][minimumIndex[1]];
				miniNeighborIndex[0] = minimumIndex[0]+1;
				miniNeighborIndex[1] = minimumIndex[1];
			}
			
			
			if (minimumRowColValue < miniNeighborValue) {
				return minimumIndex;
			}else {
				
				if (minimumRowColValue < currentMinimumValue) {
					
					
				}else {
					
					currentMinimumValue=miniNeighborValue;
					minimumIndex= miniNeighborIndex;
				}
				
				if (miniNeighborIndex[0] < (startRow+endRow)/2  && miniNeighborIndex[1] < (startColumn+endColumn)/2) {
					minimumIndex=findLocalMinimumElement(matrix, startRow, startColumn,
							(startRow+endRow)/2, 
							(startColumn+endColumn)/2, currentMinimumValue, minimumIndex);
				}else if (miniNeighborIndex[0] < (startRow+endRow)/2  && miniNeighborIndex[1] > (startColumn+endColumn)/2) {
					minimumIndex=findLocalMinimumElement(matrix, startRow, (startColumn+endColumn)/2,
							(startRow+endRow)/2, 
							endColumn, currentMinimumValue, minimumIndex);
				}else if (miniNeighborIndex[0] > (startRow+endRow)/2  && miniNeighborIndex[1] > (startColumn+endColumn)/2) {
					minimumIndex=findLocalMinimumElement(matrix, (startRow+endRow)/2, (startColumn+endColumn)/2,
							endRow, 
							endColumn, currentMinimumValue, minimumIndex);
				}else {
			
						minimumIndex=findLocalMinimumElement(matrix, (startRow+endRow)/2, startColumn,
								endRow, 
								(endColumn+startColumn)/2, currentMinimumValue, minimumIndex);
				
				}
				return minimumIndex;
				
			}
			
						
			
		
	}
	
	
	public static void main(String[] args) throws Exception{
		int[][] matrix = new int[6][7];
		for (int i = 0; i < matrix.length; i++) {
			matrix[0][i] = Integer.MAX_VALUE;
			matrix[i][0] = Integer.MAX_VALUE;
			matrix[matrix.length-1][i]= Integer.MAX_VALUE;
			matrix[i][matrix[0].length-1]= Integer.MAX_VALUE;
		}
		
		matrix[1][1]=5;
		matrix[1][2]=100;
		matrix[1][3]=16;
		matrix[1][4]=11;
		matrix[1][5]=10;

		matrix[2][1]=19;
		matrix[2][2]=10;
		matrix[2][3]=13;
		matrix[2][4]=100;
		matrix[2][5]= 100;
		

		matrix[3][1]=18;
		matrix[3][2]=100;
		matrix[3][3]=14;
		matrix[3][4]=100;
		matrix[3][5]= 100;
		

		matrix[4][1]=17;
		matrix[4][2]=16;
		matrix[4][3]=15;
		matrix[4][4]=100;
		matrix[4][5]= 100;
		
		for (int i = 1; i <=4 ; i++) {
			for (int j = 1; j <=5; j++) {
				System.out.print(matrix[i][j]+ "	");
			}
			System.out.println();
		}
		
		int[] result;
		result = (int[])findLocalMinimumElement(matrix);
		System.out.println(result[0]+" " +result[1] +" " +matrix[result[0]][result[1]]);
	}

	
}
