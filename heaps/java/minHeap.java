import java.util.*;
class minHeapObject
{
    public ArrayList<Integer> heap;
    public int heap_length;
    minHeapObject()
    {
        heap = new ArrayList<Integer>();
        heap_length = 0;
    }
    minHeapObject(int arr[])
    {
        heap = new ArrayList<Integer>(arr.length);
        for(int i:arr)
            heap.add(i);
        heap_length = heap.size()-1;
        for(int i=heap_length/2;i>0;i--)
            heapify(i);
    }
    public void heapify(int index)
    {
        int l1 = 2*index;
        int l2 = (2*index) + 1;
        int smallest = index;
        if(l1<=this.heap_length && this.heap.get(l1)<this.heap.get(smallest))
            smallest = l1;
        if(l2<=this.heap_length && this.heap.get(l2)<this.heap.get(smallest))
            smallest = l2;
        if(smallest!=index)
        {
            int temp = this.heap.get(index);
            this.heap.set(index,this.heap.get(smallest));
            this.heap.set(smallest,temp);
            this.heapify(smallest);
        }
    }
    public void insertKey(int x)
    {
            heap.set(++heap_length,x);
            int parent = heap_length/2,child = heap_length;
            while (parent>0 && heap.get(parent)>heap.get(child))
            {
                int temp = heap.get(parent);
                heap.set(parent,heap.get(child));
                heap.set(child, temp);
                child = parent;
                parent/=2;
            }
    }
    public void increaseKey(int i,int new_val)
    {
        if (new_val<=heap.get(i))
	    {
		    System.out.println("Value Error");
		    return;
	    }
	    heap.set(i, new_val);
	    heapify(i);
    }
    public void decreaseKey(int i,int new_val)
    {
        if(new_val>=heap.get(i))
        {
            System.out.println("Value Error");
            return;
        }
        heap.set(i, new_val);
        while (i>=2 && (heap.get(i)<heap.get(i/2)))
	    {
            int temp = heap.get(i);
            heap.set(i,heap.get(i/2));
            heap.set(i/2,temp);
		    i/=2;
	    }
    }
    public void peek()
    {
        if(heap_length!=0)
            System.out.println(heap.get(1));
        else
            System.out.println("Underflow");
    }
    public void poll()
    {
        if(heap_length!=0)
        {
            if(heap_length>1)
            {
                int temp = heap.get(1);
                heap.set(1,heap.get(heap_length));
                heap.set(heap_length, temp);
                System.out.println(heap.get(heap_length--));
                heapify(1);
            }
            else
                System.out.println(heap.get(heap_length--));
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
        
        int arr[] = {0,2111,4,5,21111,10,12,100};
        minHeapObject obj = new minHeapObject(arr);
        obj.peek();
        obj.decreaseKey(2,-999999);
        obj.peek();
        //minHeapObject obj = new minHeapObject();
    }
}