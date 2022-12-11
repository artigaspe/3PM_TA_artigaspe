package com.example.dsbosses

data class BossEntity (
    var id: Int = 0,
    var name: String,
    var image: String,
    var description: String,
    var location: String,
    var physicalRes: String,
    var slashRes: String,
    var strikeRes: String,
    var thrustRes: String,
    var magicRes: String,
    var fireRes: String,
    var lightningRes: String,
    var healthPoints: String
        )
{}