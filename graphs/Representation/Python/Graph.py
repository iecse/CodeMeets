from collections import defaultdict 
  
graph = defaultdict(list) 
def addEdge(graph,u,v): 
    graph[u].append(v) 
  
def generate_edges(graph): 
    edges = [] 
    for node in graph:
        for neighbour in graph[node]: 
            edges.append((node, neighbour)) 
    return edges 
  
addEdge(graph,'a','c') 
addEdge(graph,'b','c') 
addEdge(graph,'b','e') 
addEdge(graph,'c','d') 
  
print(generate_edges(graph)) 