package com.andrew052.miapp

import kotlin.random.Random

fun obtenerDescuento(bolita: String, valorCompra: Double): Pair<Double, Double> {
    val descuento: Double
    when (bolita) {
        "roja" -> {
            descuento = 0.1 // 10% de descuento
        }
        "azul" -> {
            descuento = 0.3 // 30% de descuento
        }
        "amarilla" -> {
            descuento = 0.5 // 50% de descuento
        }
        "blanca" -> {
            descuento = 1.0 // 100% de descuento (compra gratis)
        }
        else -> {
            descuento = 0.0 // Sin descuento
        }
    }

    val valorDescuento = valorCompra * descuento
    val valorFinal = valorCompra - valorDescuento
    return Pair(valorDescuento, valorFinal)
}

fun main() {
    println("¡Bienvenido al Supermercado Noé!")
    println("Hoy es nuestro aniversario y puedes obtener un descuento en tu compra.")

    print("Ingresa el valor de tu compra: ")
    val valorCompra = readLine()?.toDoubleOrNull() ?: 0.0

    if (valorCompra > 50000) {
        val bolitaAleatoria = listOf("roja", "azul", "amarilla", "blanca").random()
        println("Felicidades, sacaste una bolita $bolitaAleatoria")

        val (valorDescuento, valorFinal) = obtenerDescuento(bolitaAleatoria, valorCompra)

        println("Valor de descuento obtenido: $valorDescuento")
        println("Valor final a pagar: $valorFinal")
    } else {
        println("Lo sentimos, para obtener el descuento tu compra debe ser mayor a 50.000.")
    }
}
