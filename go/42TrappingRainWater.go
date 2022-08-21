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
func trapv1(height []int) int {
	n := len(height)
	l_max, r_max := make([]int, n), make([]int, n)
	l_max[0] = height[0]
	r_max[n-1] = height[n-1]
	for i := 1; i < n; i++ {
		l_max[i] = max(height[i], l_max[i-1])
	}
	for i := n - 2; i >= 0; i-- {
		r_max[i] = max(height[i], r_max[i+1])
	}
	res := 0
	for i := 1; i < n-1; i++ {
		res += min(l_max[i], r_max[i]) - height[i]
	}
	return res
}

func trapv2(height []int) int {
	n := len(height)
	l_max := height[0]
	r_max := height[n-1]
	left, right := 0, n-1
	res := 0
	for left <= right {
		l_max = max(height[left], l_max)
		r_max = max(height[right], r_max)

		if l_max < r_max {
			res += l_max - height[left]
			left++
		} else {
			res += r_max - height[right]
			right--
		}
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
