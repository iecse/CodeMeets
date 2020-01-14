#include<iostream>
#include<vector>
#include<algorithm>
#include<numeric>
#include<functional>
#define pb push_back;
typedef long long int ll;
using namespace std;
int main()
{
    ll t;
    cin>>t;
    ll n;
    ll k;
    while(t--)
    {
        cin>>n;
        vector<ll>v(n);
        for(ll i=0;i<n;i++)
        {
            cin>>k;
            v[i]=k;
        }
        ll sum=0;
        ll xo=0;
        for(ll i=0;i<n;i++)
        {
            sum+=v[i];
            xo^=v[i];
        }
        //cout<<sum<<" "<<xo<<endl;
        cout<<2<<endl;
        cout<<xo<<" "<<xo+sum<<endl;
    }
    return 0;
}