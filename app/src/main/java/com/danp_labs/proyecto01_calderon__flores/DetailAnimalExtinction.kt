package com.danp_labs.proyecto01_calderon__flores

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danp_labs.proyecto01_calderon__flores.models.DataAnimals
import com.danp_labs.proyecto01_calderon__flores.ui.theme.*
import java.util.*
import kotlin.collections.ArrayList

class DetailAnimalExtinction : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val intent = (context as DetailAnimalExtinction).intent
            val speciesId = intent.getIntExtra("speciesId", -1)
            Proyecto01_Calderon__FloresTheme {
                var speciesColor = MaterialTheme.colors.background
                when (speciesId) {
                    0 -> speciesColor = Brown864
                    1 -> speciesColor = Green
                    2 -> speciesColor = Gray
                    3 -> speciesColor = Skyblue
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(speciesColor)
                ) {
                    ListAnimalContainer()
                }
            }
        }
    }
}

@Composable
fun ListAnimalContainer() {
    // Getting IntExtra
    val context = LocalContext.current
    val intent = (context as DetailAnimalExtinction).intent
    val speciesId = intent.getIntExtra("speciesId", -1)
    // Creating data from each species
    val mammals = ArrayList<DataAnimals>()
    mammals.add(
        DataAnimals(
            0,
            "Oso Polar",
            arrayOf("Pérdida de su habitat", "Cambio climático", "Caza insostenible"),
            R.drawable.osos_polares
        )
    )
    mammals.add(
        DataAnimals(
            1,
            "Ajolote",
            arrayOf("Habitat natural destruido", "Caza por depredadores", "Calidad de agua"),
            R.drawable.ajolote
        )
    )
    mammals.add(
        DataAnimals(
            2,
            "Lince Ibérico",
            arrayOf("Caza indiscriminada", "Atropellos", "Enfermedades"),
            R.drawable.lince_iberico
        )
    )
    mammals.add(
        DataAnimals(
            3,
            "Lémures",
            arrayOf("Destrucción de hábitat", "Caza por depredadores", "Sequías"),
            R.drawable.lemur
        )
    )
    val reptiles = ArrayList<DataAnimals>()
    reptiles.add(
        DataAnimals(
            0,
            "Iguana Azul",
            arrayOf("Incapacidad de aparearse", "Baja natalidad", "Caza por piel"),
            R.drawable.iguana_azul
        )
    )
    reptiles.add(
        DataAnimals(
            1,
            "Tortuga Pantano",
            arrayOf("Baja natalidad", "Caza por depredadores", "Caza ilegal"),
            R.drawable.tortuga_pantano
        )
    )
    reptiles.add(
        DataAnimals(
            2,
            "Camaleón Tarzán",
            arrayOf("Invasión de hábitat", "Destrucción de hábitat", "Sin protección"),
            R.drawable.camaleon_tarzan
        )
    )
    reptiles.add(
        DataAnimals(
            3,
            "Gecko Jaspeado",
            arrayOf("Secuestros de humanos", "Dietas incorrectas", "Falta de costumbre"),
            R.drawable.gecko_jaspeado
        )
    )
    val birds = ArrayList<DataAnimals>()
    birds.add(
        DataAnimals(
            0,
            "Cóndor",
            arrayOf("Pérdida de hábitat", "Baja natalidad", "Baja tasa de reproducción"),
            R.drawable.condor
        )
    )
    birds.add(
        DataAnimals(
            1,
            "Kakapo",
            arrayOf("Invasión humana", "Pérdida de hábitat", "Pérdida de machos"),
            R.drawable.kakapo
        )
    )
    birds.add(
        DataAnimals(
            2,
            "Águila Monera",
            arrayOf("Baja tasa de natalidad", "Pérdida de hábitat", "Tala de bosques"),
            R.drawable.aguila_monera
        )
    )
    birds.add(
        DataAnimals(
            3,
            "Colibri de Árica",
            arrayOf("Baja reproducción", "Baja natalidad", "Pérdida de hábitat"),
            R.drawable.colibri_arica
        )
    )
    val fishes = ArrayList<DataAnimals>()
    fishes.add(
        DataAnimals(
            0,
            "Atún Rojo",
            arrayOf("Caza indiscriminada", "Caza por depredadores", "Ataques al hábitat"),
            R.drawable.atun_rojo
        )
    )
    fishes.add(
        DataAnimals(
            1,
            "Tiburón Ballena",
            arrayOf("Pesca artesanal", "Caza por depredadores", "Caza indiscriminada"),
            R.drawable.tiburon_ballena
        )
    )
    fishes.add(
        DataAnimals(
            2,
            "Raya Común",
            arrayOf("Invasión de hábitat", "Caza por depredadores", "Caza por comida"),
            R.drawable.raya_comun
        )
    )
    fishes.add(
        DataAnimals(
            3,
            "Pez Gato Gigante",
            arrayOf("Sobrepesca", "Baja reproducción", "Ataques al hábitat"),
            R.drawable.pez_gato_gigante
        )
    )
    //Assign data
    var dataSpecies = ArrayList<DataAnimals>()
    when(speciesId) {
        0 -> dataSpecies.addAll(mammals)
        1 -> dataSpecies.addAll(reptiles)
        2 -> dataSpecies.addAll(birds)
        3 -> dataSpecies.addAll(fishes)
    }

    Column(
        //Style
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (i in 0..3) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                elevation = 15.dp,
                shape = RoundedCornerShape(15.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .padding(15.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End,
                ) {
                    Image(
                        painterResource(dataSpecies[i].animalImage),
                        contentDescription = "Aves ##",
                        modifier = Modifier.height(150.dp)
                    )
                }
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(text = "   " + dataSpecies[i].animalName)
                    for(j in 0..2) {
                        Text("  -    " + dataSpecies[i].featuresOfAnimal[j])
                    }
                }
            }
        }

        Button(onClick = {
            val intent1 = Intent(context, AnimationsAnimals::class.java)
            intent1.putExtra("idSpecies", speciesId)
            context.startActivity(intent1)
        }) {
            Text("Ver Animaciones")
        }
        Button(onClick = {
            val intent2 = Intent(context, HomeListSpecies::class.java)
            context.startActivity(intent2)
        }) {
            Text("Regresar al inicio")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    val context = LocalContext.current
    val intent = (context as DetailAnimalExtinction).intent
    val speciesId = intent.getIntExtra("speciesId", -1)
    Proyecto01_Calderon__FloresTheme {
        var speciesColor = MaterialTheme.colors.background
        when (speciesId) {
            0 -> speciesColor = Brown864
            1 -> speciesColor = Green
            2 -> speciesColor = Gray
            3 -> speciesColor = Skyblue
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(speciesColor)
        ) {
            ListAnimalContainer()
        }
    }
}