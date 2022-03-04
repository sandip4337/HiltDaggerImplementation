package com.sandip.hiltdagger

import android.util.Log
import javax.inject.Inject

// CAR CLASS DEPENDS ON TWO class ENGINE AND WHEELS
// WE HAVE TO PASS TWO INSTANCE OF ENGINE AND WHEELS CLASS IN CONSTRUCTOR AS PARAMETER OF THE CAR CLASS
// THE DEPENDENCIES ARE PASSED BY CONSTRUCTOR IN THE CLASS THIS IS CALLED CONSTRUCTOR DEPENDENCY INJECTION
class Car @Inject constructor(private val engine: Engine, private val wheels: Wheels) {

//    FIELD INJECTION
//    @Inject lateinit var engine: Engine
//    @Inject lateinit var wheels: Wheels

    fun getCar(){
        Log.d("Car","It is my car")
        wheels.getwheels()
        engine.gasEngine()
    }

    fun getCar2(){
        engine.oilEngine()
    }
}

class Engine @Inject constructor() {

    fun gasEngine(){
        Log.d("Engine","This car has GasEngine")
    }

    fun oilEngine(){
        Log.d("Engine","This is OilEngine")
    }

}
class Wheels @Inject constructor() {

    fun getwheels(){
        Log.d("Wheel","This car has 4 wheels")
    }
}