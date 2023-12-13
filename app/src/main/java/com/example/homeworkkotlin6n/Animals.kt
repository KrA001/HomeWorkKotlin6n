package com.example.homeworkkotlin6n

import androidx.annotation.DrawableRes

data class Animals(
    @DrawableRes val animalImage: Int, //Картинка
    val name: String, //Имя
    val claws: String, //Когти
    val beak: String //Клюв
)
