package goalgorithm

func maxProfit_k(max_k int, prices []int) int {
	n := len(prices)
	if n == 0 {
		return 0
	}
	if max_k > n/2 {
		return maxProfitInfK(prices)
	}
	// base case
	// dp[0][1...][0] = dp[...][0][0] = 0
	// dp[0][1...][1] = dp[...][0][1] = -infinity
	dp := make([][][2]int, n)
	for i := range dp {
		dp[i] = make([][2]int, max_k+1)
	}

	//当k=0时的basecase
	for i := 0; i < n; i++ {
		dp[i][0][1] = prices[i] - 1
		dp[i][0][0] = 0
	}
	for i := 0; i < n; i++ {
		for k := 1; k <= max_k; k++ {
			if i == 0 {
				// 处理 i== -1时的basecase
				dp[i][k][0] = 0
				dp[i][k][1] = -prices[i]
				continue
			}
			dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
			dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])
		}
	}
	return dp[n-1][max_k][0]

}

func maxProfitInfK(prices []int) int {
	n := len(prices)
	dp := make([][2]int, n)
	dp[0][0], dp[0][1] = 0, -prices[0]
	for i := 1; i < n; i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
		dp[i][1] = max(dp[i-1][1], dp[i-1][0]-prices[i])
	}
	return dp[n-1][0]
}
