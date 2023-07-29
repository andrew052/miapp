package com.andrew052.miapp

class ChallengeCar {
    private val autos: MutableList<List<String>> = mutableListOf()

    fun registrarAuto(marca: String, modelo: String, año: String) {
        val auto = listOf(marca, modelo, año)
        if (!autos.contains(auto)) {
            autos.add(auto)
            println("Auto registrado correctamente.")
        } else {
            println("El auto ya está registrado en la lista.")
        }
    }

    fun mostrarListadoAutos() {
        if (autos.isNotEmpty()) {
            println("Listado de autos:")
            for ((index, auto) in autos.withIndex()) {
                println("${index + 1}. ${auto[0]} ${auto[1]} - ${auto[2]}")
            }
        } else {
            println("La lista de autos está vacía.")
        }
    }

    fun buscarAuto(marca: String, modelo: String, año: String): List<String>? {
        return autos.find { it[0] == marca && it[1] == modelo && it[2] == año }
    }

    fun modificarAuto(oldAuto: List<String>, nuevaMarca: String, nuevoModelo: String, nuevoAño: String) {
        val index = autos.indexOfFirst { it == oldAuto }
        if (index != -1) {
            autos[index] = listOf(nuevaMarca, nuevoModelo, nuevoAño)
            println("Auto modificado correctamente.")
        } else {
            println("No se encontró el auto en la lista.")
        }
    }

    fun eliminarAuto(auto: List<String>) {
        if (autos.remove(auto)) {
            println("Auto eliminado correctamente.")
        } else {
            println("No se encontró el auto en la lista.")
        }
    }

    fun borrarLista() {
        autos.clear()
        println("Lista de autos borrada correctamente.")
    }
}

fun main() {
    val ChallengeCar = ChallengeCar()

    var opcion: Int

    do {
        println("\n¿Qué deseas hacer?")
        println("1. Registrar un auto")
        println("2. Mostrar listado de autos")
        println("3. Buscar un auto")
        println("4. Modificar un auto")
        println("5. Eliminar un auto")
        println("6. Borrar lista de autos")
        println("7. Salir")
        print("Ingresa el número de opción: ")
        opcion = readLine()?.toIntOrNull() ?: 7

        when (opcion) {
            1 -> {
                print("Ingresa la marca del auto: ")
                val marca = readLine() ?: ""
                print("Ingresa el modelo del auto: ")
                val modelo = readLine() ?: ""
                print("Ingresa el año del auto: ")
                val año = readLine() ?: ""

                ChallengeCar.registrarAuto(marca, modelo, año)
            }
            2 -> ChallengeCar.mostrarListadoAutos()
            3 -> {
                print("Ingresa la marca del auto a buscar: ")
                val marca = readLine() ?: ""
                print("Ingresa el modelo del auto a buscar: ")
                val modelo = readLine() ?: ""
                print("Ingresa el año del auto a buscar: ")
                val año = readLine() ?: ""

                val autoBuscado = ChallengeCar.buscarAuto(marca, modelo, año)
                if (autoBuscado != null) {
                    println("Auto encontrado: ${autoBuscado[0]} ${autoBuscado[1]} - ${autoBuscado[2]}")
                } else {
                    println("No se encontró el auto en la lista.")
                }
            }
            4 -> {
                print("Ingresa la marca del auto a modificar: ")
                val marca = readLine() ?: ""
                print("Ingresa el modelo del auto a modificar: ")
                val modelo = readLine() ?: ""
                print("Ingresa el año del auto a modificar: ")
                val año = readLine() ?: ""

                val autoBuscado = ChallengeCar.buscarAuto(marca, modelo, año)
                if (autoBuscado != null) {
                    print("Ingresa la nueva marca del auto: ")
                    val nuevaMarca = readLine() ?: ""
                    print("Ingresa el nuevo modelo del auto: ")
                    val nuevoModelo = readLine() ?: ""
                    print("Ingresa el nuevo año del auto: ")
                    val nuevoAño = readLine() ?: ""

                    ChallengeCar.modificarAuto(autoBuscado, nuevaMarca, nuevoModelo, nuevoAño)
                } else {
                    println("No se encontró el auto en la lista.")
                }
            }
            5 -> {
                print("Ingresa la marca del auto a eliminar: ")
                val marca = readLine() ?: ""
                print("Ingresa el modelo del auto a eliminar: ")
                val modelo = readLine() ?: ""
                print("Ingresa el año del auto a eliminar: ")
                val año = readLine() ?: ""

                val autoBuscado = ChallengeCar.buscarAuto(marca, modelo, año)
                if (autoBuscado != null) {
                    ChallengeCar.eliminarAuto(autoBuscado)
                } else {
                    println("No se encontró el auto en la lista.")
                }
            }
            6 -> ChallengeCar.borrarLista()
            7 -> println("Saliendo del programa...")
            else -> println("Opción inválida. Inténtalo nuevamente.")
        }
    } while (opcion != 7)
}
