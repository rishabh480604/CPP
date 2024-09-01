import java.util.Arrays;
import java.util.Scanner;
//binary search topic
public class AggresiveCow {
    static int accom(int[] stall,int diff){
        int count=0;
        int pos=0;
        for(int x:stall){
            if(pos<=x){
                count++;
                pos=x+diff;
            }
        }
        return count;
    }
    static int fun(int[] stall,int cows){
        //we do operation over differences
        int start=0;
        int end=stall[stall.length-1]-stall[0];
        int ans=-1;
        while(start<=end){
            int mid=(end-start)/2+start;
            int cowstay=accom(stall,mid);
            // System.out.println("mid val:"+mid+" cows:"+cowstay);
            if(cowstay>=cows){
                ans=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testcases=sc.nextInt();
        for(int i=0;i<testcases;i++){
            int[] stall=new int[sc.nextInt()];
            int cows=sc.nextInt();
            for(int j=0;j<stall.length;j++){
                stall[j]=sc.nextInt();
            }
            Arrays.sort(stall);
            System.out.println(fun(stall,cows));


        }

    }
    
}
