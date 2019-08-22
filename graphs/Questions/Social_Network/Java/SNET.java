//Question Link:  https://www.codechef.com/problems/SNET

import java.util.*;
class SNET{

	public static int dfs(HashMap<String,ArrayList<String>> adj, HashMap<String,Boolean> vis,String curr,int count){
		vis.put(curr,true);
		count++;
		for(String v: adj.get(curr)){
			if(!vis.get(v))
				count=dfs(adj,vis,v,count);
		}
		return count;
	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String x,a,b;
		HashMap<String,ArrayList<String>> adj=new HashMap<String,ArrayList<String>>();
		HashMap<String,Boolean> vis=new HashMap<String,Boolean>();
		int k;
		x=sc.next();
		k=sc.nextInt();
		while(k-->0){
			a=sc.next();
			b=sc.next();
			ArrayList<String> u;
			ArrayList<String> v;

			if(!adj.containsKey(a) && !adj.containsKey(b)){
				u=new ArrayList<String>();
				v=new ArrayList<String>();
				u.add(b);
				v.add(a);
			}

			else if(!adj.containsKey(a)){
				u=new ArrayList<String>();
				v=adj.get(b);
				u.add(b);
				v.add(a);
			}
			else if(!adj.containsKey(b)){
				u=adj.get(a);
				v=new ArrayList<String>();
				u.add(b);
				v.add(a);
			}
			else{
				u=adj.get(a);
				v=adj.get(b);
				u.add(b);
				v.add(a);
			}
			adj.put(a,u);
			adj.put(b,v);
			vis.put(a,false);
			vis.put(b,false);
		}
		vis.put(x,true);
		int max=0;
		String ans="";
		Collections.sort(adj.get(x));
		for(String u: adj.get(x)){
			int temp;
			if(!vis.get(u)){
				temp= dfs(adj,vis,u,0);
				if(temp>max){
					max=temp;
					ans=u;
				}
			}
		}
		System.out.println(ans);
		System.out.println(max);


	}
}