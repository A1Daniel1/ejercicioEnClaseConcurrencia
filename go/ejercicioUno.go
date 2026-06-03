package main

import (
	"fmt"
	"sync"
	"time"
)

func worker(min, max int, resultado *int64, wg *sync.WaitGroup) {
	defer wg.Done()

	var suma int64

	for i := min; i < max; i++ {
		suma += int64(i)
	}

	*resultado = suma
}

func main() {

	maximo := 500_000_000
	cantidadHilos := 8

	tamanoIntervalo := maximo / cantidadHilos

	var wg sync.WaitGroup

	resultados := make([]int64, cantidadHilos)

	inicio := time.Now()

	for i := 0; i < cantidadHilos; i++ {

		inicioIntervalo := i * tamanoIntervalo

		finIntervalo := inicioIntervalo + tamanoIntervalo

		if i == cantidadHilos-1 {
			finIntervalo = maximo
		}

		wg.Add(1)

		go worker(
			inicioIntervalo,
			finIntervalo,
			&resultados[i],
			&wg,
		)
	}

	wg.Wait()

	var sumaTotal int64

	for _, resultado := range resultados {
		sumaTotal += resultado
	}

	fmt.Println("Tiempo total:", time.Since(inicio))
}