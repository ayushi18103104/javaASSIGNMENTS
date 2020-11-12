public class A2 extends Thread {

	static int max = 0, num = 0;
	int start;
	
	public A2(int start) {
		this.start = start;
	}

	public static void main(String[] args) {

		A2 t1 = new A2(1); 
		A2 t2 = new A2(20001); 
		A2 t3 = new A2(40001);
		A2 t4 = new A2(60001); 
		A2 t5 = new A2(80001);

		long start = System.currentTimeMillis();
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} 
		catch(Exception e){}

		long end = System.currentTimeMillis();
		System.out.println("This has been performed with 5 threads. \nOn executing with 10 threads, time increases.\n");
		System.out.println(num + " has maximum (" + max + ") number of divisors.");
		System.out.println("Total time elapsed = " + (end-start)/1000.00 + " seconds.");
	}

	public void run() {
		
		int div=0;
		
		for(int i=start; i<this.start+10000; i++) {
			
			div=0;
			for(int j=1; j<=i; j++) {

				if(i%j==0) {
				
					div+=1;
				}
			}

			if(div>max) {

				synchronized(this) {
					
					max = div;
					num = i;
				}
			}
		}
	}
}