package com.andrew052.miapp

import kotlin.random.Random


class Nequi {
    private val celular = "3053715482" // Número de celular predefinido (ejemplo)
    private val clave = "2005" // Clave de acceso predefinida (ejemplo)
    private var saldoDisponible = 500000.0

    fun iniciar() {
        var intentos = 3
        while (intentos > 0) {
            println("¡Hola! Bienvenido a Nequi.")
            println("Ingrese su número de celular:")
            val celularInput = readLine()
            println("Ingrese su contraseña de 4 dígitos:")
            val contrasena = readLine()

            if (celular == celularInput && clave == contrasena) {
                println("¡Bienvenido de nuevo! Acceso concedido.")
                mostrarSaldo()

                while (true) {
                    mostrarMenu()
                    val opcion = readLine()?.toIntOrNull()

                    when (opcion) {
                        1 -> sacar()
                        2 -> enviar()
                        3 -> recargar()
                        4 -> donar()
                        5 -> pagarServicioPublico()
                        6 -> {
                            println("Gracias por usar Nequi. Hasta luego.")
                            return
                        }
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

    fun mostrarMenu() {
        println("----- Menú de opciones -----")
        println("1. Sacar")
        println("2. Enviar")
        println("3. Recargar")
        println("4. Donar")
        println("5. Pagar servicio público")
        println("6. Salir")
        println("----------------------------")
    }

    fun mostrarSaldo() {
        println("Saldo disponible: $saldoDisponible")
    }

    fun sacar() {
        if (saldoDisponible < 2000) {
            println("No te alcanza para realizar el retiro.")
        } else {
            println("Elige una opción:")
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

    fun enviar() {
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

    fun recargar() {
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

    fun donar() {
        println("Ingrese el valor a donar:")
        val valorDonacion = readLine()?.toDoubleOrNull()

        if (valorDonacion != null && valorDonacion <= saldoDisponible) {
            println("¿Desea confirmar la donación de $valorDonacion? (Sí/No)")
            val confirmacion = readLine()

            if (confirmacion?.equals("Sí", true) == true) {
                saldoDisponible -= valorDonacion
                println("¡Gracias por tu generosidad! Donación exitosa. Nuevo saldo disponible: $saldoDisponible")
            } else {
                println("Donación cancelada.")
            }
        } else {
            println("Valor inválido o saldo insuficiente para realizar la donación.")
        }
        mostrarSaldo()

    }

    fun pagarServicioPublico() {
        println("Ingrese el valor a pagar por el servicio público:")
        val valorPagar = readLine()?.toDoubleOrNull()

        if (valorPagar != null && valorPagar <= saldoDisponible) {
            println("¿Desea confirmar el pago de $valorPagar por el servicio público? (Sí/No)")
            val confirmacion = readLine()

            if (confirmacion?.equals("Sí", true) == true) {
                saldoDisponible -= valorPagar
                println("Pago exitoso. Nuevo saldo disponible: $saldoDisponible")
            } else {
                println("Pago cancelado.")
            }
        } else {
            println("Valor inválido o saldo insuficiente para realizar el pago del servicio público.")
        }
        mostrarSaldo()
    }

    fun generarCodigoRetiro(): Int {
        return Random.nextInt(100000, 999999)
    }
}

fun main() {
    val nequi = Nequi()
    nequi.iniciar()
}
