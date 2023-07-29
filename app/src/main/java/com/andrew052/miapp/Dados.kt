package com.andrew052.miapp

import kotlin.random.Random

fun tirarDados(): Pair<Int, Int> {
    val dado1 = Random.nextInt(1, 7)
    val dado2 = Random.nextInt(1, 7)
    return Pair(dado1, dado2)
}

fun calcularTotalDados(lanzamiento: Pair<Int, Int>): Int {
    return lanzamiento.first + lanzamiento.second
}

fun main() {
    println("¡Bienvenido al juego de Craps!")

    var saldo = 100
    println("Tu saldo inicial es de $saldo")

    do {
        print("¿Cuánto deseas apostar (0 para salir)? ")
        val apuesta = readLine()?.toIntOrNull() ?: 0

        if (apuesta <= saldo && apuesta > 0) {
            val lanzamiento = tirarDados()
            val totalDados = calcularTotalDados(lanzamiento)

            println("Resultado del lanzamiento: ${lanzamiento.first} y ${lanzamiento.second} (total: $totalDados)")

            when (totalDados) {
                2, 12 -> {
                    println("Craps! Perdiste.")
                    saldo -= apuesta
                }
                3, 11 -> {
                    println("Ganaste!")
                    saldo += apuesta
                }
                7 -> {
                    println("Craps! Perdiste.")
                    saldo -= apuesta
                }
                else -> {
                    println("Sigue intentando...")
                }
            }

            println("Tu saldo actual es de $saldo")
        } else if (apuesta > saldo) {
            println("No tienes suficiente saldo para apostar esa cantidad.")
        } else if (apuesta < 0) {
            println("La apuesta no puede ser negativa.")
        }
    } while (apuesta != 0 && saldo > 0)

    println("Gracias por jugar. Tu saldo final es de $saldo")
}
