
def heapify(a,i):
	right_child	= 2*i+1 
	left_child = 2*i 
	index=i
	if a[i]<right_child and right_child<len(a):
		temp=a[i]                                              """swaping the larger element to the parent node"""
		a[i]=a[right_child]
		a[right_child]=temp
		index=right_child

	if a[i]<left_child and left_child<len(a):
		temp=a[i]                                              """swaping the larger element to the parent node"""
		a[i]=a[left_child]
		a[left_child]=temp
		index=left_child

	if index==i:
		return

	
	heapify(a,index)


def push_heap(a,val):
	a.append(val)
	i=len(a)-1
	while i!=0 and a[i]>a[i/2]:
		temp=a[i]                                              """swaping the larger element to the parent node"""
		a[i]=a[i/2]
		a[i/2]=temp
		i=i/2


def pop_heap(a):
	if(len(a)==0)
		print("not possible heap is empty")
		return
	if(len(a)==1)
		a.pop(1)

	a[1]=a[len(a)-1]
	a.pop(-1)
	heapify(a,1)


def increase_key(a,i,val):
	if val<=a[i]:
		print("value entered is lower or equal than existing value use some other function")
		return
	
	while i>=1 and a[i]>a[i/2]:
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
	for i in range(len(a)/2,1,-1):
		heapify(a,i)

def maxelem(a):
	print("max element is",a[1])