package com.andrew052.miapp

class Nequi {
    private val celular = "1234567890" // Número de celular predefinido (ejemplo)
    private val clave = "1234" // Clave de acceso predefinida (ejemplo)
    private var saldoDisponible = 4500.0

    fun iniciar() {
        var intentos = 3
        while (intentos > 0) {
            println("Ingrese número de celular:")
            val celularInput = readLine()
            println("Ingrese clave de 4 dígitos:")
            val claveInput = readLine()

            if (celular == celularInput && clave == claveInput) {
                println("¡Bienvenido a Nequi!")
                mostrarSaldo()

                while (true) {
                    mostrarMenu()
                    val opcion = readLine()?.toIntOrNull()

                    when (opcion) {
                        1 -> sacar()
                        2 -> enviar()
                        3 -> recargar()
                        4 -> return
                        else -> println("Opción inválida, por favor ingrese una opción válida.")
                    }
                }
            } else {
                intentos--
                println("¡Upps! Parece que tus datos de acceso no son correctos. Tienes $intentos intentos más.")
            }
        }

        println("Ha excedido el número máximo de intentos. La aplicación se cerrará.")
    }

    private fun mostrarMenu() {
        println("----- Menú de opciones -----")
        println("1. Sacar")
        println("2. Enviar")
        println("3. Recargar")
        println("4. Salir")
        println("----------------------------")
    }

    private fun mostrarSaldo() {
        println("Saldo disponible: $saldoDisponible")
    }

    private fun sacar() {
        if (saldoDisponible < 2000) {
            println("No te alcanza para realizar el retiro.")
        } else {
            println("1. Cajero")
            println("2. Punto físico")
            val opcion = readLine()?.toIntOrNull()

            if (opcion == 1 || opcion == 2) {
                println("Ingrese el valor a retirar:")
                val valorRetiro = readLine()?.toDoubleOrNull()

                if (valorRetiro != null && valorRetiro <= saldoDisponible) {
                    println("Retiro exitoso. Código de retiro: ${generarCodigoRetiro()}")
                    saldoDisponible -= valorRetiro
                } else {
                    println("Valor inválido o saldo insuficiente para realizar el retiro.")
                }
            } else {
                println("Opción inválida.")
            }
        }
        mostrarSaldo()
    }

    private fun enviar() {
        println("Ingrese el número de teléfono al que desea enviar dinero:")
        val numeroTelefono = readLine()
        println("Ingrese el valor a enviar:")
        val valorEnviar = readLine()?.toDoubleOrNull()

        if (valorEnviar != null && valorEnviar <= saldoDisponible) {
            println("Transferencia exitosa. Se envió $valorEnviar a $numeroTelefono")
            saldoDisponible -= valorEnviar
        } else {
            println("Valor inválido o saldo insuficiente para enviar dinero.")
        }
        mostrarSaldo()
    }

    private fun recargar() {
        println("Ingrese el valor a recargar:")
        val valorRecarga = readLine()?.toDoubleOrNull()

        if (valorRecarga != null) {
            println("¿Confirma que desea realizar la recarga? (Sí/No)")
            val confirmacion = readLine()

            if (confirmacion?.equals("Sí", true) == true) {
                saldoDisponible += valorRecarga
                println("Recarga exitosa. Nuevo saldo disponible: $saldoDisponible")
            } else {
                println("Recarga cancelada.")
            }
        } else {
            println("Valor inválido para la recarga.")
        }
        mostrarSaldo()
    }

    private fun generarCodigoRetiro(): Int {
        // Generar código de 6 dígitos para el retiro (ejemplo)
        return (100000..999999).random()
    }
}

fun main() {
    val nequi = Nequi()
    nequi.iniciar()
}
