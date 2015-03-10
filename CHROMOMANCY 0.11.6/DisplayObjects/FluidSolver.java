package DisplayObjects;

/**
* This class is based off of the C++ implementation of Real Time Computational
* Fluid Dynamics For Games, by Jos Stam.  There are a number of algorithmic
* changes implemented for speed, but the variables and general algorithm were
* developed by Stam in his paper.
*/
public class FluidSolver {
	/**
	* One less then the number of cells on the grid.
	*/
	public static int N;
	/**
	* Shortcut method to map two numbers to their position in the data buffers.
	* @param i x value
	* @param j y value
	*/
	public static int IX(int i,int j) {
		if (i<0 || j<0 || i>799 || j>799) return 0;
		return ((i)+(N+2)*(j));
	}
	
	/**
	* Adds source to destination based on Euler's method.
	* @param N One less then the number of cells on the grid.
	* @param x Destination
	* @param s Source
	* @param dt time step
	*/
	public static void add_source ( int N, float[] x, float[] s, float dt )
	{
		int i, size=(N+2)*(N+2);
		for ( i=0 ; i<size ; i++ ) x[i] += dt*s[i];
	}
	/**
	* Interpolates and diffuses values at grid boundaries as an extension of
	* lin_solve.
	* @param N One less then the number of cells on the grid.
	* @param b Indicator to which boundary is being diffused
	* @param x Buffer of numbers to be damped at specificed boundary
	*/
	public static void set_bnd ( int N, int b, float[] x )
	{
	
		int i;

		for ( i=1 ; i<=N ; i++ ) {
			x[IX(0  ,i)] = b==1 ? -x[IX(1,i)] : x[IX(1,i)];
			x[IX(N+1,i)] = b==1 ? -x[IX(N,i)] : x[IX(N,i)];
			x[IX(i,0  )] = b==2 ? -x[IX(i,1)] : x[IX(i,1)];
			x[IX(i,N+1)] = b==2 ? -x[IX(i,N)] : x[IX(i,N)];
		}
		x[IX(0  ,0  )] = 0.5f*(x[IX(1,0  )]+x[IX(0  ,1)]);
		x[IX(0  ,N+1)] = 0.5f*(x[IX(1,N+1)]+x[IX(0  ,N)]);
		x[IX(N+1,0  )] = 0.5f*(x[IX(N,0  )]+x[IX(N+1,1)]);
		x[IX(N+1,N+1)] = 0.5f*(x[IX(N,N+1)]+x[IX(N+1,N)]);
	}
	/**
	* Diffuses all values from one databuffer into another.
	* @param N One less then the number of cells on the grid.
	* @param b Vertical or horizontal direction of diffusing
	* @param x Target for new data
	* @param x0 Initial data values
	* @param a Constant that measures how easily fluid moves between cells.
	* @param c Viscous damping constant
	*/
	public static void lin_solve ( int N, int b, float[] x, float[] x0, float a, float c )
	{
		int i, j, k;

		for ( k=0 ; k<1 ; k++ ) {
			for ( i=1 ; i<=N ; i++ ) { for ( j=1 ; j<=N ; j++ ) {
				x[IX(i,j)] = (x0[IX(i,j)] + a*(x[IX(i-1,j)]+x[IX(i+1,j)]+x[IX(i,j-1)]+x[IX(i,j+1)]))/c;
			}}
			set_bnd ( N, b, x );
		}
	}
	/**
	* @see lin_solve
	*/
	public static void diffuse ( int N, int b, float[] x, float[] x0, float diff, float dt )
	{
		float a=dt*diff*N*N;
		lin_solve ( N, b, x, x0, a, 1+4*a );
	}
	/**
	* Moves velocity field through itself to create movement
	* @param N One less then the number of cells on the grid.
	* @param b Vertical or horizontal direction of diffusing
	* @param d Target for new velocity
	* @param d0 Initial velocity values
	* @param u x velocity buffer
	* @param v y velocity buffer
	* @param dt time step
	*/
	public static void advect ( int N, int b, float[] d, float[] d0, float[] u, float[] v, float dt )
	{
		int i, j, i0, j0, i1, j1;
		float x, y, s0, t0, s1, t1, dt0;

		dt0 = dt*N;
		for ( i=1 ; i<=N ; i++ ) { for ( j=1 ; j<=N ; j++ ) {
			x = i-dt0*u[IX(i,j)]; y = j-dt0*v[IX(i,j)];
			if (x<0.5f) x=0.5f; if (x>N+0.5f) x=N+0.5f; i0=(int)x; i1=i0+1;
			if (y<0.5f) y=0.5f; if (y>N+0.5f) y=N+0.5f; j0=(int)y; j1=j0+1;
			s1 = x-i0; s0 = 1-s1; t1 = y-j0; t0 = 1-t1;
			d[IX(i,j)] = s0*(t0*d0[IX(i0,j0)]+t1*d0[IX(i0,j1)])+
						 s1*(t0*d0[IX(i1,j0)]+t1*d0[IX(i1,j1)]);
		}}
		set_bnd ( N, b, d );
	}
	/**
	* Projects the field onto a solenoidal field to ensure stability and
	* no system blow-ups.
	* @param N One less then the number of cells on the grid.
	* @param xVel x velocity buffer
	* @param yVel y velocity buffer
	* @param p pressure values buffer
	* @param div divergence values buffer
	*/
	public static void project ( int N, float[] xVel, float[] yVel, float[] p, float[] div )
	{
		int i, j;

		for ( i=1 ; i<=N ; i++ ) { for ( j=1 ; j<=N ; j++ ) {
			div[IX(i,j)] = -0.5f*(xVel[IX(i+1,j)]-xVel[IX(i-1,j)]+yVel[IX(i,j+1)]-yVel[IX(i,j-1)])/N;
			p[IX(i,j)] = 0;
		}}
		set_bnd ( N, 0, div ); set_bnd ( N, 0, p );

		lin_solve ( N, 0, p, div, 1, 4 );

		for ( i=1 ; i<=N ; i++ ) { for ( j=1 ; j<=N ; j++ ) {
			xVel[IX(i,j)] -= 0.5f*N*(p[IX(i+1,j)]-p[IX(i-1,j)]);
			yVel[IX(i,j)] -= 0.5f*N*(p[IX(i,j+1)]-p[IX(i,j-1)]);
		}}
		set_bnd ( N, 1, xVel ); set_bnd ( N, 2, yVel );
	}
	/**
	* This method steps the density of the system through time
	* @param N One less then the number of cells on the grid.
	* @param density The density buffer
	* @param x0 source values buffer
	* @param xVel x velocity buffer
	* @param yVel y velocity buffer
	* @param diff Diffusion constant
	* @param dt Time step
	*/
	public static void dens_step ( int N, float[] density, float[] x0, float[] xVel, float[] yVel, float diff, float dt )
	{
		add_source ( N, density, x0, dt );
		float[] temp=x0; x0=density; density=temp;
		diffuse ( N, 0, density, x0, diff, dt );
		temp=x0; x0=density; density=temp;
		advect ( N, 0, density, x0, xVel, yVel, dt );
	}
	/**
	* This method steps the velocity of the system through time
	* @param N One less then the number of cells on the grid.
	* @param xVel x velocity buffer
	* @param yVel y velocity buffer
	* @param u0 x velocity source buffer
	* @param v0 y velocity source buffer
	* @param visc Viscocity constant
	* @param dt Time step
	*/
	public static void vel_step ( int N, float[] xVel, float[] yVel, float[] u0, float[] v0, float visc, float dt )
	{
		add_source ( N, xVel, u0, dt ); add_source ( N, yVel, v0, dt );
		float[] temp=u0; u0=xVel; xVel=temp;
		diffuse ( N, 1, xVel, u0, visc, dt );
		temp=v0; v0=yVel; yVel=temp;
		diffuse ( N, 2, yVel, v0, visc, dt );
		project ( N, xVel, yVel, u0, v0 );
		temp=u0; u0=xVel; xVel=temp;
		temp=v0; v0=yVel; yVel=temp;
		advect ( N, 1, xVel, u0, u0, v0, dt ); advect ( N, 2, yVel, v0, u0, v0, dt );
		project ( N, xVel, yVel, u0, v0 );
	}
}
