def isValid(x, y, dist, mat, m, n):
    return x>=0 and x < m and y >=0 and y<n and dist[x][y] == -1 and mat[x][y] != '#'

dist = [[-1 for i in range(1001)] for i in range(1001)]
mat = [[-1 for i in range(1001)] for i in range(1001)]

m, n = map(int,input().split(" "))

ci = [-1,0,0,1]
cj = [0,-1,1,0]

for i in range(m):
    string = input()
    for j in range(n):
        mat[i][j] = string[j]
        dist[i][j] = -1
        if string[j]== 'S':
            srcx = i
            srcy = j
        elif string[j] == 'E':
            exitx = i
            exity = j
Q = []

dist[srcx][srcy] = 0
Q.append((srcx,srcy))
while len(Q):
    x = Q[0][0]
    y = Q[0][1]
    if x == exitx and y == exity:
        break
    Q.pop(0)
    for i in range(4):
        curr_x = x+ci[i]
        curr_y = y+cj[i]
        if isValid(curr_x, curr_y, dist, mat, m, n):
            Q.append((curr_x, curr_y))
            dist[curr_x][curr_y] = dist[x][y] + 1

print(dist[exitx][exity])
    
