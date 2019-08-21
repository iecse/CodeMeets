#include<bits/stdc++.h>
using namespace std;

int bfs(int x, int y)
{
    int maxval = 2001;
    vector<int> graph(maxval, -1);
    queue<int> q;
    q.push(x);
    graph[x] = 0;
    while(!q.empty())
    {
        x = q.front();
        q.pop();
        if(x == y)
            return graph[x];
        if(x-1 >= 0 && graph[x-1] == -1) //negative number cannot be destination, if the number has not already been visited than only it is to be pushed
        {
            graph[x-1] = 1 + graph[x];
            q.push(x-1);
        }
        if(x+3 < maxval && graph[x+3] == -1)    /*destination number cannot be greater than 2000,
                                                if the number has not already been visited than only it is to be pushed*/
        {
            graph[x+3] = 1 + graph[x];
            q.push(x+3);
        }
        if(x*2 < maxval && graph[2*x] == -1)//destination number cannot be greater than 2000
        {
            graph[2*x] = 1 + graph[x];
            q.push(2*x);
        }
    }
}

int main()
{
    int t, x, y;
    cin >> t;
    while(t--)
    {
        cin >> x >> y;
        cout << bfs(x, y) << endl;
    }
    return 0;
}
