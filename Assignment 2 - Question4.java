public class solution
{
    public static void main(String[] args)
	{
		int n=1;
		long sum = 1;
        while(n<Integer.MAX_VALUE)
	{
		if(sum == (long)n*(long)n )
		{
			if(n==1)
				System.out.println("Answer="+n);
			else
				break;
	}
	n+=1;
	sum+=n;
	}
	if(sum!=(long)n*(long)n)
	System.out.println("Sum= " +sum+ ",n= " +n + " i.e limitation of system ");
	if(sum==(long)n*(long)n)
		System.out.println("Sum= " +sum+ ",n= " +n);
	}
}