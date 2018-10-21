def game(arr):
    if(max(arr)<=1):
        return False
    for i in xrange(26):
        if(arr[i]!=0):
            arr[i]-=1
            if(game(arr[:])==False):
                return True
            arr[i]+=1
    return False
def prog():
    inp= raw_input()
    arr = [0]*26
    for i in inp:
        arr[ord(i)-97]+=1
    if(game(arr)==False):
        print "Watan"
    else:
        print "Karan"
t = input()
for i in xrange(t):
    prog()