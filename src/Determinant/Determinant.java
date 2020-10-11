package Determinant;

public class Determinant {
	
	public static int determinant(int[][] matrix) {
		int result = 0;
		
		int size = matrix.length;
		if (size==1) {
			result = matrix[0][0];
		}
		else if (size == 2) {
			result = matrix[0][0]*matrix [1][1] - matrix[0][1]*matrix[1][0];
		}
		else {
			int minorSize = size-1;
			for (int i=0; i<size; i++) {
				int[][] minorMatrix = new int[minorSize][minorSize];
				
				for(int iMajor=1, iMinor=0; iMajor < size && iMinor<minorSize; iMajor++, iMinor++ ) {
					for(int jMajor=0, jMinor=0 ; jMajor < size && jMinor<minorSize; jMajor++) {
						if (jMajor!=i) {
							minorMatrix[iMinor][jMinor] = matrix[iMajor][jMajor];
							jMinor++;
						}
					}
				}
				
				result += ((i%2  == 0) ? 1 : -1) * matrix[0][i] * determinant(minorMatrix);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix3 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix20 = {{5,6},{8,9}};
		int[][] matrix21 = {{4,6},{7,9}};
		int[][] matrix22 = {{4,5},{7,8}};
		
		System.out.println(1*determinant(matrix20) );
		System.out.println(2*determinant(matrix21) );
		System.out.println(3*determinant(matrix22) );
		System.out.println(1*determinant(matrix20) - 2*determinant(matrix21) +3*determinant(matrix22) );

		System.out.println(1*determinant(matrix3) );
	}
}


