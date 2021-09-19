import java.util.Arrays;
import java.util.LinkedList;

public class Sort{
    //冒泡排序  最坏 O(n^2)
    public void bubbleSort0(int[] nums){
        int lo = 0, hi = nums.length;
        while(lo < hi){
            int i = lo, last = lo;
            while(++i < hi){
                if(nums[i]<nums[i-1]){
                    last = i;
                    int tem = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = tem;
                }
            }
            hi = last;
        }
    }
    //归并排序 nlogn
    public void mergeSort(int[] nums, int lo, int hi){
        if(hi-lo < 2)return;
        int mi = (lo+hi)>>1;
        mergeSort(nums, lo, mi);
        mergeSort(nums, mi, hi);
        merge(nums, lo, mi, hi);
    }
    //选择排序
    public int[] selectSort(int[] nums){
        int[] arr = Arrays.copyOf(nums, nums.length);
        for(int i = 0; i<arr.length-1;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            if(i != min){
                int tem = nums[min];
                nums[min] = nums[i];
                nums[i] = tem;
            }
        }
        return arr;
    }
    public void merge(int[] nums,int lo, int mi, int hi){
        int rb = mi - lo;
        int rc = hi - mi;
        int[] B = new int[rb];
        for(int i=0;i<rb;i++)B[i] = nums[lo+i];
        for(int i=0,j=0,k=0;(i<rb||j<rc);){
            if((i<rb)&&(rc<=j||B[i]<=nums[mi+j])){
                nums[lo+k++] = B[i++];
            }
            if((j<rc)&&(rb<=i||nums[mi+j]<=B[i])){
                nums[lo+k++] = nums[mi+j++];
            }
        }
    }
    //插入排序
    public int[] insertSort(int[] nums){
        int[] arr = Arrays.copyOf(nums, nums.length);
        for(int i=1;i<nums.length;i++){
            int tem = arr[i];
            int j = i;
            while(j>0&&tem<arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            if(j != i){
                arr[j] = tem;
            }
        }
        return arr;
    }
    // 递归 快速排序
    public void recurQuickSort(int[] nums, int L, int R){
        if(L >= R)return;
        int left = L;
        int right = R;
        // 随意取一个值作为pivot，此处取最左
        int pivot = nums[left];
        while(left < right){
            // 先从右往左找一个比pivot小的数
            while(left < right && pivot <= nums[right])right--;
            // 找到之后把它放到左边
            nums[left] = nums[right];
            // 再从左往右找一个比pivot大的数
            while(left < right && pivot >= nums[left])left++;
            // 找到之后把它放到右边
            nums[right] = nums[left];
        }
        // 循环结束时 left == right
        // 直接把 pivot 放在这个位置
        nums[left] = pivot;
        //递归操作
        recurQuickSort(nums, L, left-1);
        recurQuickSort(nums, left+1, R);
    }
    //迭代 快速排序
    public int[] loopQuickSort(int[] nums){
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(nums.length - 1);
        stack.push(0);
        while(!stack.isEmpty()){
            int left = stack.pop();
            int right = stack.pop();
            if(left < right){
                int pivotIdx = partition(nums, left, right);
                stack.push(pivotIdx - 1);
                stack.push(left);
                stack.push(right);
                stack.push(pivotIdx+1);
            }
        }
        return nums;
    }
    private int partition(int[] nums, int left, int right){
        if(left >= right)return left;
        int pivot = nums[left];
        while(left < right){
            while(left < right && pivot <= nums[right])right--;
            nums[left] = nums[right];
            while(left < right && pivot >= nums[left])left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}