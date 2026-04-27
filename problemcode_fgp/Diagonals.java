import static java.lang.Math.*;

class Diagonals
{
//part(a)
static double[] exampleMatrix(int n) 
{
    // Member 3 Function (n/a)
    return null;
}

//part(b) sum of two diagonal matrices
public static double[] sum(double[] A, double[] B) {
    int l = A.length;
    double[] result = new double[l];

    for (int i = 0; i < l; i++) {
        result[i] = A[i] + B[i];
    }

    return result;
}

//part(c) product of two diagonal matrices
public static double[] product(double[] A, double[] B) {
    int l = A.length;
    double[] result = new double[l];

    for (int i = 0; i < l; i++) {
        result[i] = A[i] * B[i];
    }

    return result;
}

 // part(d) inverse of a diagonal matrix
public static double[] inverse(double[] A) 
{
    int l = A.length;
    double [] inverse = new double[l];
    for (int i = 0; i < l; i++) {
        inverse[i] = 1.0 / A[i];    // assume matrix is invertible, so no zero elements on the diagonal
    }
    return inverse;
}

//function to print matrix
public static void printMatrix(double[] matrix)
    {
        for (double value : matrix) {
            System.out.print(value + " ");
        }
    }

//to test each function
public static void main(String[] args) {
    //part(b) testing the sum of two matrices
    double[] A = {1, 2, 3};

    double[] B = {4, 5, 6};

    double[] sumResult = sum(A, B);
    
    System.out.println("Sum of matrices:");
    printMatrix(sumResult);
    
    System.out.println(); //to separate outputs for clarity
    
    //part(c) testing product function
    double[] productResult = product(A,B);
    System.out.println("Product of matrices:");
    printMatrix(productResult);
}

}
