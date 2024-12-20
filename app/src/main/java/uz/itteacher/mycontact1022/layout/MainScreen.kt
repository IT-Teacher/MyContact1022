package uz.itteacher.mycontact1022.layout

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import uz.itteacher.mycontact1022.model.MyContact
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.IntOffset
import uz.itteacher.mycontact1022.db.AppDataBase


@Composable
fun MainScreen(navController: NavController, mydb: AppDataBase) {
    val contacts by remember {
        mutableStateOf(mydb.myContactDao().getAllContacts())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {

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
                Icon(Icons.Default.MoreVert, contentDescription = "MoreVert")
            }
        }


        if (contacts.isEmpty()) {
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
        } else {
            LazyColumn {
                items(contacts) { contact ->
                    ContactItem(contact,
                        onClick = {
                            navController.navigate("info/${contact.id}")
                        })
                }
            }
        }

        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingActionButton(
                onClick = {
                    navController.navigate("create/0")
                }, modifier = Modifier
                    .padding(16.dp)
                    .clip(shape = CircleShape),
                containerColor = Color(0xFF00B2FF)
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "add",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        }

    }

}

@Composable
fun ContactItem(contact: MyContact, onClick: () -> Unit) {
    var swipeOffset by remember { mutableFloatStateOf(0f) }
    val maxSwipeOffset = 300f

    Box(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(5.dp)) {
            Row {
                IconButton(onClick = {

                }) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                }
                IconButton(onClick = {

                }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset { IntOffset(swipeOffset.toInt(), 0) }
                .background(Color.White)
                .draggable(
                    orientation = Orientation.Horizontal,

                    state = rememberDraggableState { delta -> swipeOffset =
                            (swipeOffset + delta).coerceIn(0f, maxSwipeOffset)
                    },
                    onDragStopped = {
                        swipeOffset = if (swipeOffset > maxSwipeOffset / 2) {
                            maxSwipeOffset
                        } else {
                            0f
                        }
                    }
                )

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .clickable {
                        onClick()
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "",
                        Modifier
                            .size(60.dp)
                            .clip(shape = CircleShape)
                    )
                    Column {
                        Text(
                            modifier = Modifier.padding(start = 16.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            text = "${contact.name} ${contact.surname}"
                        )

                        Text(
                            modifier = Modifier.padding(start = 16.dp),
                            fontSize = 14.sp,
                            color = Color.Gray,
                            text = contact.number
                        )

                    }
                }

                Image(
                    painterResource(id = R.drawable.phone),
                    contentDescription = "",
                    Modifier.size(24.dp)
                )
            }

        }


    }
    Spacer(modifier = Modifier.height(20.dp))
}