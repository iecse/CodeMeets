#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool mycomp(int i, int j)
{
	return i > j;
}

int main()
{
	int T;
	cin >> T;

	int n, k;
	for (int i = 0; i < T; i++)
	{
		cin >> n >> k;

		vector <int> v(n-k);
		vector<int> minheap(k);
		for (int i = 0; i < k; i++)
			cin >> minheap[i];

		for (int i = 0; i < n-k; i++)
			cin >> v[i];

		make_heap(minheap.begin(), minheap.end(), mycomp);

		for (int i = 0; i < n-k; i++)
		{
			if (v[i] > minheap[0])
			{
				pop_heap(minheap.begin(), minheap.end(), mycomp);
				minheap.pop_back();

				minheap.push_back(v[i]);
				push_heap(minheap.begin(), minheap.end(), mycomp);
			}
		}

		cout << minheap[0] << "\n";
	}

	return 0;
}