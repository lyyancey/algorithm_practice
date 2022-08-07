package goalgorithm

import "fmt"

func minDistance(word1 string, word2 string) int {
	var m map[string]int = make(map[string]int)
	return dp(word1, word2, 0, 0, &m)
}

func dp(word1, word2 string, i, j int, mp *map[string]int) int {
	n, m := len(word1), len(word2)
	if i == n {
		return m - j
	}
	if j == m {
		return n - i
	}

	key := fmt.Sprintf("%d_%d", i, j)
	_, ok := (*mp)[key]
	if ok {
		return (*mp)[key]
	}
	res := -1
	if word1[i] == word2[j] {
		res = dp(word1, word2, i+1, j+1, mp)
	} else {
		res = min(
			dp(word1, word2, i, j+1, mp)+1,
			dp(word1, word2, i+1, j, mp)+1,
			dp(word1, word2, i+1, j+1, mp)+1,
		)
	}
	(*mp)[key] = res
	return res

}
