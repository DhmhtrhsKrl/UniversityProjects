package erg5;

class numIntThread extends Thread{
private long numSteps;
private double sum;
private double localSum;
private double pi;
private int myStart;
private int myStop;
private int myId;
private double [] sums;

	public numIntThread(int id,long nSteps,int size,double summ,int numThreads,double[] ts)
	{
		myId=id;
		numSteps = nSteps;
		sum = summ;
		sums = ts;
		//pi = pi1;
		myStart = (int) (myId * (numSteps / numThreads));//(size / numThreads);
		myStop = (int) (myStart + (numSteps / numThreads));//(size / numThreads);
		if (myId == (numThreads - 1)) myStop = (int) numSteps;
		
	}
	
	public void run()
	{
		localSum = 0;
		double step = 1.0 / (double)numSteps;
        /* do computation */
        for (long i=myStart; i < myStop; ++i) {
            double x = ((double)i+0.5)*step;
            localSum += 4.0/(1.0+x*x);
        }
        sums[myId] = localSum; //* step;
        
	}
}
