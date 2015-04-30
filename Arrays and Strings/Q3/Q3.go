/* Q3: Given two strings, write a method to decide if one is a permutation of the other. */
// I took the approach of sorting the two strings and then comparing them.

package main

import (
	"fmt"
)

func main() {
	a := "noitapertum"
	b := "permutation"
	fmt.Println("Are:",a,"and:",b,"permutations of each other?", permutationCheck(a, b))
}

func permutationCheck(c, d string) bool {
	// Cant be permutations if they dont have the same length
	if len(c) != len(d) {
		return false
	}

	a, b:= []rune(c), []rune(d)
	// Sorting string a
	for i := 0; i < len(a) - 1; i++ {
		for j:= len(a) - 1; j > i; j-- {
			if a[i] > a[j] {
				a[i], a[j] = a[j], a[i]
			}
		}
	}

	// Sorting string b
	for i := 0; i < len(b) - 1; i++ {
		for j:= len(b) - 1; j > i; j-- {
			if b[i] > b[j] {
				b[i], b[j] = b[j], b[i]
			}
		}
	}	

	// Revert back to strings
	c = string(a)
	d = string(b)

	// Return the boolean value of their equality
	return c == d
}

