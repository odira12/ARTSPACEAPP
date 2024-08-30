package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme()
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    var currentImageIndex by remember { mutableStateOf(0) }

    // List of images (drawable resources)
    val images = listOf(R.drawable.liz_3, R.drawable.liz_4, R.drawable.liz_5)

    // Titles and descriptions using string resources
    val titles = listOf(
        stringResource(id = R.string.butterflystyle),
        stringResource(id = R.string.curlsstyle),
        stringResource(id = R.string.linebraids)
    )
    val descriptions = listOf(
        "Newest in Town at a fair price",
        "Wear White Always with our new Nike White Air-force",
        "Shoes of this generation Gen Z!"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Heading for Shoe Plug Kenya
        Text(
            text = "Shoe Plug Kenya",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Display the current image in a circular shape
        Image(
            painter = painterResource(id = images[currentImageIndex]),
            contentDescription = "Saloan Hub",
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape) // Make the image circular
                .border(2.dp, Color.Gray, CircleShape) // Apply border to the circular image
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display the current title
        Text(text = titles[currentImageIndex], fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(8.dp))

        // Display the current description
        Text(text = descriptions[currentImageIndex], fontSize = 16.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // Row with Previous and Next buttons
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Previous button
            Button(onClick = {
                currentImageIndex = if (currentImageIndex == 0) images.size - 1 else currentImageIndex - 1
            }) {
                Text(text = stringResource(id = R.string.previous))
            }

            // Next button
            Button(onClick = {
                currentImageIndex = (currentImageIndex + 1) % images.size
            }) {
                Text(text = stringResource(id = R.string.next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceScreenPreview() {
    ArtSpaceTheme()
}

@Composable
fun ArtSpaceTheme() {

}
