def bread_first_modified(x, y):
    maxs = 2**32
    arr = [-1] * maxs
    queue =[x]
    arr[x] = 0
    while queue:
        x = queue.pop(0)
        if x == y:
            return arr[x]
        if x -1 >= 0 and arr[x-1] == -1:
            arr[x-1] = 1 + arr[x]
            queue.append(x-1)
        if x + 3 < maxs and arr[x+3] == -1:
            arr[x+3] = 1 + arr[x]
            queue.append(x+3)
        if x * 2 < maxs  and arr[2 * x] == -1:
            arr[2 * x] = 1 + arr[x]
            queue.append(2 * x)

for _ in range(int(input())):
    a, b = list(map(int, input().strip().split(" ")))
    if a == b:
        print("0")
    else:
        print(bread_first_modified(a, b))
