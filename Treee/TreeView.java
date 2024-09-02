package Treee;
import java.util.*;
class Node{
    Node left;
    Node right;
    int data;
    Node(int val){
        data=val;
        left=null;
        right=null;
    }
}
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static int[][] left;
    static int[][] right;
    static void tophelper(Node root,int x,int level){
        //0-> data
        //1-> level
        if(x>=0){
            //right array;
            if(right[1][x]>level){
                right[0][x]=root.data;
                right[1][x]=level;
                // System.out.print(root.data+" ");
            }
        }else{
            //left side
            if(left[1][-x]>level){
                left[0][-x]=root.data;
                left[1][-x]=level;
                // System.out.print(root.data+" ");
            }
            
        }
        //leftchild check
        if(root.left!=null){
            tophelper(root.left,x-1,level+1);
        }
        if(root.right!=null){
            tophelper(root.right,x+1,level+1);
        }
    }
    static ArrayList<Integer> topView(Node root) {
        if(root==null){
            return new ArrayList<>();
        }
        ArrayList<Integer> res=new ArrayList<>();
        left=new int[2][100000];
        right=new int[2][100000];
        Arrays.fill(left[1],1000000);
        Arrays.fill(right[1],1000000);
        tophelper(root,0,0);
        // System.out.println(right[0][3]);
        for(int i=left[0].length-1;i>0;i--){//dont include zero index
            if(left[0][i]>0){
                res.add(left[0][i]);
            }
        }
        for(int i=0;i<right[0].length;i++){
            if(right[0][i]>0){
                res.add(right[0][i]);
            }
        }
        return res;
    }

    //for bottom view
    public void bottomhelper(Node root,int x,int y){
        // 0->data
        // 1-level
        if(x>=0){
            //right
            
            if(right[1][x]<=y){//if level same or less update
                right[0][x]=root.data;
                right[1][x]=y;
            }
        }else{
            //left
            if(left[1][-x]<=y){
                left[0][-x]=root.data;
                left[1][-x]=y;
            }
        }
        if(root.left!=null){
            bottomhelper(root.left,x-1,y+1);
        }
        if(root.right!=null){
            bottomhelper(root.right,x+1,y+1);
        }
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        if(root==null){
            return new ArrayList<>();
        }
        bottomhelper(root,0,0);
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=left[0].length-1;i>0;i--){
            if(left[0][i]>0){//val >0 add in list
                res.add(left[0][i]);
            }
        }
        for(int i=0;i<right[0].length;i++){
            if(right[0][i]>0){
                res.add(right[0][i]);
            }
        }
        return res;
        
    }
}
public class TreeView {
    
}
