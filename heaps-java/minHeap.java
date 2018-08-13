import java.util.Scanner;
class minHeapObject
{
    public final int MAX_SIZE = 1000000;
    public int[] heap;
    public int heap_length;
    minHeapObject()
    {
        heap = new int[MAX_SIZE];
        heap_length = 0;
    }
    public void heapifyUp(int index)
    {
        int l1 = 2*index;
        int l2 = (2*index) + 1;
        int largest = index;
        if(l1<=this.heap_length && this.heap[l1]<this.heap[largest])
            largest = l1;
        if(l2<=this.heap_length && this.heap[l2]<this.heap[largest])
            largest = l2;
        if(largest!=index)
        {
            int temp = this.heap[index];
            this.heap[index] = this.heap[largest];
            this.heap[largest] = temp;
            if((index/2)>0)
                this.heapifyUp(index/2);
        }
    }
    public void heapifyDown(int index)
    {
        int l1 = 2*index;
        int l2 = (2*index) + 1;
        int largest = index;
        if(l1<=this.heap_length && this.heap[l1]<this.heap[largest])
            largest = l1;
        if(l2<=this.heap_length && this.heap[l2]<this.heap[largest])
            largest = l2;
        if(largest!=index)
        {
            int temp = this.heap[index];
            this.heap[index] = this.heap[largest];
            this.heap[largest] = temp;
            this.heapifyDown(largest);
        }
    }
}
public class minHeap
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        minHeapObject obj = new minHeapObject();
        int q = in.nextInt();
        for(int j=0;j<q;j++)
        {
            int q1 = in.nextInt();
            if(q1==1)
            {
                obj.heap[++obj.heap_length] = in.nextInt();
                if(obj.heap_length>1)
                    obj.heapifyUp(obj.heap_length/2);     
            }
            else if(q1==2)
            {
                if(obj.heap_length==0)
                {
                    System.out.println("Heap is empty!");
                    continue;
                }
                System.out.println(obj.heap[1]);
            }
            else
            {
                if(obj.heap_length==0)
                {
                    System.out.println("Heap is empty!");
                    continue;
                }
                int temp = obj.heap[obj.heap_length];
                obj.heap[obj.heap_length] = obj.heap[1];
                obj.heap[1] = temp;
                obj.heap_length--;
                obj.heapifyDown(1);
            }
        }
    }
}