import java.util.*;
 
public class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            long a = sc.nextLong();
            long b = sc.nextLong();
            long bi = (b>=a)?b:a;
            long i=0;
            long sumi = a+b;
            long x = 0;
            while(true){
                long sum = sumi + i*(i+1)/2;
                if(Math.floor( (double)sum/2) == Math.ceil( (double)sum/2)){
                    x = (long)sum/2;
                    if(x>=bi){
                        System.out.println(i);
                        break;
                    }
                }
                i++;
            }
        }
    }
}