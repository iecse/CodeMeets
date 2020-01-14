#include<bits/stdc++.h>
using namespace std;
double sqroot(int n,int precision)
{
	int l=1,r=n-1,m;
	double ans;
	while(l<=r)
	{	m=l+(r-l)/2;
		if(m*m==n)
			return m;
		else if(m*m<n)
		{
			l=m+1;
			ans=m;
		}
		else
			r=m-1;
	}
	double inc=0.1;
	for(int i=0;i<precision;i++)
	{
		while(ans*ans<=n)
		{
			ans+=inc;
		}
		ans-=inc;
		inc=inc/10;
	}
	return ans;
}
int main()
{
	cout<<sqroot(3465,4)<<endl;
}