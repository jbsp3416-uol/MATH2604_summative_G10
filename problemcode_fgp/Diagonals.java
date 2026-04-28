import static java.lang.Math.*;

class Diagonals
{

/**
 * part(a) exmapleMatrix
 * This function takes a positive integer n and returns a 2D array representing the diagonal elemtents
 * This function is not complete due to no designated third member.
 * @param n the size of the diagonal array
 * @return a 2D array representing the diagonal elements of a matrix but {@code null}
 *  for the incomplete function
 */
static double[] exampleMatrix(int n) 
{
    // Member 3 Function (n/a)
    return null;
}

/**
 * part(b) sum of two diagonal matrices
 * This function takes two arrays representing the diagonal elements of two diagonal matrices and returns an array representing the diagonal elements of their sum. 
 * If the input arrays are of different lengths, it returns {@code null}.
 * @param A the diagonal elements of the first matrix
 * @param B the diagonal elements of the second matrix
 * @return a new array of the sum of the two diagonal elements or {@code null}
 *  if the input arrays are of different length
 */
public static double[] sum(double[] A, double[] B) {
    int l = A.length;
    double[] result = new double[l];

    if (A.length != B.length) {
        return null; //diagonal arrays need to be the same length
    }
    for (int i = 0; i < l; i++) {
        result[i] = A[i] + B[i];
    }

    return result;
}

/**
 * part(c) product of two diagonal matrices
 * This function takes two arrays representing the diagonal elements of two diagonal matrices and returns an array representing the diagonal elements of their product.
 * If the input arrays are of different lengths, it returns {@code null}.
 * @param A the diagonal elements of first matrix
 * @param B the diagonal elemnts of the second matrix
 * @return the product of the two diagonal input arrays or {@code null}
 *  if the input arrays are of different length
 */
public static double[] product(double[] A, double[] B) {
    int l = A.length;
    double[] result = new double[l];

    if (A.length != B.length) {
        return null; //diagonal arrays need to be the same length
    }
    for (int i = 0; i < l; i++) {
        result[i] = A[i] * B[i];
    }

    return result;
}

 /**
  * part(d) inverse of a diagonal matrix
  * This function takes an array representing the diagonal elements of a diagonal matrix and returns an array representing the diagonal elements of its inverse.
  * If any element on the diagonal is zero, it returns {@code null}.
  * @param A the diagonal elements of the matrix
  * @return a new array of the inverse of the diagonal elements or {@code null}
  *  if any element on the diagonal is zero
  */
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
