#include<stdio.h>
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
//符合当前节点路径的数量
int count(struct TreeNode *root, int sum){
    //为空返回0
    if(root==NULL)return 0;
    //当前节点
    int curNum = root->val == sum ? 1 : 0;
    int leftNum = count(root->left, sum - root->val);
    int rightNum = count(root->right, sum - root->val);
    return curNum + leftNum + rightNum;
}

int pathSum(struct TreeNode *root, int sum){
    if(root==NULL)return 0;
    int curNum = count(root, sum);
    int leftNum = pathSum(root->left, sum);
    int rightNum = pathSum(root->right, sum);
    return curNum + leftNum + rightNum;
}