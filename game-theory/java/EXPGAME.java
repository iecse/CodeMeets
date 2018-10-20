import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int exp[] = new int[6];
		for(int i=0;i<6;i++){
			exp[i] = 1;
			for(int r=0;r<(i+1);r++)
				exp[i] *= (i+1);
		}
		int wins[] = new int[100001];
		wins[0] = 0;
		for(int i=1;i<100001;i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j=0;j<6;j++)
				if(exp[j]<=i)
					list.add(wins[i-exp[j]]);
			for(int j=0;j<7;j++)
				if(!list.contains(j)){
					wins[i] = j;
					break;
				}
		}
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++){
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine().trim();
			str = " "+str+" ";
			int sp = 0;
			int arr[] = new int[n];
			int ret = 0;
			for(int j=0;j<n;j++){
				int temp = str.indexOf(" ",sp+1);
				arr[j] = Integer.parseInt(str.substring(sp+1,temp));
				sp = temp;
				ret = ret^wins[arr[j]]; 
			}
			if(ret!=0)
				System.out.println("Little Chef");
			else
				System.out.println("Head Chef");
		}
	}
}