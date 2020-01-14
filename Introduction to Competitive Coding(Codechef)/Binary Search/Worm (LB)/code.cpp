// https://codeforces.com/contest/474/problem/B

#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n,i;
    cin>>n;
    int a[n];
    for(i=0;i<n;i++)
        cin>>a[i];
    int m;
    cin>>m;
    int q[m];
    for(i=0;i<m;i++)
        cin>>q[i];
    int s=0,ps[n];
    for(i=0;i<n;i++)
    {
        s+=a[i];
        ps[i]=s;
    }
    for(i=0;i<m;i++)
    cout<<lower_bound(ps,ps+n,q[i])-ps+1<<endl;
    return 0;
}