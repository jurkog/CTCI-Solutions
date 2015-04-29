/* Q1: Implement an algorithm to determine if a string has all unique characters. What
if you cannot use additional data structures? */

// If I didn't use any additional data structures, I would be forced to some sort of comparison based algorithm which would give us O(n log n) solution at best if I were to sort the list.

package main

import (
	"fmt"
	"bufio"
	"os"	
)

func main() {
	reader:=bufio.NewReader(os.Stdin)
	fmt.Println("Enter a string to test its uniqueness")
	test,_ := reader.ReadString('\n')
	if unique(test) {
		fmt.Println("The string is unique!")
	} else {
		fmt.Println("The string contains duplicates of characters.")
	}
}

// Decided to make it with the use of an additonal data structure (the boolean array)

func unique(s string) bool {
	b := []byte(s)
	d := make([]bool, 95)
	for i := range b {		
		b[i] -= 33
		if b[i] >= 0 && b[i] <= 94 {
			if d[b[i]] {
				return false
			} else {
				d[b[i]] = true;
			}
		}					
	}
	return true
}
