import java.util.*;
class DAY4P2{
	static class pair{
		int r,c;
		pair(int a,int b){
			r=a;
			c=b;
		}
	}
	public static boolean isSafe(char ch[][],int dist[][],int row,int col){
		int n,m;
		n=ch.length;
		m=ch[0].length;
		if(row>=0 && row<n && col >=0 && col<m  && dist[row][col]==-1 && ch[row][col]!='#')
			return true;
		else 
			return false;
	}
	public static int bfs(char ch[][],int dist[][],pair s){
		Queue<pair> q=new LinkedList<pair>();
		q.add(s);
		int i;
		dist[s.r][s.c]=0;
		int row[]={-1,0,0,1};
		int col[]={0,-1,1,0};

		while(!q.isEmpty()){
			pair u=q.poll();
			int r=u.r,c=u.c;
			if(ch[r][c]=='E')
				return dist[r][c];
			for(i=0;i<4;i++){
				int tempr,tempc;
				tempr=r+row[i];
				tempc=c+col[i];
				if(isSafe(ch,dist,tempr,tempc)){
					dist[tempr][tempc]=dist[r][c]+1;
					q.add(new pair(tempr,tempc));
				}
			}
		}
		return -1;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n,m,i,j;
		n=sc.nextInt();
		m=sc.nextInt();

		char ch[][]=new char[n][m];

		for(i=0;i<n;i++){
			ch[i]=sc.next().toCharArray();
		}
		int dist[][]=new int[n][m];
		for(i=0;i<n;i++)
			Arrays.fill(dist[i],-1);

		pair s=null;
		j=0;
		findsrc:
		for(i=0;i<n;i++){
			for(j=0;j<m;j++){
				if(ch[i][j]=='S'){
					s=new pair(i,j);
					break findsrc;
				}
			}
		}

		int ans=bfs(ch,dist,s);
		System.out.println(ans);
	}
}