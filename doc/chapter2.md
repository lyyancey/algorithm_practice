# 二分查找的一些技巧
&emsp;&emsp;二分查找的框架为:
```java
  int search(int[] nums, int target){
      int left = 0,right = ...;
      while(...){
          int mid = left + (right-left)/2;
          if(nums[mid]==target){
              return mid;
          }else if(nums[mid]>target){
              right = ...;
          }else if(nums[mid]<target){
              left = ...;
          }
      }
      return -1;
  }
```
&emsp;&emsp;上面带有$\color{red}{...}$的地方就是需要注意的地方，首先确定右边界时,是$\color{red}{right=nums.length}$还是$\color{red}{right=nums.length-1}$,然后第循环条件那里的$\color{red}{...}$是$\color{red}{left<right}$还是$\color{red}{left<=right}$，接下来是更新右边界时，$\color{red}{right=mid}$还是$\color{red}{right=mid-1}$,最后，更新左边界时$\color{red}{left=mid}$还是$\color{red}{left=mid+1}$。  
&emsp;&emsp;上面列出来的差不多就是二分查找里面所有的细节问题了。  
&emsp;&emsp;首先,当$\color{red}{right=nums.length()}$时,***right***是取不到 ***nums.length()*** 的，这时候的搜索区间就变成了 ***[ 0, nums.length() )*** ，既然搜索区间变成了 ***[ 0, nums.length() )*** ，那么我们自然就可以确定循环结束的条件，循环结束的条件就是搜索区间内再也没有可以搜索的元素，既然是左闭右开自然是当$\color{DarkOrange}{left=right}$ 时退出循环，也就是当搜索区间变为$\color{Fuchsia}{[left, left)}$ 时，搜索空间$\color{red}{right=nums.length()-1}$,