#include<iostream>
#include<cmath>
#include<algorithm>
#include<vector>
#define pb push_back
using namespace std;
typedef long long int ll;
int main()
{
    ll t;
    cin>>t;
    while(t--)
    {
        ll n;
        cin>>n;
        ll j=0;
        ll count=0;
        while(n)
        {
            if((n&1)==0)
            {
                count+=pow(2,j);
            }
            j+=1;
            n>>=1;
        }
        cout<<count<<endl;
    }
    return 0;
}