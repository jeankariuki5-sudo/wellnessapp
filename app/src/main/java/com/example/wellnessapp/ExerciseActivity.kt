package com.example.wellnessapp

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_exercise)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupExerciseCard(
            progressBarId = R.id.progressBarjumpingjacks,
            btnStartId = R.id.jumpingjacksstart,
            btnPauseId = R.id.jumpingjacksstop,
            durationSeconds = 120
        )

        setupExerciseCard(
            progressBarId = R.id.progressBarplank,
            btnStartId = R.id.plankstart,
            btnPauseId = R.id.plankstop,
            durationSeconds = 60

        )

        setupExerciseCard(
            progressBarId = R.id.progressBarpushups,
            btnStartId = R.id.pushupstart,
            btnPauseId = R.id.pushupstop,
            durationSeconds = 120
        )
    }

    private fun setupExerciseCard(
        progressBarId: Int,
        btnStartId: Int,
        btnPauseId: Int,
        durationSeconds: Int
    ) {
        val progressBar = findViewById<ProgressBar>(progressBarId)
        val btnStart = findViewById<Button>(btnStartId)
        val btnPause = findViewById<Button>(btnPauseId)

        var isPaused = false
        var isRunning = false

        progressBar.progress = 0

        btnStart.setOnClickListener {
            if (!isRunning) {
                isRunning = true
                isPaused = false
                btnStart.isEnabled = false
                btnPause.isEnabled = true

                Thread {
                    for (i in 0..100) {
                        while (isPaused) { Thread.sleep(100) }

                        Thread.sleep((durationSeconds * 10).toLong())

                        runOnUiThread {
                            progressBar.progress = i

                            if (i == 100) {
                                isRunning = false
                                btnStart.isEnabled = true
                                btnStart.text = "Restart"
                                btnPause.isEnabled = false
                                progressBar.progress = 0
                            }
                        }
                    }
                }.start()
            }
        }

        btnPause.setOnClickListener {
            if (isPaused) {
                isPaused = false
                btnPause.text = "Pause"
                btnPause.backgroundTintList = getColorStateList(android.R.color.holo_red_light)
            } else {
                isPaused = true
                btnPause.text = "Resume"
                btnPause.backgroundTintList = getColorStateList(android.R.color.holo_orange_light)
            }
        }
    }
}