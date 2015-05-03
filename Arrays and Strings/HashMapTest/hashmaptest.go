package main

import (
	"fmt"
	"github.com/jurkog/CTCI/Tools/jHashmap"
	"bufio"
	"os"
)

func main() {
 	hashMap := jHashmap.NewMap()
 	hashMap.AddEntry("Jurko", "Guba")
 	hashMap.AddEntry("Matt", "McCarthy")
 	hashMap.AddEntry("Tony", "Gnarswell")
 	hashMap.AddEntry("Roshaan", "Usmani")
 	hashMap.AddEntry("Nikola", "Zjalic")
  	hashMap.AddEntry("Will", "Mati")
 	hashMap.AddEntry("Nazare", "Muniz-Rodriguez")
 	hashMap.AddEntry("William", "Briguglio")		
 	scanner := bufio.NewScanner(os.Stdin)
 	for scanner.Scan() {
 		key := scanner.Text()
 		fmt.Println("First name:",key,"Last name:",hashMap.Get(key))
 	}
}