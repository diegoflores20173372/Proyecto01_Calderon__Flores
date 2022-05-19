package com.danp_labs.proyecto01_calderon__flores

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danp_labs.proyecto01_calderon__flores.models.Species
import com.danp_labs.proyecto01_calderon__flores.ui.theme.Proyecto01_Calderon__FloresTheme

var selectedSpecies: Species? = null

class HomeListSpecies : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto01_Calderon__FloresTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomePageContainer()
                }
            }
        }
    }
}

@Composable
fun SpeciesSpinner(species: List<Species>) {
    var expanded by remember {
        mutableStateOf(false)
    }
    var speciesName by remember {
        mutableStateOf("Selecciona una especie...")
    }
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .clickable {
                    expanded = !expanded
                }
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = speciesName,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .width(220.dp)
            )
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Elegir una especie"
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }) {
                species.forEach { species ->
                    DropdownMenuItem(
                        onClick = {
                            expanded = false
                            speciesName = species.toString()
                            selectedSpecies = species
                        },
                        modifier = Modifier.width(220.dp)
                    ) {
                        Text(text = species.toString())
                    }
                }
            }
        }
    }

}

@Composable
fun HomePageContainer() {
    //Create array of species
    val species = ArrayList<Species>()
    //Adding data
    species.add(Species(speciesId = 0, speciesName = "Mamíferos"))
    species.add(Species(speciesId = 1, speciesName = "Reptiles"))
    species.add(Species(speciesId = 2, speciesName = "Aves"))
    species.add(Species(speciesId = 3, speciesName = "Peces"))

    //Getting context to launch second compose
    val context = LocalContext.current

    //Creation from view
    Column(
        //Style
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Here will go a picture or message of save animals
        Image(
            painterResource(R.drawable.logo_image_home),
            contentDescription = "Logo Save Animals",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.height(300.dp)
        )
        //Here add the spinner
        SpeciesSpinner(species = species)
        //Here the button to launch the second compose
        Button(onClick = {
            val intent = Intent(context, DetailAnimalExtinction::class.java)
            if (selectedSpecies != null) {
                intent.putExtra("speciesId", selectedSpecies!!.speciesId)
                context.startActivity(intent)
            } else {
                Toast.makeText(
                    context,
                    "Debe escoger una especie para continuar",
                    Toast.LENGTH_LONG
                ).show()
            }
        }) {
            Text("Buscar Animales en Peligro")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Proyecto01_Calderon__FloresTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            HomePageContainer()
        }
    }
}