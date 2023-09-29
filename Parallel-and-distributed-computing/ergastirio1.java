package erg1;

public class ergastirio1 {
	public static void main(String[] args) {
		
		int numOfThreads1 = 4;
		int numOfThreads2 = 4;
		
		Thread[] threads = new Thread[numOfThreads1];

        int i = 0;
        while (i < numOfThreads1) {
            
            
            System.out.println("Starting thread " + i);
            threads[i] = new Thread(new ThOne(i));
            threads[i].start();
            i++;
        }
        
        i = 0;
        while (i < numOfThreads1) {
            
           
            System.out.println("Stopping thread " + i);
            threads[i].interrupt();
            try {
                threads[i].join();
            }
            catch (InterruptedException e) {
                System.out.println("This should not happen");
            }
            i++;
        }
		
        
        Thread[] threads2 = new Thread[numOfThreads2];

        int j = 0;
        while (j < numOfThreads1) {
            
            
            System.out.println("Starting thread " + i);
            threads[j] = new Thread(new ThTwo(j));
            threads[j].start();
            j++;
        }
		
        j = 0;
        while (j < numOfThreads1) {
            
           
            System.out.println("Stopping thread " + j);
            threads[j].interrupt();
            try {
                threads[j].join();
            }
            catch (InterruptedException e) {
                System.out.println("This should not happen");
            }
            j++;
        }
		
		
		
		
		
	}
}

class ThOne implements Runnable{
	
   private int myID;

   public ThOne(int myID) {
       this.myID = myID;
   }
	
	public void run() {
		try {
			System.out.println("Hello World" + myID );
			
           
 	} catch (Exception e) {}
		
		
	}
}

class ThTwo implements Runnable{
	
	private int myID;
	private double c;

   public ThTwo(int myID) {
       this.myID = myID;
   }
	
	public void run() {
		try {
			
			c = c * myID;
			System.out.println(myID + c);
			
           
 	} catch (Exception e) {}
		
		
	}
}