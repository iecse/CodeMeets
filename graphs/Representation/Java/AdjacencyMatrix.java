import java.util.*;

class AdjacencyMatrix
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int vertex,edge;
        char type;
        vertex = sc.nextInt();
        edge = sc.nextInt();
        type = sc.next().charAt(0);
        
        int arr[][]=new int[vertex+1][vertex+1];

        // Set all values to zero
        for(int i = 0; i < vertex; i++)
        {
            for(int j = 0; j < vertex; j++)
            {
                arr[i][j] = 0;
            }
        }

        //For Directed
        if(type == 'D')
        {
            for(int i = 1 ; i <= edge; i++)
            {
                int vertex1, vertex2;
                vertex1 = sc.nextInt();
                vertex2 = sc.nextInt();         //Input the vertex between which edge exists
                arr[vertex1][vertex2] = 1;     //Make the value for coresponding edge to 1
            }
        }

        //For undirected
        else if(type == 'U')
        {
            for(int i = 0; i < edge ; i++)
            {
                int a,b;
                a = sc.nextInt();
                b = sc.nextInt();
                arr[a][b] = 1;
                arr[b][a] = 1;
            }
        }
        
        System.out.print("\t");
        for(int i = 1; i <= vertex  ; i++)
        {
            System.out.print(i+"\t");
        }
        System.out.println();
        for(int i = 1; i <= vertex  ; i++)
        {
            System.out.print(i+"\t");
            for(int j = 1; j <= vertex ; j++)
            {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}