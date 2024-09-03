package Treee;
import java.util.*;

/*
 *  Three separate working 
 *  leftview 
 *  bottomview
 *  rightview
 *  combining left
 * 
 */

class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
     }
 }
public class BoundryTraversal {
    public ArrayList<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> leftview=new ArrayList<>();
        ArrayList<Integer> rightview=new ArrayList<>();
        int[] arr=new int[2002];
        int adjust=1001;
        Arrays.fill(arr,-1);
        
        Queue<Integer> qCol=new LinkedList<>();
        Queue<TreeNode> q=new LinkedList<>();
        int row=0;
        q.add(root);
        qCol.add(0);
        while(!q.isEmpty()){
            int sz=q.size();
            
            for(int i=0;i<sz;i++){
                
                TreeNode temp=q.remove();
                int colIndex=qCol.remove();
                if(i==0 || i==sz-1){
                    if(i==0){
                        leftview.add(temp.val);
                    }
                    if(i==sz-1){
                        rightview.add(temp.val);
                    }
                }
                arr[adjust+colIndex]=temp.val;
                if(temp.left!=null){
                    q.add(temp.left);
                    qCol.add(colIndex-1);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                    qCol.add(colIndex+1);
                }
            }
            row++;
        }
        ArrayList<Integer> bottomview=new ArrayList<>();
        int index=adjust;
        while(arr[index]!=-1){
            index--;
        }
        index++;
        while(arr[index]!=-1){
            // System.out.println(index+" : "+arr[index]);
            bottomview.add(arr[index]);
            index++;
        }
        //leftview in leftview araylist
        //rightview in rightview arraylist
        //bottom i bottomview arraylist
        System.out.println("leftview : "+leftview);
        System.out.println("bottomview : "+bottomview);
        System.out.println("rightview : "+rightview);
        
        /*
        ArrayList<Integer> res=new ArrayList<>(leftview);
        //merging left and bottom
        while(bottomview.size()>0 && res.contains(bottomview.get(0))){
            bottomview.remove(0);
        }
        res.addAll(bottomview);
        rightview.remove(rightview.size()-1);
        //merging res with right
        int reslen=res.size();
        int len=rightview.size();
        while (len>=0 && rightview.contains(res.get(reslen-1))) {
            bottomview.remove(reslen-1);
            len--;
        }
        len=rightview.size();
        for(int i=len-1;i>=0;i--){
            res.add(rightview.get(i));
        }
        */

        return new ArrayList<>();
        // return res;
        
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        root.right.right=new TreeNode(4);
        root.right.left.right=new TreeNode(5);
        ArrayList<Integer> res=new BoundryTraversal().boundaryOfBinaryTree(root);
        System.out.println(res);
    }
}
