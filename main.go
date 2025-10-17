package main

import (
	arr "apicela_leetcode/1.arrays_n_hashing" // alias opcional)
	"fmt"
)

func main() {
	fmt.Println(arr.IsAnagram("sasa", "aass"))
	fmt.Println(arr.ProductExceptSelf([]int{1, 2, 3, 4}))
	fmt.Println(arr.ProductExceptSelf([]int{-1, 1, 0, -3, 3}))
}
