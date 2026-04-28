import static java.lang.Math.*;

class Tridiagonals
{

/**
 * part(a) exampleMatrix
 * This function produces an n x n tridiagonal matrix of size 3 x n
 * @param n the dimension of the square matrix that will be generated
 * @return an n x n tridiagonal matrix
 */

static double[][] exampleMatrix(int n) {
    
    double[][] a = new double[3][n];
    for (int i=0; i<n; i++) {
        //on the diagonal
        a[1][i] = -(i+1)*(i+1); 
        
        // above diagonal 
        if (i < n - 1) {
            a[0][i] = 1;
        }

        // below diagonal 
        if (i > 0) {
            a[2][i - 1] = i + 1;
        }
    }
    double[][] matrix = new double[n][n];
    for (int j=0; j<n; j++) {
        //on the diagonal
        matrix[j][j] = a[1][j];
        
        //above diagonal
        if (j < n-1) {
        matrix[j][j+1] = a[0][j];
        }
        //below diagonal
        if (j > 0) {
        matrix[j][j-1] = a[2][j-1];
        }
    }
    return matrix;
}

//part(b) isValidTridiagonal
static boolean isValidTridiagonal(double[][] A) 
{
    // Member 3 Function (n/a)
    return false; //boolean value returned to avoid compilation error
}

//part(c) sum of two tridiagonal matrices
static double[][] sum(double[][] A , double[][] B) 
{
    int n = A.length;
    
    if (n != B.length) {
    return null; // Return null for incompatible matrix sizes
    }

    double[][] sum = new double[n][n];

    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            sum[i][j]= A[i][j] + B[i][j];
        }
    }
    return sum;

}

/**
 * part(d) productWithDiagonal
 * This function computes the product of a diagonal matrix D with a 
 *  tridiagonal matrix T
 * @param D the diagonal matrix
 * @param T the tridiagonal matrix
 * @return the product of the diagonal and tridiagonal input matrices
 */

static double[][] productWithDiagonal(double[][] D, double[][] T)
{
    int n = D.length;
    double[][] answer = new double[n][n];

    for (int i=0; i<n; i++) {
        for (int k=0; k<n; k++) {
            answer[k][i] = D[k][k] * T[k][i];
        }
    
    }
    return answer;
}

//part(e) linearSolve
static double[] linearSolve(double[][] T, double[] v) 
{
    // Member 3 Function (n/a)
    return null;
}

// to print matrices
public static void printMatrix(double[][] matrix) {
    for (double[] row : matrix) {
        for (double value : row) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

//to test each function
public static void main(String[] args) {
    //part(a) print matrix
    System.out.println("Tridiagonal matrix:");
    int n = 5;

    double[][] matrix = exampleMatrix(n);

    printMatrix(matrix);
    
    System.out.println(); //to separate outputs for clarity
    
    //part(d) to test function works
    System.out.println("Product with Diagonal");
    double[][] D = {
        {1, 0, 0, 0, 0},
        {0, 2, 0, 0, 0},
        {0, 0, 3, 0, 0},
        {0, 0, 0, 2, 0},
        {0, 0, 0, 0, 1}
    };

    double[][] T = exampleMatrix(n);

    double[][] answer = productWithDiagonal(D, T);
    printMatrix(answer);
        
}

}
