package DisplayObjects;

public class FluidField {

	/**
	* Data Buffer that holds specified values for each cell on the Fluid
	* Field grid.
	*/
	public float[] rDensity,gDensity,bDensity,rSource,gSource,bSource,xVel,yVel,dXVel,dYVel;
	/**
	* Constant in the System.
	*/
	float diff, visc, dt;
	/**
	* Distance between gridlines.
	*/
	public int stepLen;
	/**
	* The primary display.
	*/
	public Display display;
	
	/**
	* Constructor.  It sets all of the constants and clears all of the buffers.
	*/
	public FluidField(int sideLength,int stepLen) {
		this.stepLen=stepLen;
		FluidSolver.N=sideLength-2;
		diff=0.0f;
		visc=0.0f;
		dt=.02f;
		rDensity=new float[sideLength*sideLength];
		gDensity=new float[sideLength*sideLength];
		bDensity=new float[sideLength*sideLength];
		rSource=new float[sideLength*sideLength];
		gSource=new float[sideLength*sideLength];
		bSource=new float[sideLength*sideLength];
		xVel=new float[sideLength*sideLength];
		yVel=new float[sideLength*sideLength];
		dXVel=new float[sideLength*sideLength];
		dYVel=new float[sideLength*sideLength];
	}
	/**
	* Steps the system using the FluidSolver class.  Then applies damping.
	*/
	public void step() {
		FluidSolver.vel_step(FluidSolver.N,xVel,yVel,dXVel,dYVel,visc,dt);
		FluidSolver.dens_step(FluidSolver.N,rDensity,rSource,xVel,yVel,diff,dt);
		FluidSolver.dens_step(FluidSolver.N,gDensity,gSource,xVel,yVel,diff,dt);
		FluidSolver.dens_step(FluidSolver.N,bDensity,bSource,xVel,yVel,diff,dt);
		for (int i=0;i<rDensity.length;i++) {
			rDensity[i]*=.99f;
			gDensity[i]*=.99f;
			bDensity[i]*=.99f;
			xVel[i]*=.99f;
			yVel[i]*=.99f;
		}
	}
	
	/**
	* Interpolates values between gridlines using the OpenGL shading
	* algorithm.  Outputs the 3 color values as an int with blue being
	* bits 0-8, green being 9-16, and red being 17-24.
	*/
	public int interpolatedDensity(int x,int y) {
		float rDens,gDens,bDens;
		float diagDens,downDens,upDens,leftDens,rightDens;
		float diagDist,downDist,upDist,leftDist,rightDist;
		if (x%stepLen>=y%stepLen) {
			diagDens=rDensity[FluidSolver.IX(x/stepLen+1,y/stepLen)];
			downDens=rDensity[FluidSolver.IX(x/stepLen+1,y/stepLen+1)];
			leftDens=rDensity[FluidSolver.IX(x/stepLen,y/stepLen)];
			rightDist=1.0f*(stepLen-x%stepLen)/stepLen;
			upDist=1.0f*y%stepLen/stepLen;
			diagDist=1-rightDist-upDist;
			rDens=upDist*downDens+rightDist*leftDens+diagDist*diagDens;
			diagDens=gDensity[FluidSolver.IX(x/stepLen+1,y/stepLen)];
			downDens=gDensity[FluidSolver.IX(x/stepLen+1,y/stepLen+1)];
			leftDens=gDensity[FluidSolver.IX(x/stepLen,y/stepLen)];
			gDens=upDist*downDens+rightDist*leftDens+diagDist*diagDens;
			diagDens=bDensity[FluidSolver.IX(x/stepLen+1,y/stepLen)];
			downDens=bDensity[FluidSolver.IX(x/stepLen+1,y/stepLen+1)];
			leftDens=bDensity[FluidSolver.IX(x/stepLen,y/stepLen)];
			bDens=upDist*downDens+rightDist*leftDens+diagDist*diagDens;
		} else {
		diagDens=rDensity[FluidSolver.IX(x/stepLen,y/stepLen+1)];
		rightDens=rDensity[FluidSolver.IX(x/stepLen+1,y/stepLen+1)];
		upDens=rDensity[FluidSolver.IX(x/stepLen,y/stepLen)];
		leftDist=1.0f*x%stepLen/stepLen;
		downDist=1.0f*(stepLen-y%stepLen)/stepLen;
		diagDist=1-leftDist-downDist;
		rDens=downDist*upDens+leftDist*rightDens+diagDist*diagDens;
		diagDens=gDensity[FluidSolver.IX(x/stepLen,y/stepLen+1)];
		rightDens=gDensity[FluidSolver.IX(x/stepLen+1,y/stepLen+1)];
		upDens=gDensity[FluidSolver.IX(x/stepLen,y/stepLen)];
		gDens=downDist*upDens+leftDist*rightDens+diagDist*diagDens;
		diagDens=bDensity[FluidSolver.IX(x/stepLen,y/stepLen+1)];
		rightDens=bDensity[FluidSolver.IX(x/stepLen+1,y/stepLen+1)];
		upDens=bDensity[FluidSolver.IX(x/stepLen,y/stepLen)];
		bDens=downDist*upDens+leftDist*rightDens+diagDist*diagDens;
		}
		int rCol=((int)(Math.abs(rDens)*15))%512;
		int gCol=((int)(Math.abs(gDens)*10))%512;
		int bCol=((int)(Math.abs(bDens)*5))%512;
		if (rCol>256) rCol=512-rCol;
		if (gCol>256) gCol=512-gCol;
		if (bCol>256) bCol=512-bCol;
		/*if (display.frameCount%6==0) return rCol<<16 | gCol<<8 | bCol;
		if (display.frameCount%6==1) return rCol<<16 | gCol | bCol<<8;
		if (display.frameCount%6==2) return rCol<<8 | gCol<<16 | bCol;
		if (display.frameCount%6==3) return rCol<<8 | gCol | bCol<<16;
		if (display.frameCount%6==4) return rCol | gCol<<16 | bCol<<8;
		return rCol | gCol<<8 | bCol<<16;*/
		return rCol<<16 | gCol<<8 | bCol;
	}

}