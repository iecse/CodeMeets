from collections import defaultdict 

class Graph: 
  
    def __init__(self): 
        self.graph = defaultdict(list) 

    def addEdge(self,u,v): 
        self.graph[u].append(v) 

    def BFS(self, s): 

        visited = [False] * (len(self.graph)) 

        queue = [] 

        queue.append(s) 
        visited[s] = True

        while queue: 

            s = queue.pop(0) 
            print (s, end = " ") 

            for i in self.graph[s]: 
                if visited[i] == False: 
                    queue.append(i) 
                    visited[i] = True



    def DFSHelper(self,v,visited): 
  
        visited[v]= True
        print v, 
  
        for i in self.graph[v]: 
            if visited[i] == False: 
                self.DFSHelper(i, visited) 
  
  
    def DFS(self,v): 
  
        visited = [False]*(len(self.graph)) 
        self.DFSHelper(v,visited)

    def minDistance(self, dist, sptSet): 
        min = 2**32
  
        for v in range(self.V): 
            if dist[v] < min and sptSet[v] == False: 
                min = dist[v] 
                min_index = v 
  
        return min_index 
  
    def dijkstra(self, src): 
  
        dist = [2**32] * self.V 
        dist[src] = 0
        sptSet = [False] * self.V 
  
        for cout in range(self.V): 
  
            u = self.minDistance(dist, sptSet) 
  
            sptSet[u] = True
  
            for v in range(self.V): 
                if self.graph[u][v] > 0 and sptSet[v] == False and 
                   dist[v] > dist[u] + self.graph[u][v]: 
                        dist[v] = dist[u] + self.graph[u][v] 
  
        self.printSolution(dist) 
