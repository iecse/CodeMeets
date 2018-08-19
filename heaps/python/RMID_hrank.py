import heapq
t = int(input())
maxHeap = []
minHeap = []
n = int(input())
maxHeap.append(n*(-1))
print(n)
for i in range(t-1):
    n = int(input())
    if len(minHeap)==len(maxHeap):
        if n<=minHeap[0]:
            heapq.heappush(maxHeap,n*(-1))
        else:
            temp = heapq.heappop(minHeap)
            heapq.heappush(maxHeap,temp*(-1))
            heapq.heappush(minHeap,n)
    else:
        if n>=(maxHeap[0]*(-1)):
            heapq.heappush(minHeap,n)
        else:
            temp = heapq.heappop(maxHeap)
            heapq.heappush(minHeap,temp*(-1))
            heapq.heappush(maxHeap,n*(-1))
    if len(maxHeap)==len(minHeap):
        print(((maxHeap[0]*(-1))+minHeap[0])/2)
    else:
        print(maxHeap[0]*(-1))