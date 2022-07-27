package bestTimeToBuyAndSellStockWithCooldown

func maxProfit(price []int) int {
	n := len(price)
	if n == 1 {
		return 0
	}
	dp := make([][2]int, n)

	dp[0][0], dp[0][1] = 0, -price[0]
	dp[1][0], dp[1][1] = max(dp[0][0], dp[0][1]+price[1]), max(dp[0][1], -price[1])
	for i := 2; i < n; i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-1][1]+price[i])
		dp[i][1] = max(dp[i-1][1], dp[i-2][0]-price[i])
	}
	return dp[n-1][0]
}

func maxProfit_with_cooldown(price []int) int {
	n := len(price)
	dp_i_0, dp_i_1, dp_i_pre := 0, -price[0]-1, 0
	for i := 0; i < n; i++ {
		tem := dp_i_0
		dp_i_0 = max(dp_i_0, dp_i_1+price[i])
		dp_i_1 = max(dp_i_1, dp_i_pre-price[i])
		dp_i_pre = tem
	}
	return dp_i_0
}
func max(x, y int) int {
	if x >= y {
		return x
	}
	return y
}
