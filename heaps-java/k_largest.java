import java.util.*;
public class k_largest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
	    int n, k;
	    for(int i=0;i<t;i++)
	    {
		    n = in.nextInt();
            k = in.nextInt();
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>(1000000,(x,y)->y-x);
            for(int j=0;j<n;j++)
                heap.add(in.nextInt());
		    while (k>1)
		    {
			    heap.poll();
			    k--;
		    }
            System.out.println(heap.peek());
	    }
    }
}