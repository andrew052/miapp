package com.andrew052.miapp

class Funciones {
}

/*
fun printHello(){
    println("hello world")
}*/
fun AreCir (){
    println("Escriba el radio del circulo")
    var r = readln()!! .toInt()

    var a: Double = 3.14 * (r*r)
    println("El resultado fue $a")
}
 fun PerCir() {
    println("Escriba el perimetro del circulo")
    var d = readln()!!.toInt()

    var p: Double = 3.14 * d
    println("El resultado fue $d")
}
    fun PerTri(lado1:Int?, lado2:Int?, lado3:Int?):Unit{
    var result = lado1!! + lado2!! + lado3!!
    println("el resultado fue $result")
}
    fun AreTri(base:Int?, altu:Int?):Unit{
        var resul = (base!!*altu!!)/2
        println("el resultado fue $resul")
    }
    fun PerRec(ancho:Int?, largo:Int?):Int{
       return (ancho!!*2)+(largo!!*2)
    }
    fun ArRec(ancho:Int?, largo:Int?):Int{
    return ancho!!*largo!!
    }
/*
fun tip(l1: Int?,l2: Int?,l3: Int?) {

    if (l1 == l2 && l1 == l3 && l3 == l2){

        println("el triangulo es equilatero")
    }
    else if(l1 == l2 && l1 == l3 && l3 != l2 || l2==l3 && l1==l2 && l3 && l1 ||l3=l2 && l1==l3 && l1!=l2 ) {
        println("el triangulo es isosceles")
    }else if (l1 != l2 && l1!=l3 && l3!=l1) {
        println("el triangulo es escaleno")
    }else {

    }
}
*/


fun main() {
    /*var deci = String()*/
    /*
    val temperature=20
    val isHot=if(temperature>40) true else false

    println(isHot)*/

    /*
    println("digite su edad")
    var edad: Int = readLine() !!.toInt()
    if (edad>=18)
        println("usted peude entrar")
    else{
        println("usted no entra")
        printHello()
    }*/
    /*do{
        println("En este programa usted podra elegir una opcion 1=Calcular Perimetro, 2=Calcular Area")
        var op : Int = readLine() !!.toInt()

        when (op){
            1 -> {
                PerCir()

            }
            2 -> {
                AreCir()

            }
        }
        println("quiere volver calcucar")
        deci = readLine().toString()
    } while (deci == "si")*/
    var deci: String = "si"
    do {
        println("En este programa usted podra elegir una opcion 1=Calcular Perimetro, 2=Calcular Area, 3=Tipo de triangulo, 4=Rectangulo ")
        var op: Int = readLine()!!.toInt()

        when (op) {
            1 -> {
                println("digite el lado 1 del triangulo")
                var lado1 = readLine()!!.toInt()
                println("digite el lado 2 del triangulo")
                var lado2 = readLine()!!.toInt()
                println("digite el lado 3 del triangulo")
                var lado3 = readLine()!!.toInt()
                PerTri(lado1, lado2, lado3)




            }




            2 -> {
                println("digite la base del triangulo")
                var base = readLine()!!.toInt()
                println("digite la altura del triangulo")
                var altu = readLine()!!.toInt()
                AreTri(base, altu)

            }
            3 -> {/*
                println("Escriba el lado 1");
                var l1 = readLine()

                System.out.println("Escriba el lado 2");
                var l2 = readLine()

                System.out.println("Escriba el lado 3");
                var l3 = readLine()
                equi()*/

            }
            4 -> {
                println("digite el alto del rectangulo")
                var alto = readLine()!!.toInt()
                println("digite el ancho del rectangulo")
                var ancho = readLine()!!.toInt()
                ArRec(alto,ancho)
                PerRec(alto, ancho)


            }

        }
        println("quiere volver calcucar")
        deci = readLine().toString()

     } while (deci == "si")


}

