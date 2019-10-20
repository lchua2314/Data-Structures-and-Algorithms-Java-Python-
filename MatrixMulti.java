package allAlgos;

public class MatrixMulti {
    //The following main method is for standard and Strassen matrix multiplcation assignment 3
    public static void main(String[] args) {
		for (int n = 2;;n *= 2) {

			//Creating a two-dimensional nxn empty array.
			int[][] a = new int[n][n];
			//Fill a array.
			for (int j = 0, u = 0; j < a.length ;j++) {
				for (int k = 0; k < a.length; k++, u++) {
					a[j][k] = u;
				}
			}
			
			//Copy array a into array b.
			int[][] b = a; 
			
			//To check what goes into the arrays, uncomment block the following:
			/*
			System.out.println("Array a: ");
			printMat(a);
			
			System.out.println("Array b: ");	
			printMat(b);
			*/
			
			//Classic Matrix Multiplication
			
			//
			long start = System.nanoTime();
			//Code here
			int[][] c = classicMult(n, a, b);
			
			//To check the result of c with classic matrix multiplcation, 
			//uncomment block the following:
			/*
			System.out.println("Array c (Classic):");
			printMat(c);
			*/
			
			long finish = System.nanoTime() - start;
			System.out.println("Classic Matrix Multiplcation Time (n = " + n + "): " + finish + " ns");
			
			//Clear array 'c' so Strassen matrix multiplication can refill it.
			c = new int[n][n];
		
			//Strassen Matrix Multiplication
			long start2 = System.nanoTime();
			//Code here
			c = strassenMult(n, a, b);				
			//To check the result of c with Strassen matrix multiplcation, 
			//uncomment block the following:
			/*
			System.out.println("Array c (Strassen):");
			printMat(c);		
			*/
			
			long finish2 = System.nanoTime() - start2;
			System.out.println("Strassen Matrix Multiplcation Time (n = " + n + "): " + finish2 + " ns");
		}    	
    }
    
    public static void printMat(int[][] c) {
        for(int i = 0; i < c.length; i++) {
            for(int j = 0; j < c.length; j++) {
                System.out.print("["+ (i) + "][" + (j) + "]" + c[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int[][] matrixAdd(int n, int a[][], int b[][]) {
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }
    
    public static int[][] matrixSub(int n, int a[][], int b[][]) {
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }
    
    public static void partitionMat(int[][] input, int[][] output, int row, int col) {
        for (int i = 0, i2 = row; i < output.length; i++, i2++) {
            for(int j = 0, j2 = col; j < output.length; j++, j2++) {
                output[i][j] = input[i2][j2];
            }
        }
    }
    
    public static void buildMat(int[][] result, int[][] c, int col, int row) {
        for(int i = 0, i2 = row; i < c.length; i++, i2++) {
            for(int j = 0, j2 = col; j < c.length; j++, j2++) {
                result[i2][j2] = c[i][j];
            }
        }
    }
    
    public static int[][] strassenMult(int n, int a[][], int b[][]){
        
        if (n == 1) { //When a and b is 1x1.
            return classicMult(n, a, b);
        }
        else {
            int[][] result = new int[n][n];  
            int mid = n/2;       
            int[][] a11 = new int[mid][mid];
            int[][] a12 = new int[mid][mid];
            int[][] a21 = new int[mid][mid];
            int[][] a22 = new int[mid][mid];
            
            int[][] b11 = new int[mid][mid];
            int[][] b12 = new int[mid][mid];
            int[][] b21 = new int[mid][mid];
            int[][] b22 = new int[mid][mid];
          
            int[][] c11;
            int[][] c12;
            int[][] c21;
            int[][] c22;
            
            //Partition matrices into 4 smaller pieces.
            partitionMat(a,a11,0,0);
            partitionMat(a,a12,0,mid);
            partitionMat(a,a21,mid,0);
            partitionMat(a,a22,mid,mid);
            
            partitionMat(b,b11,0,0);
            partitionMat(b,b12,0,mid);
            partitionMat(b,b21,mid,0);
            partitionMat(b,b22,mid,mid);
            
            int[][] p;
            int[][] q;
            int[][] r;
            int[][] s;
            int[][] t;
            int[][] u;
            int[][] v;
            
            p = strassenMult(mid, matrixAdd(mid, a11, a22), matrixAdd(mid, b11, b22));
            q = strassenMult(mid, matrixAdd(mid, a21, a22), b11);
            r = strassenMult(mid, a11, matrixSub(mid, b12, b22));
            s = strassenMult(mid, a22, matrixSub(mid, b21, b11));
            t = strassenMult(mid, matrixAdd(mid, a11, a12), b22);
            u = strassenMult(mid, matrixSub(mid, a21, a11), matrixAdd(mid, b11, b12));
            v = strassenMult(mid, matrixSub(mid, a12, a22), matrixAdd(mid, b21, b22));
            
            //Forming c
            c11 = matrixAdd(mid, matrixSub(mid, matrixAdd(mid, p, s), t), v);
            c12 = matrixAdd(mid, r, t);
            c21 = matrixAdd(mid, q, s);
            c22 = matrixAdd(mid, matrixSub(mid, matrixAdd(mid, p, r), q), u);
            
            //Put c together
            buildMat(result, c11, 0, 0);
            buildMat(result, c12, mid, 0);
            buildMat(result, c21, 0, mid);
            buildMat(result, c22, mid, mid);
            return result;
        }
    }
    
    public static int[][] classicMult(int n, int a[][], int b[][]) {
        if (n == 1) {
            int[][] result = new int[1][1];     
            result[0][0] = a[0][0]*b[0][0];
            return result;             
        }
        else {
            int[][] result = new int[n][n]; 
            int mid = n/2;        
            int[][] a11 = new int[mid][mid];
            int[][] a12 = new int[mid][mid];
            int[][] a21 = new int[mid][mid];
            int[][] a22 = new int[mid][mid];
            
            int[][] b11 = new int[mid][mid];
            int[][] b12 = new int[mid][mid];
            int[][] b21 = new int[mid][mid];
            int[][] b22 = new int[mid][mid];
          
            int[][] c11;
            int[][] c12;
            int[][] c21;
            int[][] c22;
            
            //Partition matrices into 4 smaller pieces.
            partitionMat(a,a11,0,0);
            partitionMat(a,a12,0,mid);
            partitionMat(a,a21,mid,0);
            partitionMat(a,a22,mid,mid);
            
            partitionMat(b,b11,0,0);
            partitionMat(b,b12,0,mid);
            partitionMat(b,b21,mid,0);
            partitionMat(b,b22,mid,mid);
            
            //Doing Classic Matrix Multiplcation
            c11 = matrixAdd(mid, classicMult(mid, a11, b11), classicMult(mid, a12, b21));
            c12 = matrixAdd(mid, classicMult(mid, a11, b12), classicMult(mid, a12, b22));
            c21 = matrixAdd(mid, classicMult(mid, a21, b11), classicMult(mid, a22, b21));
            c22 = matrixAdd(mid, classicMult(mid, a21, b12), classicMult(mid, a22, b22));
            
            //Put c together
            buildMat(result, c11, 0, 0);
            buildMat(result, c12, mid, 0);
            buildMat(result, c21, 0, mid);
            buildMat(result, c22, mid, mid);
            return result;
        }
    }
}
