import java.util.Scanner;

public class MatrixClass {
	private double [][] matrix;
	
	public MatrixClass(int n, int m){
		double counter = 0;
		matrix = new double[n][m];
		Scanner input = new Scanner(System.in);
		for(int i =0; i<n; i++){
			for(int j = 0; j < m; j++){
				counter++;
				matrix[i][j] = counter;
				//System.out.print("Enter Coordinate: " + i + j);
				//matrix[i][j] = input.nextDouble(); //matrix is generated
			}
		}
		input.close();
	}
	
	public void rowswap(int i, int k){
		int m = matrix[0].length -1; //m is equal to the number of columns we have
		double temp;
		for(int iter = 0; iter <= m; iter++){
			temp = matrix[i][iter];
			matrix[i][iter] = matrix[k][iter];
			matrix[k][iter] = temp;
		}
	}
	public void divide(int i){
		int m = matrix[0].length -1;
		double divisor = matrix[i][i];
		for(int iter = 0; iter <= m; iter++){
			matrix[i][iter] = matrix[i][iter]/divisor;
		}
	}
	public void columnclear(int i, int j){
		int m = matrix[0].length; //m indicates the number of columns we have
			if(matrix[i][j] == 0 || i == j){ //if the row is already set at 0 or we're at our 
				return;                            //pivot we skip
			}
			else{
				double ratio = matrix[i][j] / matrix[j][j]; //matrix[j][j] denotes the pivot
				for(int iter = j; iter < m; iter++){
					matrix[i][iter] -= ratio * matrix[j][iter];
				}
			}
	}
	
	public void printMatrix(){
		int n = matrix.length;
		int m = matrix[0].length;
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.print("\n");
		}
	}
}
