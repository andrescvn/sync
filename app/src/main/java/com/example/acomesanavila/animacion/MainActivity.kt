package com.example.acomesanavila.animacion

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            tareaSegundoPlano()
        }
    }

    var job2: Job? = null
    private fun tareaSegundoPlano() = launch(UI) {
        val task = async(CommonPool) {
            for (l in 10 downTo 1) {
                Log.d("tarea", "contador: $l")
                delay(100)
            }
        }
        job2 = task
        task.start()

        for (i in 50 downTo 1) {
            textView.setText("contador " + i)
            delay(200)
        }
        textView.setText("acabao")
    }
}
