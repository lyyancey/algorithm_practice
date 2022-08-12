package goalgorithm

import (
	"sort"
	"strings"
)

func makeLargestSpecial(s string) string {
	n := len(s)
	if n < 2 {
		return s
	}
	subs := sort.StringSlice{}
	cnt, j := 0, 0
	for i, ch := range s {
		if ch == '1' {
			cnt++
		} else if cnt--; cnt == 0 {
			subs = append(subs, "1"+makeLargestSpecial(s[j+1:i])+"0")
			j = i + 1
		}
	}
	sort.Sort(sort.Reverse(subs))
	return strings.Join(subs, "")
}
