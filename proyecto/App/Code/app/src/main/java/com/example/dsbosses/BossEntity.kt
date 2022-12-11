package com.example.dsbosses

data class BossEntity (
    var id: Int = 0,
    var name: String,
    var image: String,
    var description: String,
    var location: String,
    var physicalRes: Int,
    var slashRes: Int,
    var strikeRes: Int,
    var thrustRes: Int,
    var magicRes: Int,
    var fireRes: Int,
    var lightningRes: Int,
    var healthPoints: Int
        )
{}