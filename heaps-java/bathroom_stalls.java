import java.io.*;
import java.util.*;
class Gap
{
    private long gap_size;
    private long frequency;
    Gap(long g,long f)
    {
        gap_size = g;
        frequency = f;
    }
    public long getGapSize()
    {
        return gap_size;
    }
    public long getFrequency()
    {
        return frequency;
    }
    public void setGapSize(long setGap)
    {
        gap_size = setGap;
    }
    public void setFrequency(long setFreq)
    {
        frequency = setFreq;
    }
}
public class bathroom_stalls {
    public static long[] gap_evaluation(long gap_size)
    {
        gap_size = gap_size - 1; //place the student
        long[] ret = new long[2];
        if(gap_size%2==0)
        {
            ret[0] = (gap_size/2);
            ret[1] = -1;
            return ret;
        }
        else
        {
            ret[0] = ((gap_size/2)+1);
            ret[1] = (gap_size/2);
            return ret;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++)
        {
            long n = in.nextLong();
            long m = in.nextLong();
            PriorityQueue<Gap> gps = new PriorityQueue<Gap>(new Comparator<Gap>() {
                 public int compare(Gap gap1, Gap gap2) {
                     if (gap1.getGapSize() > gap2.getGapSize()) return -1;
                     if (gap1.getGapSize() < gap2.getGapSize())  return 1;
                     return 0;
                 }
            });
            gps.add(new Gap(n,1));
            boolean done = false;
            long bynow = 0;
            while(done==false)
            {
                Gap temp = gps.peek();
                if(m<=((temp.getFrequency())+bynow))
                {
                    long[] result_set = gap_evaluation(temp.getGapSize());
                    if(result_set[1]==-1)
                        System.out.println("Case #"+(i+1)+": "+result_set[0]+" "+result_set[0]);
                    else
                        System.out.println("Case #"+(i+1)+": "+result_set[0]+" "+result_set[1]);
                    done = true;
                }
                else
                {
                    bynow = bynow + temp.getFrequency();
                    Gap top = gps.poll();
                    long[] new_gaps = gap_evaluation(top.getGapSize());
                    if(new_gaps[1]==-1)
                    {
                        Gap ele1 = new Gap(new_gaps[0],top.getFrequency()*2);
                        boolean checker = false;
                        Iterator itr = gps.iterator();
                        while (itr.hasNext())
                        {
                            Gap gcheck = (Gap)(itr.next());
                            long check = gcheck.getGapSize();
                            if(ele1.getGapSize()==check)
                            {
                                gcheck.setFrequency(ele1.getFrequency()+gcheck.getFrequency());
                                checker = true;
                                break;
                            }
                        }
                        if(!checker)
                            gps.add(ele1);
                    }
                    else
                    {
                        Gap ele1 = new Gap(new_gaps[0],top.getFrequency());
                        Gap ele2 = new Gap(new_gaps[1],top.getFrequency());
                        boolean checker1 = false;
                        boolean checker2 = false;
                        Iterator itr = gps.iterator();
                        while (itr.hasNext())
                        {
                            Gap gcheck = (Gap)(itr.next());
                            long check = gcheck.getGapSize();
                            if(ele1.getGapSize()==check && checker1!=true)
                            {
                                gcheck.setFrequency(ele1.getFrequency()+gcheck.getFrequency());
                                checker1 = true;
                            }
                            if(ele2.getGapSize()==check  && checker2!=true)
                            {
                                gcheck.setFrequency(ele2.getFrequency()+gcheck.getFrequency());
                                checker2 = true;
                            }
                            if(checker1 && checker2)
                                break;
                        }
                        if(!checker1)
                            gps.add(ele1);
                        if(!checker2)
                            gps.add(ele2);
                    }    
                }
            }
        }
    }
}