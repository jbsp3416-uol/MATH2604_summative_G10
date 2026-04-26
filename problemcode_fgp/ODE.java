import static java.lang.Math.*;

class ODE

/*
3). A DIFFERENTIAL EQUATION.
Write a function that takes a and n parameters
and returns an approximation for f(0.5).
Asssume n>0.
If 0.5 is not among the x_i, the approximation should be computed
by averaging over the approximations at the nearest available x_i.
*/


{
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
            if (x[i] == target) 
            {
                approximation = w[i];
                break;
            }
            else if (x[i] < target && (i == n-1 || x[i+1] > target)) 
            {
                // target is between x[i] and x[i+1]
                approximation = (w[i] + w[i+1]) / 2.0;
                break;
            }
        }

        return approximation;
    }
}
