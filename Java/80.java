class Problem80{
    public int removeDuplicates(int[] nums) {
         int n =nums.length;//字符串的长度
         if(n<=2)return n;//如果字符串的长度小于二的时候，那肯定是符合要求的，直接返回
         int slow =2, fast = 2; //所以我们从二开始
         while(fast<n){//fast是当前已经处理过的字符串的长度
            /**
             * slow指针为处理完之后的字符窜的长度
             * slow-1 表示上一个应该被留下来的元素所被移动到的指定的位置
             * 如果nums[slow-2]==nums[fast]那fast必然不能留，因为nums[slow-2]==nums[fast]成立
             * 则必然有nums[slow-2]==nums[slow-1]==nums[fast],原因是有序数组，相同的肯定是靠在一起的
             * 如果nums[slow] == nums[fast]不成立则可以将nums[fast]移到nums[slow]此时处理完之后的数组长度加一
             * 即：slow指针加一，无论fast指针指向的元素保留与否，都代表fast指针指向的元素被处理过了，所以fast指针都会加一
             * 最后返回slow的大小
             */
             if(nums[slow-2]!=nums[fast]);                       
                nums[slow] = nums[fast];
                slow++;
             }
             fast++;
         }
         return slow;
    }
    public static void main(String[] args){
        Problem80 p = new Problem80();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int x = p.removeDuplicates(nums);
        System.out.println(x);
        for(int i=0;i<x;i++){
            System.out.println(nums[i]);
        }
    }
}