import java.util.*;
public class RMID_hrank
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n,temp;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1000000,(x,y)->y-x);
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(1000000);
        n = in.nextInt();
        maxHeap.add(n);
        System.out.println(maxHeap.peek());
        for(int i=1;i<t;i++)
        {
            n = in.nextInt();
            if(minHeap.size()==maxHeap.size())
            {
                if (n <= minHeap.peek())
                {
                    maxHeap.add(n);
                }

                else
                {
                    temp = minHeap.peek();
                    minHeap.poll();
                    maxHeap.add(temp);
                    minHeap.add(n);
                }
            }
            else
            {
                if (n >= maxHeap.peek())
                {
                    minHeap.add(n);
                }
                else
                {
                    temp = maxHeap.peek();
                    maxHeap.poll();
                    minHeap.add(temp);    
                    maxHeap.add(n);
                }
            }
            if (maxHeap.size() == minHeap.size())
                System.out.println((maxHeap.peek()+minHeap.peek())/(float)(2));
            else
                System.out.println(maxHeap.peek());
        }
    }
}