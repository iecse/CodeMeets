for _ in range(int(input())):
    ct0=0
    ct1=0
    f=0
    n=int(input())
    for i in range(n):
        s=input()
        if len(s)%2!=0:
            f=1
        for j in range(len(s)):
            if(s[j]=='1'):
                ct1+=1
            else:
                ct0+=1
    if f==1:
        print(n)
    else:
        if(ct1%2==0 and ct0%2==0):
            print(n)
        else:
            print(n-1)                        