/* Q6: Given an image represented by an NxN matrix, where each pixel in the image is
4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
place? */

// The first way sounds easy, if I'm going to be able to solve it in place then I'll
// be able to solve it using an external array
// Ill be swap 4 elements per iteration clockwise.

// Elements to be swapped
// [1][2][3][-] Rows: 0 to len(b) / 2 - 1
// [-][4][-][-]		Col per row: Row# to len(b) - Row# - 1
// [-][-][-][-]
// [-][-][-][-]


package main

import "fmt"

func main() {
	i := [][]int{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}} // 4 by 4 array going from 1 to 16
	N := len(i)

	fmt.Println("Matrix before rotation: ")
	printArray(i)

	for row := 0; row < N / 2; row++ {
		for col := row; col < N - row - 1; col++ {
			a := &i[row][col]
			b := &i[col][N - row - 1]
			c := &i[N - col - 1][row]
			d := &i[N - row - 1][N - col - 1]
			fourSwap(a, b, c, d)
		}
	}

	fmt.Println("Matrix before rotation: ")
	printArray(i)
	
}

// [a][-][-][b]		[c][-][-][a]
// [-][-][-][-] --> [-][-][-][-]
// [-][-][-][-]	--> [-][-][-][-]
// [c][-][-][d]		[d][-][-][b]

func fourSwap(a, b, c, d *int) {
	*a, *b, *c, *d = *c, *a, *d, *b
}

func printArray(i [][]int) {
	for r := range i {
		for c:= range i[0] {
			fmt.Printf("%-3d", i[r][c])
		}
		fmt.Print("\n")
	} 
	fmt.Println()
}