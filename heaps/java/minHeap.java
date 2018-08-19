import java.util.Scanner;
class minHeapObject
{
    public final int MAX_SIZE = 100;
    public int[] heap;
    public int heap_length;
    minHeapObject()
    {
        heap = new int[MAX_SIZE];
        heap_length = 0;
    }
    minHeapObject(int arr[])
    {
        heap = arr;
        heap_length = heap.length-1;
        for(int i=heap_length/2;i>0;i--)
            heapify(i);
    }
    public void heapify(int index)
    {
        int l1 = 2*index;
        int l2 = (2*index) + 1;
        int smallest = index;
        if(l1<=this.heap_length && this.heap[l1]<this.heap[smallest])
            smallest = l1;
        if(l2<=this.heap_length && this.heap[l2]<this.heap[smallest])
            smallest = l2;
        if(smallest!=index)
        {
            int temp = this.heap[index];
            this.heap[index] = this.heap[smallest];
            this.heap[smallest] = temp;
            this.heapify(smallest);
        }
    }
    public void insertKey(int x)
    {
        if(heap_length==MAX_SIZE-1)
            System.out.println("Overflow");
        else
        {
            heap[++heap_length] = x;
            int parent = heap_length/2,child = heap_length;
            while (parent>0 && heap[parent]>heap[child])
            {
                int temp = heap[parent];
                heap[parent] = heap[child];
                heap[child] = temp;
                child = parent;
                parent/=2;
            }
        }
    }
    public void increaseKey(int i,int new_val)
    {
        if (new_val<=heap[i])
	    {
		    System.out.println("Value Error");
		    return;
	    }
	    heap[i] = new_val;
	    heapify(i);
    }
    public void decreaseKey(int i,int new_val)
    {
        if(new_val>=heap[i])
        {
            System.out.println("Value Error");
            return;
        }
        heap[i] = new_val;
        while (i>=2 && (heap[i]<heap[i/2]))
	    {
            int temp = heap[i];
            heap[i] = heap[i/2];
            heap[i/2] = temp;
		    i/=2;
	    }
    }
    public void peek()
    {
        if(heap_length!=0)
            System.out.println(heap[1]);
        else
            System.out.println("Underflow");
    }
    public void poll()
    {
        if(heap_length!=0)
        {
            if(heap_length>1)
            {
                int temp = heap[1];
                heap[1] = heap[heap_length];
                heap[heap_length] = temp;
                System.out.println(heap[heap_length--]);
                heapify(1);
            }
            else
                System.out.println(heap[heap_length--]);
        }
        else
            System.out.println("Underflow");
    }
}
public class minHeap
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        //Overloaded constructors to assign arrays or empty heaps
        
        /*int arr[] = {0,2111,4,5,21111,10,12,100};
        minHeapObject obj = new minHeapObject(arr);
        obj.decreaseKey(2,-999999);
        obj.peek();
        minHeapObject obj = new minHeapObject();*/
    }
}