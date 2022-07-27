package BestTimeToBuyAndSellStockIII

func maxProfit(price []int) int {
	n := len(price)
	dp := make([][3][2]int, n)
	dp[0][1][0], dp[0][1][1] = 0, -price[0]
	dp[0][2][0], dp[0][2][1] = 0, -price[0]
	for i := 1; i < n; i++ {
		for k := 1; k < 3; k++ {
			dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+price[i])
			dp[i][k][1] = max(dp[i-1][k][1], dp[i][k-1][0]-price[i])
		}
	}
	return dp[n-1][2][0]
}
func maxProfit_with_limit(price []int) int {
	n := len(price)
	dp_i10, dp_i11, dp_i20, dp_i21 := 0, -price[0]-1, 0, -price[0]-1
	for i := 0; i < n; i++ {
		dp_i20 = max(dp_i20, dp_i21+price[i])
		dp_i21 = max(dp_i21, dp_i10-price[i])
		dp_i10 = max(dp_i10, dp_i11+price[i])
		dp_i11 = max(dp_i11, -price[i])
	}
	return dp_i20
}
func max(x, y int) int {
	if x >= y {
		return x
	}
	return y
}
