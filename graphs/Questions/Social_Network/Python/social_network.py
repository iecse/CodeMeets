## Question Link:  https://www.codechef.com/problems/SNET

from collections import defaultdict

adj = defaultdict(list)
visited = defaultdict(bool)

ans = 0

def dfs(u):
    stack = []
    stack.append(u)
    count = 0

    while len(stack):
        s = stack.pop()

        if not visited[s]:
            count += 1
            visited[s] = True

        for i in adj[s]:
            if not visited[i]:
                stack.append(i)

    return count
        

    
s = input().strip()

n = int(input().strip())

for i in range(n):
    u,v = input().strip().split(" ")
    adj[u].append(v)
    adj[v].append(u)

adj[s].sort()

maxi = 0
ch = "A"

visited[s] = True

for i in adj[s]:
    if not visited[i]:
        ans = dfs(i)
        if ans > maxi:
            maxi = ans
            ch = i


print(ch)
print(maxi)
