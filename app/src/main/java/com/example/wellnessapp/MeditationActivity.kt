package com.example.wellnessapp

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MeditationActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var timerText: TextView
    private lateinit var btnPause: Button
    private lateinit var btnResume: Button

    private var countDownTimer: CountDownTimer? = null

    private val totalTime = 600000L // 10 min
    private val interval = 1000L

    private var timeLeft = totalTime
    private var progress = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditation)

        progressBar = findViewById(R.id.meditationProgress)
        timerText = findViewById(R.id.timerText)
        btnPause = findViewById(R.id.btnPause)
        btnResume = findViewById(R.id.btnResume)

        progressBar.max = (totalTime / interval).toInt()

        startTimer()

        btnPause.setOnClickListener {
            pauseTimer()
        }

        btnResume.setOnClickListener {
            resumeTimer()
        }
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(timeLeft, interval) {

            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished

                progress++
                progressBar.progress = progress

                val minutes = (timeLeft / 1000) / 60
                val seconds = (timeLeft / 1000) % 60

                timerText.text = String.format("%02d:%02d", minutes, seconds)
            }

            override fun onFinish() {
                timerText.text = "Done 🧘"
                progressBar.progress = progressBar.max

            }

        }.start()
    }

    private fun pauseTimer() {
        countDownTimer?.cancel()
    }

    private fun resumeTimer() {
        startTimer()
    }

}