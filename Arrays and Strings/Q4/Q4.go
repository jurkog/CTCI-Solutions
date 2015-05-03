/* Q4: Write a method to replace all spaces in a string with'%20'. You may assume that
the string has sufficient space at the end of the string to hold the additional
characters, and that you are given the "true" length of the string. (Note: if imple-
menting in Java, please use a character array so that you can perform this opera-
tion in place.) */

/* Since the author of the book prescribed I practice implementing my own StringBuffer
I decided to use that implementation in solving this problem. The only disadvantage I can
see in my algorithm is that I make a new slice of bytes instead of manipulating the current
array. 
*/

/* EDIT: I noticed that if I used the strings library, I could implement it in one line... So I did ;) */

package main

import (
	"fmt"
	"github.com/jurkog/CTCI/Tools/jString"
	. "strings"
)

func main() {
	text := "This is a sentence"
	fmt.Println("The old text:",text)
	sb := jString.NewBuffer()
	b := []byte(text)
	for i := range b {
		if b[i] == ' ' {
			if i + 1 != len(text) && b[i + 1] != ' ' {
				sb.Append("%20")
			}
		} else {
			sb.AppendByte(b[i])
		}
	}
	text = sb.ToString()
	fmt.Println("The new text:",text)
	fmt.Println("The new text using library functions:", libraryFunction(text))
}

func libraryFunction(s string) string{
	return Join(Split(s, " "), "%20")
}