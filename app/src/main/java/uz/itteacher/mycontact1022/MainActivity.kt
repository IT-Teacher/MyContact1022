package uz.itteacher.mycontact1022

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.itteacher.mycontact1022.db.AppDataBase
import uz.itteacher.mycontact1022.layout.AddContactScreen
import uz.itteacher.mycontact1022.layout.InfoContactScreen
import uz.itteacher.mycontact1022.layout.MainScreen
import uz.itteacher.mycontact1022.ui.theme.MyContact1022Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val mydb = AppDataBase.getInstance(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyContact1022Theme {
                Column (modifier = Modifier.fillMaxSize()
                    .padding(vertical = 60.dp, horizontal = 16.dp)){
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "main") {
                        composable(route = "main") {
                            MainScreen(navController = navController)
                        }
                        composable(route = "create") {
                            AddContactScreen(navController = navController,mydb)
                        }

                        composable(route = "info") {
                            InfoContactScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}



