import java.util.Scanner;
import java.util.PriorityQueue;
public class faultySystems
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(1000000,(x,y)->y-x);
        int n,m;
        n = in.nextInt();
        m = in.nextInt();
        for(int i=0;i<n;i++)
            heap.add(in.nextInt());
        int ret = 0;
        for(int i=0;i<m;i++)
        {
            ret = ret + heap.peek();
            heap.add(heap.poll()-1);
        }
        System.out.println(ret);
    }
}