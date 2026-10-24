package SegmentTree;

import java.sql.SQLOutput;
import java.util.Arrays;

class SegNode{
    int start;
    int end;
    long val;
    SegNode left;
    SegNode right;
    SegNode(int s,int e,long val){
        this.start=s;
        this.end=e;
        this.val=val;
        this.left=null;
        this.right=null;
    }
}

public class Main{
    public static SegNode buildSegmentTree(int start, int end, int[] arr){

        if( start == end){
            if(start==0 || start==arr.length-1){
             if(start==0){
                 return new SegNode(start,end,arr[start]);
             }
             return new SegNode(start,end,arr[start]-arr[start-1]);
            }
            return new SegNode(start,end,arr[start]-arr[start-1]);

        }

        int mid=(end-start)/2+start;
        SegNode left=buildSegmentTree(start,mid,arr);
        SegNode right=buildSegmentTree(mid+1,end,arr);
        SegNode root=new SegNode(start,end,left.val+right.val);
        root.left=left;
        root.right=right;

        return root;
    }
    public static void printTree(SegNode root){
        System.out.print(root.val+" , ");
        if(root.left!=null){
            printTree(root.left);
        }
        if(root.right!=null){
            printTree(root.right);
        }
        return ;

    }
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 5, 6, 8, 2, 9, 12, 56, 21, 4};
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        System.out.println(Arrays.toString(prefix));
        System.out.println("start: "+0+" "+"end : "+(arr.length-1));
        SegNode root=buildSegmentTree(0, arr.length - 1, prefix);
        if(root!=null){
            printTree(root);
        }



    }
}