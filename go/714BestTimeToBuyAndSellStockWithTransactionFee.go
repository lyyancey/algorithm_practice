package goalgorithm

func maxProfit(price []int, fee int) int {
	n := len(price)
	dp := make([][2]int, n)
	dp[0][0], dp[0][1] = 0, -price[0]-fee
	for i := 1; i < n; i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-1][1]+price[i])
		dp[i][1] = max(dp[i-1][1], dp[i-1][0]-price[i]-fee)
	}
	return dp[n-1][0]
}

func maxProfit_with_fee(price []int, fee int) int {
	n := len(price)
	dp_i_0, dp_i_1 := 0, -price[0]-fee
	for i := 1; i < n; i++ {
		dp_i_0 = max(dp_i_0, dp_i_1+price[i])
		dp_i_1 = max(dp_i_1, dp_i_0-price[i]-fee)
	}
	return dp_i_0
}
