import java.util.*;

class KLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i=0;i<k;i++)
            pq.add(sc.nextInt());
        for(int i=k;i<n;i++) {
            int a = sc.nextInt();
            if(a > pq.peek()) {
                pq.poll();
                pq.add(a);
            }
        }
        System.out.println(pq.peek());
    }
}