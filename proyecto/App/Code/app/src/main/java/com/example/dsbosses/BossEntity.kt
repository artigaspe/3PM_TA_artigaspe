package com.example.dsbosses

data class BossEntity (
    var id: Int = 0,
    var name: String,
    var image: String,
    var location: String,
    var description: String,
    var healthPoints: Int,
    var magicRes: Int,
    var fireRes: Int,
    var lightningRes: Int,
    var physicalRes: Int,
    var slashRes: Int,
    var strikeRes: Int,
    var thrustRes: Int
        )
{}