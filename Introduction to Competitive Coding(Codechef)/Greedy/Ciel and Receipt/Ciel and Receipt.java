import java.util.*;
 class Codechef
 {
   public static void main(String args[])
   { 
     Scanner sc = new Scanner(System.in);
     int ans;
     int n = sc.nextInt();
     for(int i = 0; i < n; ++i){
       int sum = 0;
       ans = 0;
       int p = sc.nextInt();
       for(int j = 11; j >= 0; --j){     
         int temp=(int)Math.pow(2,j);
         ans+=p/temp;
         p=p%temp;
       }
       System.out.println(ans);
     }
 }
 }