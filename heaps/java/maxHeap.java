import java.util.*;
class maxHeapObject
{
    public ArrayList<Integer> heap;
    public int heap_length;
    maxHeapObject()
    {
        heap = new ArrayList<Integer>();
        heap_length = 0;
    }
    maxHeapObject(int arr[])
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
        int largest = index;
        if(l1<=this.heap_length && this.heap.get(l1)>this.heap.get(largest))
            largest = l1;
        if(l2<=this.heap_length && this.heap.get(l2)>this.heap.get(largest))
            largest = l2;
        if(largest!=index)
        {
            int temp = this.heap.get(index);
            this.heap.set(index,this.heap.get(largest));
            this.heap.set(largest,temp);
            this.heapify(largest);
        }
    }
    public void insertKey(int x)
    {
            heap.set(++heap_length,x);
            int parent = heap_length/2,child = heap_length;
            while (parent>0 && heap.get(parent)<heap.get(child))
            {
                int temp = heap.get(parent);
                heap.set(parent,heap.get(child));
                heap.set(child,temp);
                child = parent;
                parent/=2;
            }
    }
    public void increaseKey(int i,int new_val)
    {
        if(new_val<=heap.get(i))
        {
            System.out.println("Value Error");
            return;
        }
        heap.set(i,new_val);
        while (i>=2 && (heap.get(i)>heap.get(i/2)))
	    {
            int temp = heap.get(i);
            heap.set(i,heap.get(i/2));
            heap.set(i/2,temp);
		    i/=2;
	    }
    }
    public void decreaseKey(int i,int new_val)
    {
        if (new_val>=heap.get(i))
	    {
		    System.out.println("Value Error");
		    return;
	    }
	    heap.set(i,new_val);
	    heapify(i);
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
                heap.set(1,heap.get(heap_length--));
                System.out.println(temp);
                heapify(1);
            }
            else
                System.out.println(heap.get(heap_length--));
        }
        else
            System.out.println("Underflow");
    }
}
public class maxHeap
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        //Overloaded constructors to assign arrays or an empty heap
        
        int arr[] = {0,2111,4,5,21111,10,12,100};
        maxHeapObject obj = new maxHeapObject(arr);
        obj.poll();
        obj.peek();
        obj.increaseKey(2,999999);
        obj.peek();
        //maxHeapObject obj = new maxHeapObject();
    }
}