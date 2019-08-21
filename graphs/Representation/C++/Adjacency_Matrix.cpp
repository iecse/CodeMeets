#include<bits/stdc++.h>
using namespace std;

int main()
{
    int vertex,edge;
    char type;
    cin>>vertex>>edge>>type;
    int arr[vertex+1][vertex+1];

    // Set all values to zero
    for(int i = 0; i < vertex; i++)
    {
        for(int j = 0; j < vertex; j++)
        {
            arr[i][j] = 0;
        }
    }

    //For Directed
    if(type == 'D')
    {
        for(int i = 1 ; i <= edge; i++)
        {
            int vertex1, vertex2;
            cin>>vertex1>>vertex2;          //Input the vertex between which edge exists
            arr[vertex1][vertex2] = 1;     //Make the value for coresponding edge to 1
        }
    }

    //For undirected
    else if(type == 'U')
    {
        for(int i = 0; i < edge ; i++)
        {
            int a,b;
            cin>>a>>b;
            arr[a][b] = arr[b][a] = 1;
        }
    }



    for(int i = 1; i <= vertex  ; i++)
    {
        for(int j = 1; j <= vertex ; j++)
        {
            cout<<arr[i][j];
        }
        cout<<endl;
    }
    return 0;
}
