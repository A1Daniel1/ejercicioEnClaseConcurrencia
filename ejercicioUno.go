package main

import (
	"fmt"
	"time"
)

func main() {
	maximo := 50000000000
	fmt.Println("numero a contar", maximo)

	inicio := time.Now()

	contador(maximo)

	duracion := time.Since(inicio)

	fmt.Println("tiempo que tardo en contar", duracion)
}

func contador(m int) {
	count := 0

	for count < m {
		count++
	}
}
