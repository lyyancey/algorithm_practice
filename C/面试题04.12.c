#include<stdio.h>
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode {
      int val;
      struct TreeNode *left;
      struct TreeNode *right;
 };
 
int count(struct TreeNode* root, int sum){
    if(root == NULL)return 0;
    int rootNum = root->val==sum ? 1 : 0;
    int leftNum = count(root->left,sum-root->val);
    int rightNum = count(root->right, sum-root->val);
    return rootNum + leftNum + rightNum;
    
};

int pathSum(struct TreeNode* root, int sum){
    if(root==NULL)return 0;
    int rootNum = count(root, sum);    //以 root 根节点，能凑出几条这样的路径来
    int leftNum = pathSum(root->left, sum);  //以左子树为根节点可以凑出几条这样的路径来
    int rightNum = pathSum(root->right, sum);//以右子树为根节点可以凑出几条这样的路径来
    return rootNum + leftNum + rightNum;
}
