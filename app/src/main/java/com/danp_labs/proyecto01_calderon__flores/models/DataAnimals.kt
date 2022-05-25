package com.danp_labs.proyecto01_calderon__flores.models

data class DataAnimals(var animalId: Int, var animalName: String, var featuresOfAnimal: Array<String>, var animalImage: Int) {
    override fun toString(): String {
        return animalName
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DataAnimals

        if (animalId != other.animalId) return false
        if (animalName != other.animalName) return false
        if (!featuresOfAnimal.contentEquals(other.featuresOfAnimal)) return false
        if (animalImage != other.animalImage) return false

        return true
    }

    override fun hashCode(): Int {
        var result = animalId
        result = 31 * result + animalName.hashCode()
        result = 31 * result + featuresOfAnimal.contentHashCode()
        result = 31 * result + animalImage
        return result
    }
}