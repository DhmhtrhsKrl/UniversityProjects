package ergasia2;

public class main {

	static int numOfThreads =4;
	static int size= 25;
	static int iterations = (int) Math.pow(2, size);
    static String[] output = new String[iterations];
    static int block = iterations/numOfThreads;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
        CounterThread counterThreads[] = new CounterThread[numOfThreads];
		for (int i = 0; i < iterations; i++) {
			
		    counterThreads[i] =  new CounterThread(i);
		    counterThreads[i].start();
		}
	
        for (int i = 0; i < iterations; i++) {
            try {
				counterThreads[i].join();
            }
            catch (InterruptedException e) {}
            }

	}
	
	   
	   static void check_circuit (int z, int size, String[] output) {
	        
			boolean[] v = new boolean[size];  /* Each element is a bit of z */
	    
			for (int i = size-1; i >= 0; i--) 
				v[i] = (z & (1 << i)) != 0;
	    
	       
	       boolean value = 
	           (  v[0]  ||  v[1]  )
	        && ( !v[1]  || !v[3]  )
	        && (  v[2]  ||  v[3]  )
	        && ( !v[3]  || !v[4]  )
	        && (  v[4]  || !v[5]  )
	        && (  v[5]  || !v[6]  )
	        && (  v[5]  ||  v[6]  )
	        && (  v[6]  || !v[15] )
	        && (  v[7]  || !v[8]  )
	        && ( !v[7]  || !v[13] )
	        && (  v[8]  ||  v[9]  )
	        && (  v[8]  || !v[9]  )
	        && ( !v[9]  || !v[10] )
	        && (  v[9]  ||  v[11] )
	        && (  v[10] ||  v[11] )
	        && (  v[12] ||  v[13] )
	        && (  v[13] || !v[14] )
	        && (  v[14] ||  v[15] )
	        && (  v[14] ||  v[16] )
	        && (  v[17] ||  v[1]  )
	        && (  v[18] || !v[0]  )
	        && (  v[19] ||  v[1]  )
	        && (  v[19] || !v[18] )
	        && ( !v[19] || !v[9]  )
	        && (  v[0]  ||  v[17] )
	        && ( !v[1]  ||  v[20] )
	        && ( !v[21] ||  v[20] )
	        && ( !v[22] ||  v[20] )
	        && ( !v[21] || !v[20] )
	        && (  v[22] || !v[20] );
	        
	        /* choose one */
	        if (value) printResult(v, size, z);
	        saveAllResults(value, v, size, z, output);

	    }
	   
	   static void printResult (boolean[] v, int size, int z) {
			
			System.out.printf("%d) ", z);
			
			for (int i=0; i< size; i++)
				if (v[i]) System.out.printf(" 1");
				else System.out.printf(" 0");
			System.out.printf("\n");
		}
		
		static void saveAllResults (boolean value, boolean[] v, int size, int z,String[] out) {
			
			String result = null;
			result = String.valueOf(z);
			
			if (value) result += " : 1: ";
				else result += " : 0: ";

			for (int i=0; i< size; i++)
				if (v[i]) result += " 1";
				else result += " 0";
			
			out[z] = result;
		}
		
		static class CounterThread extends Thread {
		  	
		    //int threadID;
		    //int sizet;
		    //int iterationst;
		    //String[] outputt;
		    int start;
		    int stop;
		    //int b;
		    
		    
		   /* public CounterThread(int tid,int size,String[] output,int block ) {
		        this.threadID = tid;
		        this.sizet = size;
		        this.outputt = output;
		        this.b = block;
		    }*/
		    
		    int threadID;
		   
		    
		    public CounterThread(int tid) {
		        this.threadID = tid;
		        
		    }
		  	
		    
		  public void run() {
		    	
		    	start = block *threadID;
		    	stop = start + block;
		    	if(threadID == numOfThreads) {
		    		stop = numOfThreads - 1;
		    	}
			    
		    	
		    	for (int j= start; j < stop; j++) 
		            check_circuit (j, size, output);
		    	
		    }
		              
		    	
		         
		}
}
