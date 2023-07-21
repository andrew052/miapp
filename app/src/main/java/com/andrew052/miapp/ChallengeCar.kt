package com.andrew052.miapp

class ChallengeCar {
}
fun main(){
    val regisCar: MutableList<String> = mutableListOf()
    println("En este programa usted podra elegir una opcion 1=Registrar un auto, 2=Mostrar un auto, 3=Buscar un auto, 4=Modificar un auto, 5=Eliminar un auto, 6=Borrar la lista")
    var op : Int = readLine() !!.toInt()

    when (op){
        1 -> {
            println("Registre un auto")

            regisCar.add(readln())

            print("$regisCar")
        }
        2 -> {
            println("Aqui ve un listado de todos nuestros autos (Si no hay ninguno significa que aun no se ha registrado ninguno)")
            println("$regisCar")
        }
        3-> {
                println("Busque un auto por su numero")
            regisCar.add("")
            val search:Boolean=regisCar.contains(readLine()!!)
            if (search==true){
                println(regisCar.indexOf(""))
            }else{
                println("")
            }
        }
        4->{

        }



    }
    println("Quiere volver a elegir una opcion 1=si y 2=no")
    var choice = readLine()
    while (choice=="1"){



    }









}