import java.util.*;

public class BFS
{
    public static void bfs(int vec,Queue<Integer> q,ArrayList<Integer> a[])
    {
        boolean visited[]= new boolean[vec+1];
        Arrays.fill(visited,false);
        
        for(int i=1;i<=vec;i++)
        {
            if(!visited[i])
            {
                
                visited[i]=true;
                q.add(i);
                
                while(!q.isEmpty())
                {
                    int V = q.poll();
                    
                    for(int j=0; j<a[V].size(); j++)
                    {
                        int Val= (int) a[V].get(j);
                        
                        if(!visited[Val])
                        {
                            q.add(Val); 
                            visited[Val]=true;
                        }
                    }
                }
            }
        }
    }
    
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("HI");
        
        int vec, vec1, vec2; 
        long edg;
        
        vec = sc.nextInt();
        edg = sc.nextLong();
        
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> a[]= new ArrayList[vec+1];
        
        for(int i=0;i<=vec;i++)
        {
            a[i]= new ArrayList();
        }
        
        for(long i=0;i<edg;i++)
        {
            vec1 = sc.nextInt();
            vec2 = sc.nextInt();
            a[vec2].add(vec1);
            a[vec1].add(vec2);
        }
        
        
        for(int i=1;i<=vec;i++)
        {
            Collections.sort(a[i]);
        }
        
        bfs(vec,q,a);
    }
}