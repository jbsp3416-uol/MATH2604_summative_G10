import static java.lang.Math.*;

class Tridiagonals
{
//part (a)
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
        
public static void printMatrix(double[][] matrix) {
    for (double[] row : matrix) {
        for (double value : row) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

public static void main(String[] args) {
    int n = 5;

    double[][] matrix = exampleMatrix(n);

    printMatrix(matrix);
}          

/* 
    static boolean isValidTridiagonal(double[][]) // Member 3 Function
    {
        return 0;
    }
*/

/*
static double[][] sum(double[][], double[][]) // Member 1 Function
{
    return 0;
}

static double[][] productWithDiagonal(double[], double[][]) // Member 2 Function
{
    return 0;
}
/* 
    static double[] linearSolve(double[][], double[]) // Member 3 Function
    {
        return 0;
    }
*/
}
