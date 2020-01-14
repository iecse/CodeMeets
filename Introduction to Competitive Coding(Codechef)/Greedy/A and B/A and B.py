arr=[0]*100001
for i in range(1,100001):
    arr[i]=arr[i-1]+i
for _ in range(int(input())):
    a,b=map(int,input().split())
    d=abs(a-b)
    if d==0:
        print(0)
    else:
        for i in range(1,100001):
            if(arr[i]>=d and (arr[i]-d)%2==0):
                print(i)
                break
           