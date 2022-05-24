package com.danp_labs.proyecto01_calderon__flores

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.danp_labs.proyecto01_calderon__flores.ui.theme.*

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
    val context = LocalContext.current
    val intent = (context as DetailAnimalExtinction).intent
    val speciesId = intent.getIntExtra("speciesId", -1)
    Column(
        //Style
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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