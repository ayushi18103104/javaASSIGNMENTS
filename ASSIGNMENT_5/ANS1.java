public class A1 extends Thread
{
	public static void main(String[] args)
	{
		A1 c = new A1();
		c.start();
	}

	public void run()
	{
		System.out.println("Program Started.");
		for(int i=1;i<=100;i++)
		{
			if (i%10 == 0)
			{
				System.out.println(i + " seconds done.");
			}

			else
			{
				System.out.println(i);
			}
		
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e){}
		}
	}
}