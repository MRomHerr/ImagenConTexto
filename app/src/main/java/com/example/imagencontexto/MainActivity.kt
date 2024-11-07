package com.example.imagencontexto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImagenConTexto()
        }
    }
}

@Preview
@Composable
fun ImagenConTexto() {

    val imagenActual = remember { mutableStateOf(R.drawable.kuenkro) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Image(
                painter = painterResource(id = imagenActual.value),
                contentDescription = "Imagen de Kuenkro",
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 16.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))


            Button(
                onClick = {
                    imagenActual.value = if (imagenActual.value == R.drawable.kuenkro) {
                        R.drawable.knekroelegante
                    } else {
                        R.drawable.kuenkro
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("KUENKRO", fontSize = 18.sp)
            }
        }
    }
}
