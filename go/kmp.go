package goalgorithm

func kmp_violation(P, T string) int {
	n, i := len(T), 0
	m, j := len(P), 0
	for i < n && j < m {
		if T[i] == P[j] {
			i++
			j++
		} else {
			i -= j - 1
			j = 0
		}
	}
	return i - j
}

func kmp_violation2(P, T string) int {
	n, m := len(T), len(P)
	i := 0
	for ; i < n; i++ {
		for j := 0; j < m; j++ {
			if T[i] != P[j] {
				break
			}
			if m <= j {
				break
			}
		}
	}
	return i
}

func kmp_version1(P, T string) int {
	next := buildNext(P)

	n, i := len(T), 0 // 文本串指针
	m, j := len(P), 0 // 模式串指针

	for j < m && i < n { // 自左向右，逐个比对字符
		if 0 > j || T[i] == P[j] { // 若匹配
			i++
			j++ // 则携手并进
		} else { // 否则 P右移， T不回退
			j = next[j]
		}
	}
	return i - j
}

func buildNext(P string) []int {
	m, j := len(P), 0
	var N []int = make([]int, m) // next表
	t := -1
	N[0] = -1
	for j < m-1 {
		if 0 > t || P[j] == P[t] {
			j++
			t++
			N[j] = t
		} else {
			t = N[t]
		}
	}
	return N
}

func buildNext_new(P string) []int {
	m, j := len(P), 0
	N := make([]int, m)
	N[0] = -1
	for t := -1; j < m-1; {
		if t < 0 || P[t] == P[j] {
			j++
			t++
			if P[j] != P[t] {
				N[j] = t
			} else {
				N[j] = N[t]
			}
		} else {
			t = N[t]
		}
	}
	return N
}
