/* Q2: Implement a function void reverse(char* str) in C or C++ which reverses a null-
terminated string. */
// NOTE: Question specifies C or C++, I decided to do it in Go because C smells

package main

import (
	"fmt"
)

func main() {
	test := "Welcome to question 2 of the CTCI solutions!"
	fmt.Println("String unreversed:",test)
	fmt.Println("String reversed:",reverseString(test))
}

func reverseString(s string) string {
	b:=[]rune(s)
	for i:= 0; i < len(b)/2; i++ {
		j:= len(b) - i - 1
		b[i], b[j] = b[j], b[i]
	}
	return string(b)
}