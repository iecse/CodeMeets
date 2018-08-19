import heapq
n,m = [int(ele) for ele in input().split(" ")]
heap_list = [int(ele)*(-1) for ele in input().split(" ")]
heapq.heapify(heap_list)
ret = 0
for i in range(m):
    temp = heapq.heappop(heap_list)
    ret+=temp
    heapq.heappush(heap_list,temp+1)
print(ret*(-1))