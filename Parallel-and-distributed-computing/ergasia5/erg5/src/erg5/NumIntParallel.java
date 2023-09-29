package erg5;

public class NumIntParallel {

	

	public static void main(String[] args)
	{
	int size = 0;
    int numThreads = 5;
    double sum = 0.0;
    long numSteps = 10;
    
    
	numIntThread threads[] = new numIntThread[numThreads];
	
	double[] tsum = new double[numThreads];
	for(int i = 0; i < numThreads; i++)
		tsum[i] = 0.0;
	
	for (int i = 0; i < numThreads; i++) 
	{
		threads[i] = new numIntThread(i,numSteps,size,sum,numThreads,tsum);
		threads[i].start();
	}
	
	for (int i = 0; i < numThreads; i++) {
		try {
			threads[i].join();
		} catch (InterruptedException e) {}
	}

	
	double pi = 0;
	double step = 1.0 / (double)numSteps;
	for (int i = 0; i <numThreads; i++) {
		//System.out.println(tsum[i]);
		sum = sum + tsum[i];
	}
	pi = sum * step;
	//System.out.println(pi);
	System.out.printf("sequential program results with %d steps\n", numSteps);
    System.out.printf("computed pi = %22.20f\n" , pi);
    System.out.printf("difference between estimated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
    //System.out.printf("time to compute = %f seconds\n", (double) (endTime - startTime) / 1000);
	}
}
