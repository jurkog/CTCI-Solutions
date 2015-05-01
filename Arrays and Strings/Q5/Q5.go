/* Q5: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become
a2blc5a3. If the "compressed" string would not become smaller than the orig-
inal string, your method should return the original string. */

// The example provided has a sorted string but I will assume that I will be working with any string
// 

package main

import (
	"fmt"
	"strconv"
	"github.com/jurkog/CTCI/Tools/jString"
)

func main() {
	text := "Yooouuuuusaaaa"
	fmt.Println("The old text:", text)
	b := []byte(text)
	sb := jString.NewBuffer()
	prevCount := 1
	for i:= range b {
		if i == 0 {
			sb.AppendByte(b[i])
		} else {
			if b[i - 1] != b[i] {
				sb.Append(strconv.Itoa(prevCount))
				sb.AppendByte(b[i])
				prevCount = 1;
			} else {
				prevCount++
			}
		}
	}
	sb.Append(strconv.Itoa(prevCount))

	if sb.Length() < len(text) {
		text = sb.ToString()
	}
	fmt.Println("The new text:", text)
}