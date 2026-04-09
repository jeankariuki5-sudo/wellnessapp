package com.example.wellnessapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HealthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_health)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val FruitSalad = findViewById<CardView>(R.id.fruitsalad)
        val GrilledChicken = findViewById<CardView>(R.id.grilledchicken)
        val VegetableStirFry = findViewById<CardView>(R.id.vegatablestirfry)
        val Oatmeal = findViewById<CardView>(R.id.oatmeal)
        val AvocadoToast = findViewById<CardView>(R.id.avocadotoast)
        val BoiledEggs = findViewById<CardView>(R.id.boiledeggs)
        val SmoothieBowl = findViewById<CardView>(R.id.smoothiebowl)
        val BrownRice = findViewById<CardView>(R.id.brownrnb)
        val BakedFish = findViewById<CardView>(R.id.bakedfish)
        val Yoghurt = findViewById<CardView>(R.id.greekyoghurt)


        FruitSalad.setOnClickListener {
            val intent = Intent(applicationContext, FruitSaladActivity::class.java)
            startActivity(intent)
        }

        GrilledChicken.setOnClickListener {
            val intent = Intent(applicationContext, GrilledChickenActivity::class.java)
            startActivity(intent)
        }

        VegetableStirFry.setOnClickListener {
            val intent = Intent(applicationContext, VegetableStirFryActivity::class.java)
            startActivity(intent)
        }

        Oatmeal.setOnClickListener {
            val intent = Intent(applicationContext, OatmealActivity::class.java)
            startActivity(intent)
        }

        AvocadoToast.setOnClickListener {
            startActivity(Intent(applicationContext, AvocadoToastActivity::class.java))
        }

        BoiledEggs.setOnClickListener {
            startActivity(Intent(applicationContext, BoiledEggsActivity::class.java))
        }

        SmoothieBowl.setOnClickListener {
            val intent = Intent(applicationContext, SmoothieBowlsActivity::class.java)
            startActivity(intent)
        }

        BrownRice.setOnClickListener {
            val intent = Intent(applicationContext, BrownRnbActivity::class.java)
            startActivity(intent)
        }

        BakedFish.setOnClickListener {
            val intent = Intent(applicationContext, BakedFishActivity::class.java)
            startActivity(intent)
        }

        Yoghurt.setOnClickListener {
            val intent = Intent(applicationContext, GreekYoghurtActivity::class.java)
            startActivity(intent)
        }


    }
}