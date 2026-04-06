func twoSum(nums []int, target int) []int {
	mapa := make(map[int]int)
	for i, v := range nums {
		remaining := target - v
		if idx, exists := mapa[remaining]; exists {
			return []int{idx, i}
		}
		mapa[v] = i
	}
	return []int{}
}
