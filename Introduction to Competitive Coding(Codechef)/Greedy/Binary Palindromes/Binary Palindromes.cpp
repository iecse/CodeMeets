#include<bits/stdc++.h>
using namespace std;
#define ll long long 
int main(){
    ll t, ct, n, i, j, ct1, ct0, f=0;
    cin>>t;
    while(t--){
    	ct0=0;
    	ct1=0;
    	f=0;
    	cin>>n;
    	string s;
    	for(i=0;i<n;i++){
    		cin>>s;
    		if(s.length()%2!=0){
    			f=1;
    		}
    		for(j=0;j<s.length();j++){
    			if(s[j]=='1'){
    				ct1++;
    			}
    			else{
    				ct0++;
    			}
    		}
    	}
    	if(f==1){
    		cout<<n<<endl;
    	}
    	else{
    		if(ct1%2==0&&ct0%2==0){
    			cout<<n<<endl;
    		}
    		else{
    			cout<<n-1<<endl;
    		}
    	}
    }
    return 0;
}