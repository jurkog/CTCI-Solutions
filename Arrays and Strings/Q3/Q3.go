/* Q3: Given two strings, write a method to decide if one is a permutation of the other. */
// I took the approach of sorting the two strings and then comparing them.

package main

import (
	"fmt"
)

func main() {
	a := "noitapertum"
	b := "permutation"
	fmt.Println("Are:", a, "and:", b, "permutations of each other?", permutationCheck(a, b))
}

func permutationCheck(c, d string) bool {
	// Cant be permutations if they dont have the same length
	if len(c) != len(d) {
		return false
	}

	occurs := make(map[rune]int)
	for _, c := range c {
		_, ok := occurs[c]
		if !ok {
			occurs[c] = 0
		}
		occurs[c]++
	}

	for _, c := range d {
		v, ok := occurs[c]
		if !ok || v == 0 {
			return false
		}
		occurs[c]--
	}

	for _, v := range occurs {
		if v != 0 {
			return false
		}
	}
	return true
}
