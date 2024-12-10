package uz.itteacher.mycontact1022.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.itteacher.mycontact1022.R

@Composable
fun MainScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "My Contacts", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Row {
                Icon(Icons.Default.Search, contentDescription = "Search")
                Icon(Icons.Default.MoreVert, contentDescription = "Search")
            }
        }
    }
    if (true) {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.box),
                contentDescription = "",
                Modifier.size(200.dp)
            )
        }
    }

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(onClick = {
            navController.navigate("create")
        }, modifier = Modifier.padding(16.dp).clip(shape = CircleShape),
            containerColor = Color(0xFF00B2FF)) {
            Icon(Icons.Default.Add, contentDescription = "add", tint = Color.White, modifier = Modifier.size(32.dp))
        }
    }

}