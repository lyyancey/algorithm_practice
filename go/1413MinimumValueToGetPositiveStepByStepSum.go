package goalgorithm

func minStartValue(nums []int) int {
	//n := len(nums)
	//dp := make([]int, n)
	sum, min := 0, 1
	for _, v := range nums {
		sum += v
		if sum < min {
			min = sum
		}
	}
	if min > 1 {
		return 1
	}
	return 1 - min
}
