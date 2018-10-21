gg=[1,4,27,256,3125,46656]  #1^1  2^2 3^3 4^4 5^5 6^6 as these are the only values that can be taken in range

def mex(L):
    L.sort()
    for i in range(10):
        if i not in L:
            return i

G=[0]*(100005)
for i in range(100005):
    temp=[]
    j=0
    while j<len(gg) and gg[j]<=i:
        temp.append(G[i-gg[j]])
        j+=1
    G[i]=mex(temp)
    
tt=int(input())
for tt in range(tt):
    n=int(input())
    L=list(map(int,input().split(' ')))
    ans=0
    for i in L:
        ans^=G[i]
    if ans==0:
        print('Head Chef')
    else:
        print('Little Chef')