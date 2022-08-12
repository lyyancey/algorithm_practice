package goalgorithm

func longestPalindrome(s string) string {
	length := len(s)
	if length < 2 {
		return s
	}
	dp := make([][]bool, length)
	for i := 0; i < length; i++ {
		dp[i] = make([]bool, length)
		dp[i][i] = true
	}
	maxLen := 1
	res := string(s[0])
	for L := 2; L <= length; L++ {
		for i := 0; i < length; i++ {
			j := i + L - 1
			if j >= length {
				break
			}
			if s[i] != s[j] {
				dp[i][j] = false
			} else {
				if L <= 3 {
					dp[i][j] = true
				} else {
					dp[i][j] = dp[i+1][j-1]
				}
			}
			if dp[i][j] && L > maxLen {
				maxLen = L
				res = s[i : j+1]
			}
		}
	}
	return res
}
