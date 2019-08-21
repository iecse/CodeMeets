#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int main()
{
    //Reading and storing the graph as adjacency list.
    int v,v1,v2; long int e;
    cin>>v>>e;
    queue<int> q;
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


    vector<int> enq;     //This will store the order in which vertices will be enqueued onto the queue, for your
                         //reference. We will print this at the end.

    bool visited[v+1]={0};


    //BFS Code
    for(int i=1;i<=v;i++)
{
    if(visited[i]==0)
    {
     visited[i]=1;
     q.push(i);
     while(!q.empty())
     {
         int V=q.front(); enq.push_back(V);q.pop();
         for(int j=0;j<a[V].size();j++)
         {
             if(visited[a[V][j]]==0)
             {
                 q.push(a[V][j]);
                 visited[a[V][j]]=1;
             }
         }
     }
   }
}//BFS finished

    //Printing the order in which vertices were enqueued
    cout<<"Enqueuing order:"<<endl;
    for(int i=0;i<enq.size();i++)
        cout<<enq[i]<<" ";
}
