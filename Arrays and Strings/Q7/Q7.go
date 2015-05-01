/* Q7: Write an algorithm such that if an element in an MxN matrix is 0, its entire row
and column are set to 0. */
package main

import "fmt"

func main() {
	matrix := [][]int{{6,2,0,1},{4,5,3,7},{4,0,2,4},{6,7,9,8},{1,1,3,5}} // 5 X 4 Matrix

	fmt.Println("The old matrix:")
	printMatrix(matrix)
	eraseMatrix(matrix)
	fmt.Println("The new matrix:")
	printMatrix(matrix)
}

func eraseMatrix(a [][]int) {
	rSet, cSet := []int{}, []int{}

	M, N := len(a), len(a[0])
	for r := 0; r < M; r++ {
		for c:= 0; c < N; c++ {
			if a[r][c] == 0 {
				rSet = addToSet(rSet, r)
				cSet = addToSet(cSet, c)
			}
		}
	}

	for r := range rSet {
		for c := 0; c < N; c++ {
			a[rSet[r]][c] = 0
		}
	}

	for c := range cSet {
		for r:= 0; r < M; r++ {
			a[r][cSet[c]] = 0
		}
	}
}

func addToSet(s []int, v int) []int {
	for i := range s {
		if s[i] == v {
			return s
		}
	}	
	return append(s, v)
}

func printMatrix(a [][]int) {
	for r := range a {
		for c := range a[0] {
			fmt.Printf("%-3d", a[r][c])
		}
		fmt.Println()
	}
	fmt.Println()
}

