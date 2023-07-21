package com.andrew052.miapp

class For {

}

fun main(){

    /*for (i in 1 .. 10 ){
        var number: Int = i % 2
        if(number==0){
            println("El numero es par $i")
        }
        else {
            println("El numero es impar $i")
        }
    }*/

    /*
        var numPar:Int = 0
        var numImpar:Int= 0
        for (i in 1 .. 10){
            println("digite")
            var deci: Int = readLine() !!.toInt()
            var control:Int=deci%2
            if (control==0) {
                numPar+=1

            }
            else{
                numImpar+=1
            }

        }
        println("Los números pares son $numPar y los números impares son $numImpar ")*/



    var numPar:Int = 0
    var numImpar:Int = 0
    var acumPar:Int = 0
    var acumIm: Int = 0

    for (i in 1 .. 10){
        println("digite")
        var deci: Int = readLine() !!.toInt()
        var control:Int=deci%2
        if (control==0) {
            numPar+=1
            acumPar += deci



        }
        else{
            numImpar+=1
            acumIm += deci
        }

    }
    println("Los números pares son $numPar y los números impares son $numImpar " + "a")






}