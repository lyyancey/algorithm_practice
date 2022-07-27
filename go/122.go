package maxProfit

func maxProfit122(price []int) int {
	n := len(price)
	dp := make([][2]int, n)
	dp[0][1] = -price[0]
	for i := 1; i < n; i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-1][1]+price[i])
		dp[i][1] = max(dp[i-1][0]-price[i], dp[i-1][1])
	}
	return dp[n-1][0]
}

func max(i int, i2 int) int {
	if i > i2 {
		return i
	}
	return i2
}
func maxProfit_k_inf(price []int) int {
	n := len(price)
	var dp_i_0, dp_i_1 int = 0, -price[0]
	for i := 1; i < n; i++ {
		dp_i_0 = max(dp_i_0, dp_i_1+price[i])
		dp_i_1 = max(dp_i_1, dp_i_0-price[i])
	}
	return dp_i_0
}
