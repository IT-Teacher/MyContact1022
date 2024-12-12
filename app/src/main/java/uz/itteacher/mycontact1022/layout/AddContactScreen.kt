package uz.itteacher.mycontact1022.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import uz.itteacher.mycontact1022.db.AppDataBase
import uz.itteacher.mycontact1022.model.MyContact


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactScreen(navController: NavController, mydb: AppDataBase) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Icon(Icons.Default.ArrowBack, contentDescription = "ArrowBack",
                    modifier = Modifier.clickable {
                        navController.navigate("main")
                    })
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Add Contact", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            IconButton(onClick = {
                mydb.myContactDao().addContact(MyContact(name = name, surname = surname, number = number))
                navController.navigate("main")
            }) {
                Icon(Icons.Default.Check, contentDescription = "Check")
            }

        }

        Text(text = "Name", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(6.dp))
                .border(1.dp, Color(0xFFC5C5C5), shape = RoundedCornerShape(6.dp))
                .background(Color(0xFFE5E5E5))
        ) {
            TextField(
                value = name,
                onValueChange = { name = it },
                placeholder = { Text(text = "enter name") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
        Spacer(modifier = Modifier.height(14.dp))
        Text(text = "Surname", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(6.dp))
                .border(1.dp, Color(0xFFC5C5C5), shape = RoundedCornerShape(6.dp))
                .background(Color(0xFFE5E5E5))
        ) {
            TextField(
                value = surname,
                onValueChange = { surname = it },
                placeholder = { Text(text = "enter surname") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
        Spacer(modifier = Modifier.height(14.dp))
        Text(text = "PhoneNumber", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(6.dp))
                .border(1.dp, Color(0xFFC5C5C5), shape = RoundedCornerShape(6.dp))
                .background(Color(0xFFE5E5E5))
        ) {
            TextField(
                value = number,
                onValueChange = { number = it },
                placeholder = { Text(text = "+998 __ ___ __ __") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

    }
}