package arraysnhashing

import (
	"fmt"
)

func IsValidSudoku(board [][]byte) bool {

	for i := 0; i < len(board); i++ {
		var num byte
		freq2 := make([]bool, 10)
		freq := make([]bool, 10)
		for j := 0; j < len(board); j++ {
			item := board[i][j]
			if item != '.' {
				num = (item - '0')
				// fmt.Printf("[%d][%d] item: %d\n", i, j, num)
				if freq[num] {
					return false
				}
				freq[num] = true
			}

			// 2
			item = board[j][i]
			if item != '.' {
				num = (item - '0')
				// fmt.Printf("[%d][%d] item: %d\n", j, i, num)
				if freq2[num] {
					return false
				}
				freq2[num] = true
			}

		}
	}

	freq1 := make([]bool, 10)
	freq2 := make([]bool, 10)
	freq3 := make([]bool, 10)
	for i := 0; i < 9; i++ {

		for j := 0; j < 3; j++ {
			fmt.Printf("f1: [%d][%d]\n", i, j)
			item := board[i][j]
			if item != '.' {
				num := (item - '0')
				if freq1[num] {
					return false
				}
				freq1[num] = true
			}
		}

		for j := 3; j < 6; j++ {
			// fmt.Printf("f2: [%d][%d]\n", i, j)
			item := board[i][j]
			if item != '.' {
				num := (item - '0')
				if freq2[num] {
					return false
				}
				freq2[num] = true
			}
		}

		for j := 6; j < 9; j++ {
			// fmt.Printf("f3: [%d][%d]\n", i, j)
			item := board[i][j]
			if item != '.' {
				num := (item - '0')
				if freq3[num] {
					return false
				}
				freq3[num] = true
			}
		}
	}

	return true
}
