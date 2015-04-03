import java.util.Scanner;

public class ParallelGauss{
	private static MatrixClass m1;
	public static void main(String[] args){
		ParallelGauss pgauss = new ParallelGauss();
		try {
			pgauss.test();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	public void test() throws InterruptedException{
		int n; //user input row
		int m;//user input column
		Scanner in = new Scanner(System.in);
		System.out.print("How many rows?");
		n = in.nextInt();
		//Thread[] dividethreadarray = new Thread[n];
		Thread[] columnclearthreadarray = new Thread[n];
		System.out.print("How many columns? Don't forget to count the answer vector");
		m = in.nextInt();
		in.close();
		m1 = new MatrixClass(n,m);
		//for (int i = 0; i < n; i++){
		//	dividethreadarray[i] = new divideThread(i);
		//}
		//for (int i = 0; i < n; i++){
		//	dividethreadarray[i].start();
		//}
		//for (int i = 0; i < n; i++){
		//	dividethreadarray[i].join();
		//}
		m1.printMatrix();
		System.out.print("\n");
		for (int j = 0; j < m-1; j++){ //rows = i columns = j
			m1.divide(j);
		for (int i = 0; i < n; i++){
			columnclearthreadarray[i] = new clearcolumnThread(i, j);
		}
		for (int i = 0; i < n; i++){
			columnclearthreadarray[i].start();
		}
		for (int i = 0; i < n; i++){
			columnclearthreadarray[i].join();
		}
		System.out.print("\n");
		m1.printMatrix();
		}
	}
	class divideThread extends Thread{
		private int rownumber;
		public divideThread(int z){
			rownumber = z;
		}
		public void run(){
			m1.divide(rownumber);
		}
	}
	
	class clearcolumnThread extends Thread{
		private int rownumber;
		private int columnnumber;
		public clearcolumnThread(int z, int x){
			rownumber = z;
			columnnumber = x;
		}
		public void run(){
			m1.columnclear(rownumber, columnnumber);
		}
	}
	
}
