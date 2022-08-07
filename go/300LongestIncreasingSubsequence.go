package goalgorithm

func lengthOfLIS(nums []int) int {
	n := len(nums)
	// dp[i] 表示以nums[i] 为末尾的最长递增子序列的长度
	dp := make([]int, n)
	for i, _ := range dp {
		dp[i] = 1
	}
	for i := 1; i < n; i++ {
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] && dp[j] >= dp[i] {
				dp[i] = dp[j] + 1
			}
		}
	}
	result := dp[0]
	for _, v := range dp {
		if result < v {
			result = v
		}
	}
	return result
}
