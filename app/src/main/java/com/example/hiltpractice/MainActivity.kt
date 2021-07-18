package com.example.hiltpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var car:Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        car.startCar()
    }
}


class Car(val engine :Engine,val number : Int){

    fun startCar(){
        engine.getStartEngine()
        Log.d("TAG","startCar  ${number}")
    }
}
class Engine @Inject constructor(val piston: Piston) {
    fun getStartEngine(){
        piston.pistonStarted()
        Log.d("TAG","getStartEngine")
    }

}

class Piston(val numberOfPiston: NumberOfPiston){
    fun pistonStarted(){
        numberOfPiston.pistonNumber()
        Log.d("TAG","piston started")
    }

}

interface NumberOfPiston {
    fun pistonNumber()

}

class NumberofPistonImpl :NumberOfPiston{
    override fun pistonNumber() {
        Log.d("TAG","PistonNumber : 4")
    }

}
