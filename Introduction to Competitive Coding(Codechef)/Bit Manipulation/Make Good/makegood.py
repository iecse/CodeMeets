for _ in range(int(input())):
    n=int(input())
    li=list(map(int,input().split()))
    su=0
    xor=0
    for i in li:
        su+=i
        xor^=i
    print(2)
    print(xor,su+xor)    