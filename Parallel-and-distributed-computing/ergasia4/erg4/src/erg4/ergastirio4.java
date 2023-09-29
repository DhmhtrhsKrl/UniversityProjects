package erg4;

public class ergastirio4 {
	
 
public static void main(String[] args) {
	
	int balance1=1000;	
	int cAnswer1 = 2;
	int cAnswer2 = 1;
	int cAnswer3 = 3;
	int cAnswer4 = 1;
	long amount1 = 200;
	long amount2 = 400;
	long amount3 = 70;
	long amount4 = 50;
	
	BankAccountReentrantReadWriteLock b = new BankAccountReentrantReadWriteLock(balance1);
	
	CounterThread ct1 = new CounterThread(0, b,cAnswer1,amount1);
	CounterThread ct2 = new CounterThread(1, b,cAnswer2,amount2);
	CounterThread ct3 = new CounterThread(2, b,cAnswer3,amount3);
	CounterThread ct4 = new CounterThread(3, b,cAnswer4,amount4);
	
	ct1.start();
	ct2.start();
	ct3.start();
	ct4.start();
	
}



static class CounterThread extends Thread {
	
	int threadID;
    long amount;
    int answer;
    BankAccountReentrantReadWriteLock bankaccount;
    
    public CounterThread(int tid, BankAccountReentrantReadWriteLock b,int a,long am) {
        this.threadID = tid;
        this.bankaccount = b;
        this.answer = a;
        this.amount = am;
        
    }
	public void run() {
		
		if(answer== 1) {
			bankaccount.deposit(amount);
			System.out.println("deposit completed");
		}
		else if(answer== 2) {
			bankaccount.withdraw(amount);
			System.out.println("withdraw completed");
		}
		else if(answer== 3) {
			bankaccount.getBalance();
			System.out.println("get balance completed");
		}
		else {
			System.out.println("give an answer between 1-3");
		}
		

	}
}
}
