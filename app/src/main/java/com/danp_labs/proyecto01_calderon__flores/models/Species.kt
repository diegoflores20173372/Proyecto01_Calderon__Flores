package com.danp_labs.proyecto01_calderon__flores.models

data class Species(var speciesId: Int = -1, var speciesName: String = ""){
    override fun toString(): String {
        return speciesName
    }
}
