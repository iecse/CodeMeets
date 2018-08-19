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
	int t;
	cin >> t;

	int n, temp;
	vector <int> minHeap, maxHeap;
	cin >> n;
	
	maxHeap.push_back(n);
	cout << maxHeap[0] << "\n";

	for (int i = 1; i < t; i++)
	{
		cin >> n;

		if (minHeap.size() == maxHeap.size())
		{
			if (n <= minHeap[0])
			{
				maxHeap.push_back(n);
				push_heap(maxHeap.begin(), maxHeap.end());
			}

			else
			{
				temp = minHeap[0];
				pop_heap(minHeap.begin(), minHeap.end(), mycomp);
				minHeap.pop_back();

				maxHeap.push_back(temp);
				push_heap(maxHeap.begin(), maxHeap.end());

				minHeap.push_back(n);
				push_heap(minHeap.begin(), minHeap.end(), mycomp);
			}
		}

		else
		{
			if (n >= maxHeap[0])
			{
				minHeap.push_back(n);
				push_heap(minHeap.begin(), minHeap.end(), mycomp);
			}

			else
			{
				temp = maxHeap[0];
				pop_heap(maxHeap.begin(), maxHeap.end());
				maxHeap.pop_back();

				minHeap.push_back(temp);
				push_heap(minHeap.begin(), minHeap.end(), mycomp);	

				maxHeap.push_back(n);
				push_heap(maxHeap.begin(), maxHeap.end());
			}
		}

		if (maxHeap.size() == minHeap.size())
			cout << (maxHeap[0] + minHeap[0]) / (float)2 << "\n";
		
		else
			cout << maxHeap[0] << "\n";
	}

	return 0;
}