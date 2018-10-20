#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <math.h>

using namespace std;

#define pb push_back

const int N_MAX = 1e5 + 5;

vector <int> grundy(N_MAX);
vector <int> operation;

void init()
{
	for (int i = 1; i <= 7; i++)							// add all possbile operations
		operation.pb(pow(i, i));

	grundy[0] = 0;											// base case

	for (int i = 1; i <= N_MAX; i++)
	{
		// set <int> list;
		vector <int> list;

		for (int j = 0; operation[j] <= i; j++)				// go to all possible games states
			list.pb(grundy[i - operation[j]]);

		sort(list.begin(), list.end());

		int mex = 0;
		for (auto j : list)									// find mex
		{
			if (mex < j)
				break;

			if (mex == j)	// if using vector, if condition is required
				mex++;

			// mex++;		// if using set instead of vector
		}

		grundy[i] = mex;
	}
}

int main()
{
	init();

	int T;
	cin >> T;

	int N;
	for (int i = 0; i < T; i++)
	{
		cin >> N;
		vector <int> A(N);

		for (int j = 0; j < N; j++)
			cin >> A[j];

		int res = 0;
		for (int j = 0; j < N; j++)				// sprague - grundy theorem
			res ^= grundy[A[j]];

		res == 0 ? cout << "Head Chef\n" : cout << "Little Chef\n";
	}

	return 0;
}