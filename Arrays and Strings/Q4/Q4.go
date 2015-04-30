package main

import (
	"fmt"
	"github.com/jurkog/CTCI/Tools/jString"
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
}