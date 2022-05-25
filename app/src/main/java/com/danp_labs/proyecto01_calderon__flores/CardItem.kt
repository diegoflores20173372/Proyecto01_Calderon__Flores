package com.danp_labs.proyecto01_calderon__flores

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danp_labs.proyecto01_calderon__flores.Constants.cornerRadiusBig
import com.danp_labs.proyecto01_calderon__flores.Constants.normalElevation

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    cardIndex: String
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(cornerRadiusBig),
        elevation = normalElevation
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(20.dp),
                text = cardIndex,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 30.sp
                )
            )
        }
    }
}
