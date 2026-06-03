# Comparación de rendimiento con hilos

Daniel Alexander Ahumada León

## Descripción

Se realizó una prueba para medir el tiempo de ejecución de una suma de números enteros utilizando diferentes cantidades de hilos. El objetivo es observar cómo afecta la concurrencia al rendimiento del programa.

## Configuración

- Lenguaje: Java
- Número máximo: 500.000.000

## Resultados

| Hilos | Tiempo (ms) |
|--------|------------|
| 1 | 138.36 |
| 2 | 100.91 |
| 4 | 59.76 |
| 8 | 57.81 |
| 16 | 62.24 |
| 32 | 70.11 |
| 64 | 104.73 |
| 100 | 100.87 |

## Análisis

Se observa que el tiempo de ejecución disminuye al aumentar la cantidad de hilos hasta cierto punto. Después de ese límite, el costo de coordinación y cambio de contexto puede reducir o eliminar las ganancias de rendimiento.

## Conclusión

La cantidad óptima de hilos depende del número de núcleos disponibles y de la carga de trabajo. Utilizar más hilos no siempre implica una ejecución más rápida.