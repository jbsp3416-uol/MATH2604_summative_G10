import static java.lang.Math.*;

/*
3). A DIFFERENTIAL EQUATION.
Write a function that takes a and n parameters
and returns an approximation for f(0.5).
Asssume n>0.
If 0.5 is not among the x_i, the approximation should be computed
by averaging over the approximations at the nearest available x_i.
*/

class ODE
{
    static double solve(double a, int n)
    {
        // set grid points
        double h = 1.0/ (n + 1);
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
            // build vector v
            
        }
        
        
        return 1.1;
    }
}
