import heapq
t = int(input())
for i in range(t):
    n,k = map(int,input().split(" "))
    heap_list = [int(ele)*(-1) for ele in input().split(" ")]
    heapq.heapify(heap_list)
    while k>1:
        heapq.heappop(heap_list)
        k-=1
    print(heapq.heappop(heap_list)*(-1))