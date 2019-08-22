//Question Link:  https://www.codechef.com/problems/SNET

#include<iostream>
#include<algorithm>
#include<vector>
#include<map>

using namespace std;
#define inf -10000000000

int i; 
map< string , vector<string> > adj;
map< string, bool > visited;
long long ans=0;

void dfs(string u)
{
    visited[u]=true;
    ans+=1;
    for(auto it:adj[u])
    {
        if(!visited[it])
        {
            dfs(it);
        }
    }
}

int main() 
{ 
    string s;
    cin>>s;
    long long int n;
    cin>>n;

    for(i=1;i<=n;i++)
    {
        string u,v;
        cin>>u>>v;
        adj[u].__emplace_back(v); 
        adj[v].__emplace_back(u);
    }

    sort(adj[s].begin(),adj[s].end());
    visited[s] = true;
    long long int max = inf;
    string ch;

    for(auto it:adj[s])
    {
        if(!visited[it])
        {
            dfs(it);
            if(ans > max)
            {
                max=ans;
                ch=it;
            }
        }
        ans=0;
    }
    cout<<ch<<"\n"<<max<<"\n";
    return 0; 
}
