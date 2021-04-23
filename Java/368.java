import java.util.Arrays;
import java.util.List;
import java.utils.*;
class Problem368{
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = nums[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            if(dp[i]>maxSize){
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }
        List<Integer> l = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            if(maxSize==dp[i]&&maxVal%nums[i]==0){
                l.add(nums[i]);
                maxSize--;
                maxVal = nums[i];
            }
        }
        return l;
    }
}
