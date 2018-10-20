import java.util.*;
import java.io.*;
public class Main{
	public static String str;
	public static int grundy[] = new int[100000];
	public static int solve(int mask){
		if(grundy[mask]!=(-1))
			return grundy[mask];
		if(mask==0)
			return 0;
		int hash[] = new int[26];
		for(int i=0;i<str.length();i++)
			if((mask & (1<<i))!=0)
				hash[str.charAt(i)-'a']++;
		int flag = 0;
		for(int i=0;i<26;i++)
			if(hash[i]>1)
				flag = 1;
		if(flag==0)
			return 0;
		ArrayList<Integer> number = new ArrayList<Integer>();
		for(int i=0;i<str.length();i++)
			if((mask & (1<<i))!=0){
				mask = mask^(1<<i);
				int temp = solve(mask);	
				number.add(temp);
				mask = mask^(1<<i);	
			}
		Collections.sort(number);
		int small = 0;
		for(int i=0;i<number.size();i++){
			int temp = number.remove(0);
			if(temp>small)
				break;
			else
				small++;
		}
		grundy[mask] = small;
		return small;
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			str = br.readLine().trim();
			Arrays.fill(grundy,-1);
			int ret = solve((1<<str.length())-1);
			if(ret==0)
				System.out.println("Watan");
			else
				System.out.println("Karan");
		}
	}
}