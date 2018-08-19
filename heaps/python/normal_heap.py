def heapify(a,i):
	right_child	= 2*i+1 
	left_child = 2*i 
	index=i
	if right_child<len(a) and a[index]<a[right_child]:
		index=right_child
	if left_child<len(a) and a[index]<a[left_child]:
		index=left_child
	if index!=i:
		temp = a[i]
		a[i] = a[index]
		a[index] = temp
		heapify(a,index)


def push_heap(a,val):
	a.append(val)
	i=len(a)-1
	while i!=0 and a[i]>a[i/2]:
		temp=a[i]                                              #swaping the larger element to the parent node
		a[i]=a[i/2]
		a[i/2]=temp
		i=i/2


def pop_heap(a):
	if(len(a)==0):
		print("not possible heap is empty")
		return
	if(len(a)==1):
		a.pop(1)

	a[1]=a[len(a)-1]
	a.pop(-1)
	heapify(a,1)


def increase_key(a,i,val):
	if val<=a[i]:
		print("value entered is lower or equal than existing value use some other function")
		return
	
	while i>=2 and a[i]>a[i/2]:
		temp=a[i]
		a[i]=a[i/2]
		a[i/2]=temp
		i=i/2

def decrease_key(a,i,val):
	if a[i]>val:
		print("value is higher than current value use some other function")
		return
	a[i]=val
	heapify(a,i)

def buildheap(a):
	for i in range(len(a)//2,0,-1):
		heapify(a,i)

def maxelem(a):
	print("max element is",a[1])
heap = [1,2,0,4,4,-1,4,55,-99]
buildheap(heap)
maxelem(heap)