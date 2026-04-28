import static java.lang.Math.*;

class ODE
{
    /**
     * This function approximates the solution to the ODE f''(x) + cos(x)*f(x) = a*x^2, with boundary conditions f(0) = f(1) = 0, at the point x=0.5.
     * The method solves the linear system M*w = -h*h*v, where M is a tridiagonal matrix defined by the problem and v is a vector defined by the function v[i] = a*x[i]*x[i].
     * It then uses the solution w to find an approximation for f(0.5).
     * It assumes n>0. If 0.5 is not among the x[i], it computes the approximation by averaging the two w[i] values corresponding to the nearest x[i] values that are immediately below and above 0.5.
     * @param a a parameter (real constant) in the function v[i] = a*x[i]*x[i]
     * @param n the number of grid points (positive integer), typically large
     * @return an approximation for f(0.5)
     **/
    static double solve(double a, int n)
    {
        double h = 1.0/ (n + 1);

        // set grid points
        double[] x = new double[n];
        for (int i =0; i < n; i++)
        {
            x[i] = (i+1)*h;
        }

        // build nxn matrix M
        double[][] M = new double[n][n];
        for (int i =0; i < n; i++)
        {
            M[i][i] = 2 + h*h*cos(x[i]); // set main diagonal

            if (i > 0) 
            {
                M[i][i-1] = -1; // set sub-diagonal
            }

            if (i < n-1) 
            {
                M[i][i+1] = -1; // set super-diagonal
            }
        }
        // build vector v
        double[] v = new double[n];
        for (int i=0; i<n; i++)
        {
            v[i] = a*x[i]*x[i];
        }


        //Solve M*w = -h*h*v for w using the linearSolve function from the Tridiagonals class

        double[] V= new double[n];
        for (int i=0; i<n; i++)
        {V[i] = -h*h*v[i];
        }

        double[] w = Tridiagonals.linearSolve(M, V);

        // find the approximation for f(0.5) 
        double target = 0.5;
        double approximation = 0.0;
        //  assuming n>0
        for (int i=0; i<n; i++)
        {
            if (x[i] == target) // case where 0.5 is among the x[i]
            {
                approximation = w[i];
                break;
            }
            else if (x[i] < target && (i == n-1 || x[i+1] > target))  // case where 0.5 is not among the x[i]
            {
                // target is between x[i] and x[i+1]
                approximation = (w[i] + w[i+1]) / 2.0;
                break;
            }
        }

        return approximation;
    }
}
