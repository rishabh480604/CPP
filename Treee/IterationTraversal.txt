package Treee;
//node structure
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class TreeNode{
    TreeNode left;
    int val;
    TreeNode right;
    TreeNode(int v){
        val=v;
        left=null;
        right=null;
    }

}
public class IterationTraversal {


    static List<Integer> inorderModified(TreeNode root){
        /*
         * The inorder break the actual connection of node
         * Time compplexity - O(n)
         * Space Complexity - O(1)
         */
        List<Integer> output=new ArrayList<>();
        TreeNode curr=root;
        // inorder - left root right
        //execute it till last node
        while(curr!=null){
            
            if(curr.left==null){
                //if left is null
                //so print or add value then move to right
                output.add(curr.val);
                curr=curr.right;
            }else{
                //if left is not null 
                //make leftchild rightmost node connection to current node for traversal
                TreeNode leftchild = curr.left;

                //traverse right node till reach rightmost
                while(leftchild.right!=null){
                    leftchild=leftchild.right;
                }
                //connect rightmost with cleftchild_parent or curr
                leftchild.right=curr;
                
                //move to leftchild
                TreeNode temp=curr;
                curr=curr.left;

                //make leftchild null
                temp.left=null;
            }
        }
        return output;
    }
    //striver or gfg way
    //to 
    static List<Integer> preorder(TreeNode root){
        List<Integer> output=new ArrayList<>();
        TreeNode curr=root;
        //while it reach ends
        while(curr!=null){
            if(curr.left==null){
                //if left part is null
                // add data then move to right
                output.add(curr.val);
                curr=curr.right;
            }else{
                /*
                 * we will check whether left rightmost is connected to curr or not
                 *  if connected 
                 *      left part is already visited 
                 *      make left rightmost to null
                 *      move curr right part
                 * else
                 *      its first time
                 *      add val to data
                 *      connect left rightmost to curr
                 *         move curr to left part
                 */
                TreeNode leftchild=curr.left;
                while(leftchild.right!=null && leftchild.right!=curr){
                    leftchild=leftchild.right;
                }

                if(leftchild.right==curr){
                    //already visited node
                    leftchild.right=null;
                    curr=curr.right;

                }else{
                    //first time 
                    //add data in list
                    //connect with curr
                    // move to left side
                    output.add(curr.val);
                    leftchild.right=curr;
                    curr=curr.left;
                    
                }
            }
        }
        return output;
    }
    static List<Integer> inorder(TreeNode root){
        List<Integer> output=new ArrayList<>();
        TreeNode curr=root;
        //while it reach ends
        while(curr!=null){
            if(curr.left==null){
                //if left part is null
                // add data then move to right
                output.add(curr.val);
                curr=curr.right;
            }else{
                /*
                 * we will check whether left rightmost is connected to curr or not
                 *  if connected 
                 *      left part is already visited 
                 *      make left rightmost to null
                 *      move curr right part
                 * else
                 *      its first time
                 *      add val to data
                 *      connect left rightmost to curr
                 *         move curr to left part
                 */
                TreeNode leftchild=curr.left;
                while(leftchild.right!=null && leftchild.right!=curr){
                    leftchild=leftchild.right;
                }

                if(leftchild.right==curr){
                    //already visited node
                    output.add(curr.val);
                    leftchild.right=null;
                    curr=curr.right;

                }else{
                    //first time 
                    //add data in list
                    //connect with curr
                    // move to left side
                    
                    leftchild.right=curr;
                    curr=curr.left;
                    
                }
            }
        }
        return output;
    }
    /*
     *  in preorder print if left null and when first visit
     * in inorder print if left null and second visit
     * 
     */
    static List<Integer> postorder(TreeNode root){
        /*
         *  similar to preorder exchannge left and right and reverse the result
         */
        TreeNode curr=root;
        List<Integer> output=new ArrayList<Integer>();
        while(curr!=null){
            //check for right node first
            if(curr.right==null){
                output.add(curr.val);
                curr=curr.left;
            }else{
                //on left node 
                TreeNode rightchild=curr.right;
                //check whether rightchild leftmost is connected with curr or not
                while(rightchild.left!=null && rightchild.left!=curr){
                    rightchild=rightchild.left;
                }
                if(rightchild.left==curr){
                    //if connected means second visit
                    //remove rightchild leftmost connection
                    //move to leftchild
                    rightchild.left=null;
                    curr=curr.left;
                }else{
                    //first time
                    //add to list
                    //connect leftmost child with curr
                    output.add(curr.val);
                    rightchild.left=curr;
                    curr=curr.right;
                }
            }
        }
        Collections.reverse(output);
        return output;

    }
    public static void main(String[] args) {

        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(3);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(6);
        root.right=new TreeNode(4);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(8);
        System.out.println(postorder(root));
    }
    
    
}
