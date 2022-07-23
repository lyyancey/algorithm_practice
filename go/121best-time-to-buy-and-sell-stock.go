package maxProfit

func maxProfit(price []int) int {
	n := len(price)
	dp := make([][2]int, n)
	dp[0][0] = 0
	dp[0][1] = -price[0]
	for i := 1; i < n; i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-1][1]+price[i])
		dp[i][1] = max(dp[i-1][1], -price[i])
	}
	return dp[n-1][0]
}
