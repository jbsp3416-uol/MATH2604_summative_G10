import static java.lang.Math.*;

class Diagonals
{
//
static double[] exampleMatrix(int n) 
{
    // Member 3 Function (n/a)
    return null;
}

//1(b) sum of two diagonal matrices
public static double[] sum(double[] matrixA, double[] matrixB) {
    int l = matrixA.length;
    double[] result = new double[l];

    for (int i = 0; i < l; i++) {
        result[i] = matrixA[i] + matrixB[i];
    }

    return result;
}

//1(c) product of two diagonal matrices
public static double[] product(double[] matrixA, double[] matrixB) {
    int l = matrixA.length;
    double[] result = new double[l];

    for (int i = 0; i < l; i++) {
        result[i] = matrixA[i] * matrixB[i];
    }

    return result;
}
//function to print matrix
public static void printMatrix(double[] matrix)
    {
        for (double value : matrix) {
            System.out.print(value + " ");
        }
    }

public static void main(String[] args) {
    //testing the sum of two matrices
    double[][] A = {
        {1, 0, 0},
        {0, 2, 0},
        {0, 0, 3}
    };

    double[][] B = {
        {3, 0, 0},
        {0, 2, 0},
        {0, 0, 1}
    };

    double[][] sumResult = sum(A, B);
    
    System.out.println("Sum of matrices:");
    printMatrix(sumResult);
    
    System.out.println(); //to separate outputs for clarity
    
    //testing product function
    double[][] productResult = product(A,B);
    System.out.println("Product of matrices:");
    printMatrix(productResult);
}

 // 1(d) inverse of a diagonal matrix
public static double[] inverse(double[] A) 
{
    int l = A.length;
    double [] inverse = new double[l];
    for (int i = 0; i < l; i++) {
        inverse[i] = 1.0 / A[i];    // assume matrix is invertible, so no zero elements on the diagonal
    }
    return inverse;
}
}
