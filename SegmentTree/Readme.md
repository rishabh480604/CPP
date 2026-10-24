# Introduction
To find operation, over range in arrays we normaly need O(n*n) time.
But using segment tree , we can do it in logn*logn

# Basic
In segment tree, each node has start,end and value of range with left node, right node.
A node has value start to end range, left node have start to mid , right node have mid+1 to end range.Similarly like that
