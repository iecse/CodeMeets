for _ in range(int(input())):
    n=int(input())
    j=0
    count=0
    while(n):
        if (n&1)==0:
            count+=(2**j)
        j+=1
        n>>=1
    print(count)        