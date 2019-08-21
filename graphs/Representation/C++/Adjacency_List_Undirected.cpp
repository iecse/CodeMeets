#include<bits/stdc++.h>
using namespace std;

int main()
{
	int vertex,edge;
	cin>>vertex>>edge;

	vector < int > v[vertex + 1]; // 2D vector initalization

	for(int i = 0 ; i < edge ; i++)
	{
		int vertex1, vertex2;
		cin>>vertex1>>vertex2;   // Input of vertex b/w which edge exists

		if(count(v[vertex1].begin(), v[vertex1].end(),vertex2) == 0)  // Checking for duplicate edges
			v[vertex1].push_back(vertex2);			//Adding edge to the list

		if(count(v[vertex2].begin(), v[vertex2].end(),vertex1) == 0)  // Checking for duplicate edges
			v[vertex2].push_back(vertex1);			//Adding edge to the list
	}

	//Printing the list
	for(int i = 1; i <= vertex ; i++)
    {
        cout<<i<<" ";
        for(int t = 0; t < v[i].size() ; t++)
        {
            cout<<v[i][t]<<" ";
        }
        cout<<endl;        
    }
}