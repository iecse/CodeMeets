#include <bits/stdc++.h>
using namespace std;
 
int main() {
	long long int t, a, b, arr[100001], i;
	arr[0]=0;
	for(i=1;i<=100000;i++){
		arr[i]=arr[i-1]+i;
	}
	cin>>t;
	while(t--){
		cin>>a>>b;
		long long int d=abs(a-b);
		if(d==0){
			cout<<"0"<<"\n";
		}
		else{
			for(i=1;i<=100000;i++){
				if(arr[i]>=d&&((arr[i]-d)%2==0)){
					break;
				}
			}
			cout<<i<<"\n";
		}
		
	}
	return 0;
}