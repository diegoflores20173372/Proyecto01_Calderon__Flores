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
            SwipeableCard(
                dataSource = (0..10).map { 0 }.toList()
            )

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