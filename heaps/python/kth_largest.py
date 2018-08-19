import heapq as hp


l=list(map(int,input().split(' ')))
k=int(input())

minh=[]

for i in range(k):
	hp.heappush(minh,l[i])

for i in range(k,n):
	if l[i]>minh[0]:
		minh[0]=l[i]
		hp.heapify(minh)

print(minh[0])