import java.util.*;
import java.io.*;

public class DFS
{
    public static void dfs(int vec,Stack<Integer> s,ArrayList<Integer> a)
    {
        int curr;
        for(int j=1;j<=vec;j++)
        {
            if(!visited[j])//visits a node if unvisited
            { 
                s.push(j);
                visited[j]=true; //Node J is marked visited
                curr=j;//current node becomes j

                while(!s.empty())//Runs till stack isnt empty
                {
                    int i=0;
                    while(i<a[curr].size())
                    {
                        int Val= (int) a[curr].get(i);

                        if(!visited[Val])
                        {
                            visited[Val]=true;
                            s.push(Val);
                            curr=Val;
                            i=0;
                        }
                        else
                        {
                            i++;
                        }
                    }

                    s.pop();//Pops the element on top of the stack

                    if(!s.empty())
                    {
                        curr=s.peek();//changes curr to Vertex on top of the stack now
                    }
                }
            }

        }
    }

    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int vec;
        int vec1,vec2; 
        long edg;
        vec = sc.nextInt();
        edg = sc.nextLong();

        Stack<Integer> s=new Stack<Integer>();
        ArrayList<Integer> a[] = new ArrayList[vec+1];
        boolean visited[]=new boolean[vec+1];
        Arrays.fill(visited,false);

        for(int i=0;i<=vec;i++)
        {
            a[i]= new ArrayList();
        }

        for(long i=0;i<edg;i++)
        {
            vec1 = sc.nextInt();
            vec2 = sc.nextInt();
            a[vec1].add(vec2);
            a[vec2].add(vec1);
        }

        for(int i=1;i<=vec;i++)
        {
            Collections.sort(a[i]);//Sorts each arraylist for each Vertex
        }

        for(int i=1;i<=vec;i++)
        {
            if(!visited[i])
            {
                dfs(vec,s,a);//Runs DFS for each vertex which is unvisited
            }
        }
    }
}