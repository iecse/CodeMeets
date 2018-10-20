#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

#define pb push_back

vector <int> grundy;
string inp;

int solve(int mask)
{
	if (mask == 0)							// no possible moves
		return 0;

	if (grundy[mask] != -1)					// check if already calculated
		return grundy[mask];

	int hash[26] = {}, flag = 0;
	for (int i = 0; i < inp.length(); i++)	// count occurrence of each character
	{
		if (mask & (1 << i))
			hash[inp[i] - 'a']++;
	}

	for (int i = 0; i < 26; i++)
	{
		if (hash[i] > 1)					// check for duplicates
		{
			flag = 1;
			break;
		}
	}

	if (flag == 0)							// no duplicates means game over
	{
		grundy[mask] = 0;
		return 0;
	}

	vector <int> list;
	for (int i = 0; i < inp.length(); i++)
	{
		if (mask & (1 << i))				// check if element exists and go to possible game states
			list.pb(solve(mask - (1 << i)));
	}

	sort(list.begin(), list.end());
	int mex = 0;
	for (auto i : list)						// finding mex
	{
		if (mex < i)
			break;
		
		if (mex == i)
			mex++;
	}

	grundy[mask] = mex;
	return grundy[mask];
}

int main()
{
	int T;
	cin >> T;

	int mask;
	for (int i = 0; i < T; i++)
	{
		cin >> inp;

		mask = (1 << inp.length());
		mask--;

		vector <int> temp((1 << inp.length()), -1);
		//initialize grundy to -1
		grundy = temp;

		solve(mask) == 0 ? cout << "Watan\n" : cout << "Karan\n";
	}

	return 0;
}