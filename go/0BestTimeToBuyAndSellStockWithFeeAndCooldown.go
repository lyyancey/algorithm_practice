//package BestTimeToBuyAndSellStockWithFeeAndCooldown
package BestTimeToBuyAndSellStock

func maxProfitAllInOne(prices []int, maxK, cooldown, fee int) int {
	n := len(prices)
	if n <= 0 {
		return 0
	}
	if maxK > n/2 {
		return maxProfitwithKInf(prices, cooldown, fee)
	}
	dp := make([][][2]int, n)
	for i := range dp {
		dp[i] = make([][2]int, maxK)
	}
	for i := 0; i < n; i++ {
		dp[i][0][0] = 0
		dp[i][0][1] = -prices[i] - 1
	}
	for i := 0; i < n; i++ {
		for k := 1; i <= maxK; k++ {
			if i == 0 {
				dp[i][k][0] = 0
				dp[i][k][1] = -prices[1] - fee
				continue
			}
			if i-cooldown-1 < 0 {
				dp[i][k][0] = max(dp[i-1][k][0], dp[i][k-1][1]+prices[i])
				dp[i][k][1] = max(dp[i-1][k][1], -prices[i]-fee)
			}
			dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
			dp[i][k][1] = max(dp[i-1][k][1], dp[i-cooldown-1][k-1][0]-prices[i]-fee)
		}
	}
	return dp[n-1][maxK][0]
}

func maxProfitwithKInf(prices []int, cooldown int, fee int) int {
	n := len(prices)
	if n <= 0 {
		return 0
	}
	dp := make([][2]int, n)
	dp[0][0] = 0
	dp[0][1] = -prices[0] - 1
	for i := 1; i < n; i++ {
		if i-cooldown-1 < 0 {
			dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
			dp[i][1] = max(dp[i-1][1], -prices[i]-fee)
			continue
		}
		dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
		dp[i][1] = max(dp[i-1][1], dp[i-cooldown-1][0]-prices[i]-fee)
	}
	return dp[n-1][0]
}
func max(x, y int) int {
	if x >= y {
		return x
	}
	return y
}
