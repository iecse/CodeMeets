/* 
In a given array of integers All the numbers are repeated twice except 1. Find the unique number.
*/
#include<iostream>
#include<algorithm>
#include<vector>
typedef long long int ll;
#define pb push_back
using namespace std;
int main()
{
    ll n;
    cin>>n;
    ll arr[n];
    ll k;
    for(ll i=0;i<n;i++)
    {
        cin>>k;
        arr[i]=k;
    }
    ll xo=0;
    for(ll i=0;i<n;i++)
    {
        xo^=arr[i];
    }
    cout<<xo<<endl;
    return 0;
}