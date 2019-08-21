import java.util.*;

class Adjacency
{
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        int vertex,edge;
        
        vertex = sc.nextInt();
        edge = sc.nextInt();

        ArrayList<Integer> v[]= new ArrayList[vertex + 1];  // 2D ArrayList initalization

        for(int i=0;i<=vertex;i++)
        {
            v[i]= new ArrayList();
        }
        
        for(int i = 0 ; i < edge ; i++)
        {
            int vertex1, vertex2;
            vertex1 = sc.nextInt();
            vertex2 = sc.nextInt(); // Input of vertex b/w which edge exists

            if(!v[vertex1].contains(vertex2))  // Checking for duplicate edges
            {
                v[vertex1].add(vertex2);  	// Adding vertex to the list
            }
            
            if(!v[vertex2].contains(vertex1))  // Checking for duplicate edges
            {
                v[vertex2].add(vertex1);  	// Adding vertex to the list
            }
        }

        // Printing the List
        for(int i = 1; i <= edge ; i++)
        {
            System.out.print(i+"-->\t{");
            for(int t = 0; t < v[i].size() ; t++)
            {
                int val = (int) v[i].get(t);
                System.out.print(val+"\t");
            }
            System.out.print("}");
            System.out.println();
        }
    }
}