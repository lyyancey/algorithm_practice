package goalgorithm

func trap(height []int) int {
	n := len(height)
	res := 0
	for i := 1; i < n-1; i++ {
		l_max := height[i]
		for j := i - 1; j >= 0; j-- {
			l_max = max(l_max, height[j])
		}
		r_max := height[i]
		for k := i + 1; k < n; k++ {
			r_max = max(r_max, height[k])
		}
		res += min(r_max, l_max) - height[i]
	}
	return res
}
func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
func min(x, y int) int {
	if x <= y {
		return x
	}
	return y
}
