#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;
void explore(int w, bool visited[],vector<int> a[],vector<int> &push,vector<int> &pop);
stack <int> s;
int main()
{
    //Reading and storing the graph as adjacency list.
    int v,v1,v2; long int e;
    cin>>v>>e;
    vector<int> a[v+1];

    for(long int i=0;i<e;i++)
    {
        cin>>v1>>v2;
        a[v1].push_back(v2);
        a[v2].push_back(v1);
    }

    //sorting for lexicographical order.
    for(int i=1;i<=v;i++)
        sort(a[i].begin(),a[i].end());

    vector<int> push,pop; //these will store the order in which vertices are pushed and popped from
                          //the recursive call stack, for your reference. We will print this at the end.
    bool visited[v+1]={0};

    //DFS Code
    for(int i=1;i<=v;i++)
    {
        if(visited[i]==0)
            explore(i,visited,a,push,pop); //calling recursive explore for source vertex 'i'.
    }//DFS finished.

    //printing the order in which vertices were pushed and popped.
    for(int i=0;i<push.size();i++)
        cout<<push[i]<<" ";
    cout<<endl;
    for(int i=0;i<pop.size();i++)
        cout<<pop[i]<<" ";
}




//Recursive function to explore all vertices
void explore(int w, bool visited[],vector<int> a[],vector<int> &push,vector<int> &pop)
{
    visited[w]=1;
    s.push(w); push.push_back(w);
            for(int j=0;j<a[w].size();j++)
            {
                if(visited[a[w][j]]==0)
                    explore(a[w][j],visited,a,push,pop); //recursively exploring unvisited neighbours of vertex 'w'
            }
    pop.push_back(s.top()); s.pop();
}
