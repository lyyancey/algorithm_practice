package goalgorithm

func max(i1, i2 int) int {
	if i1 >= i2 {
		return i1
	}
	return i2
}

func min(x, y, z int) int {
	if x > y {
		x, y = y, x
	}
	if y > z {
		y, z = z, y
	}
	if x > y {
		x, y = y, x
	}
	return x
}
