/* Q8: Assume you have a method isSubstring which checks if one word is a substring
of another. Given two strings, si and s2, write code to check Ifs2 is a rotation of si
using only onecalltoisSubstring (e.g., "waterbottLe" is a rotation of "erbot-
tLewat"). */

package main

import (
	"fmt"
	. "strings"
)

func main() {
	s1, s2 := "erbottlewat", "waterbottle"
	fmt.Println("Is",s2,"in",s1,"?", rotationTest(s1, s2))
}

func rotationTest(s1, s2 string) bool {
	if len(s1) != len(s2) {return false}
	s3 := Join([]string{s1, s1}, "")
	return Contains(s3, s2)
}