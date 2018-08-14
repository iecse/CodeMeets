//---------------------------Using Priority Queue--------------------------------
/*
#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int ni()
{
	int t;
	cin >> t;
	return t;
}

int main()
{
	int N, M;
	cin >> N >> M;

	priority_queue <int> pq;
	for (int i = 0; i < N; i++)
		pq.push(ni());

	int profit = 0, temp;
	for (int i = 0; i < M; i++)
	{
		temp = pq.top();
		profit += temp;

		pq.pop();
		pq.push(temp-1);
	}

	cout << profit << "\n";

	return 0;
}*/

//------------------------------Using Heap------------------------------------------

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int N, M;
	cin >> N >> M;

	vector <int> heap(N);

	for (int i = 0; i < N; i++)
		cin >> heap[i];

	make_heap(heap.begin(), heap.end());

	int profit = 0, temp;
	for (int i = 0; i < M; i++)
	{
		temp = heap.front();
        profit += temp;

		pop_heap(heap.begin(), heap.end());
        heap.pop_back();
        
        heap.push_back(temp-1);
        push_heap(heap.begin(), heap.end());
	}

	cout << profit << "\n";

	return 0;
}