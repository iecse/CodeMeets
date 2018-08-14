#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int T;
	cin >> T;

	int n, k;
	for (int i = 0; i < T; i++)
	{
		cin >> n >> k;

		vector <int> maxHeap(n);
		for (int i = 0; i < n; i++)
			cin >> maxHeap[i];

		make_heap(maxHeap.begin(), maxHeap.end());

		while (k > 0)
		{
			cout << maxHeap[0] << " ";

			pop_heap(maxHeap.begin(), maxHeap.end());
			maxHeap.pop_back();

			k--;
		}

		cout << "\n";
	}

	return 0;
}