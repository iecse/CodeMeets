#include <iostream>
using namespace std;

int main() {
	long long int t, p, temp, res, i;
	cin>>t;
	while(t--){
		temp=2048;
		res=0;
		cin>>p;
		for(i=0;i<12;i++){
			res=res+p/temp;
			p=p%temp;
			temp=temp/2;
		}
		cout<<res<<"\n";
	}
	return 0;
}