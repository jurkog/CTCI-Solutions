package main

import (
	"fmt"
	"github.com/jurkog/CTCI/Tools/jHashmap"
	"bufio"
	"os"
)

func main() {
 	hashMap := jHashmap.NewMap()
 	hashMap.Put("Jurko", "Guba")
 	hashMap.Put("Matt", "McCarthy")
 	hashMap.Put("Tony", "Gnarswell")
 	hashMap.Put("Roshaan", "Usmani")
 	hashMap.Put("Nikola", "Zjalic")
  	hashMap.Put("Will", "Mati")
 	hashMap.Put("Nazare", "Muniz-Rodriguez")
 	hashMap.Put("William", "Briguglio")		
 	scanner := bufio.NewScanner(os.Stdin)
 	fmt.Println("Let's begin by deleting some entries. Type 'STOP' to stop deleting entries")
 	for scanner.Scan() {
 		key := scanner.Text()
 		if key == "STOP" {
 			break
 		}
 		value := hashMap.Get(key)
 		if value != "NULL" {
 			fmt.Println("Deleting entry: First name:",key,"Last name:",value)
 		} else {
 			fmt.Println("No entry found with that key, please try again!")
 		}
 		hashMap.Delete(key)
 	}

 	fmt.Println("Now let's search up some entries. Type 'STOP' to end the program")
 	for scanner.Scan() {
 		key := scanner.Text()
 		if key == "STOP" {
 			break
 		}
 		value := hashMap.Get(key)
 		if value != "NULL" {
 			fmt.Println("Found entry: First name:",key,"Last name:",value)
 		} else {
 			fmt.Println("No entry found with that key, please try again!")
 		}
 	}
}