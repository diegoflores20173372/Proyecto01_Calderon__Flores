package com.danp_labs.proyecto01_calderon__flores

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danp_labs.proyecto01_calderon__flores.ui.theme.Proyecto01_Calderon__FloresTheme

class AnimationsAnimals : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto01_Calderon__FloresTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    AnimationAnimalsContainer("Android")
                }
            }
        }
    }
}

@Composable
fun AnimationAnimalsContainer(name: String) {
    val context = LocalContext.current

    Column {
        Button(onClick = {
            val intent = Intent(context, DetailAnimalExtinction::class.java)
            context.startActivity(intent)
        }) {
            Text("Regresar a Detalles de Animales")
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            if(true){
                //DATOS CURIOSOS MAMIFEROS
                SwipeableCard(
                    dataSource = listOf("Aproximadamente al día de hoy viven unos 25.000 a 40.000 osos polares en el Ártico", "los lémures viven en los arboles desde su nacimiento, son sociables y viven en familias de hasta 15 miembros", "La piel del lince varia de color de acuerdo al clima donde vivan", "Los ajolotes solo viven en el agua!")
                )
            }
            else if(0>1){
                //DATOS CURIOSOS REPTILES
                SwipeableCard(
                    dataSource = listOf("La longitud de la iguana azul suele ser de 1,5 metros", "La tortuga de pantano es carnìvora en sus primeros años de vida luego se vuelve herbivora", "Los Geckos son los unicos animales que pueden vocalizar")
                )
            } else if(0>2){
                //DATOS CURIOSOS AVES
                SwipeableCard(
                    dataSource = listOf("Los cóndores adultos muestran sus estados de ánimo a través de cambios de color en la piel.", " El kakapo puede alcanzar de 58 a 64 cm de altura y de 1 a 4 kg de peso.", "El águila monera es la mayor rapaz de las selvas de Filipinas y una de las especies tropicales de águila más grandes", "El colibrí de Arica es la única que posee un pico tan largo y delgado, y que es capaz de volar hacia atrás")
                )
            }else if(0>3){
                //DATOS CURIOSOS PECES
                SwipeableCard(
                    dataSource = listOf("El atún rojo nada a velocidades medias de 5,9 km/h y una máxima de entre 13 y 40 km/h.", "El tiburon ballena nada lentamente pero migra grandes distancias. ", "tan sólo en los últimos 14 años se considera que la especie del pez gato gigante ha disminuido en un 80%")
                )
            }


        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Proyecto01_Calderon__FloresTheme {
        AnimationAnimalsContainer("Android")
    }
}