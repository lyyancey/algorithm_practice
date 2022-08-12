package goalgorithm

func groupThePeople(groupSizes []int) [][]int {
	groups := map[int][]int{}
	for i, size := range groupSizes {
		groups[size] = append(groups[size], i)
	}
	ans := [][]int{}
	for size, people := range groups {
		for i := 0; i < len(people); i += size {
			ans = append(ans, people[i:i+size])
		}
	}
	return ans
}
