package com.mexiti.foodcal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.mexiti.foodcal.ui.screens.FoodsApp
import com.mexiti.foodcal.ui.theme.FoodAppTheme
import com.mexiti.foodcal.viewmodel.DailyFoodVM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val dailyFoodVM: DailyFoodVM by viewModels()
            FoodAppTheme {
                FoodsApp(dailyFoodVM)
            }

        }
    }
}

