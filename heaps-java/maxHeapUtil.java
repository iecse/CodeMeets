import java.util.Scanner;
import java.util.PriorityQueue;
public class maxHeapUtil
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++)
        {
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>(1000000,(x,y)->y-x);
            int q = in.nextInt();
            for(int j=0;j<q;j++)
            {
                int q1 = in.nextInt();
                if(q1==1)
                    heap.add(in.nextInt());   
                else if(q1==2)
                {
                    if(heap.size()!=0)
                        System.out.println(heap.peek());
                    else
                        System.out.println("Heap is empty!");       
                }
                else
                {
                    if(heap.size()==0)
                    {
                        System.out.println("Heap is empty!");
                        continue;
                    }
                    heap.poll();
                }
            }
        }
    }
}