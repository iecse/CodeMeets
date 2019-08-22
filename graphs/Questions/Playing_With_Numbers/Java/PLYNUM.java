//Question Link:  https://www.codechef.com/ENAU2018/problems/PLYNUM

import java.util.*;
class PLYNUM{

	public static int bfs(int a,int b){

		int v1,v2,v3;
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(a);
		hm.put(a,0);

		while(!q.isEmpty()){
			int u=q.poll();
			int dist=hm.get(u);
			if(u==b)
				return dist;
				
			v1=u-1;
			v2=u+3;
			v3=u*2;

			if(v1>=0 && v1<=4000 && !hm.containsKey(v1)){
				hm.put(v1,dist+1);
				q.add(v1);
			}
			if(v2>=0 && v2<=4000 && !hm.containsKey(v2)){
				hm.put(v2,dist+1);
				q.add(v2);
			}
			if(v3>=0 && v3<=4000 && !hm.containsKey(v3)){
				hm.put(v3,dist+1);
				q.add(v3);
			}
		}
		return -1;
	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int t,a,b,ans;
		t=sc.nextInt();
		while(t-->0){
			a=sc.nextInt();
			b=sc.nextInt();
			if(b<=a)
				ans=a-b;
			else 
				ans=bfs(a,b);
			System.out.println(ans);
		}
	}
}