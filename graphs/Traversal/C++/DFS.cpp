#include <iostream>
#include <stack>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
    //Reading and storing the graph as adjacency list.
    stack<int> s;
    int v,v1,v2; long int e;
    int curr;
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

    vector<int> push,pop;   //these will store the order in which vertices are pushed and popped from
                            //the stack, for your reference. We will print this at the end.


    bool visited[v+1]={0};

    //DFS code
    for(int j=1;j<=v;j++)
    {
    if(visited[j]==0)
    {   s.push(j); push.push_back(s.top());
        visited[j]=1; curr=j;
        while(!s.empty())
        {
        int i=0;
        while(i<a[curr].size())
        {
            if(visited[a[curr][i]]==0)
            {
                visited[a[curr][i]]=1;
                s.push(a[curr][i]); push.push_back(s.top());
                curr=a[curr][i];
                i=0;
            }
            else i++;
        }
        pop.push_back(s.top()); s.pop();
        if(!s.empty())
        curr=s.top();
        }
    }
    }//DFS finished

    //printing the order in which vertices were pushed and popped.
    cout<<"Pushing order:"<<endl;
    for(int i=0;i<push.size();i++)
        cout<<push[i]<<" ";
    cout<<endl;
    cout<<"Popping order:"<<endl;
    for(int i=0;i<pop.size();i++)
        cout<<pop[i]<<" ";
}
