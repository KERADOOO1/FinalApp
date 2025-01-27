package com.example.finalapp



import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalapp.ui.theme.FinalAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FinalAppTheme {
                Surface(color = Color.Magenta) {
                    AppNavigator()
                }
                }
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    Scaffold(

        content = {
            NavigationHost(navController = navController)
        }
    )
}
@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            MenuScreen(navController = navController)
        }
        composable("jeden") {
            EkranJeden()
        }
        composable("dwa") {
            EkranDwa()
        }
        composable("trzy") {
            EkranTrzy()
        }
        composable("cztery") {
            EkranCztery()
        }
        //podzial
        //losowanie
        //powiadomienia
        //notatnik
        //saper
        //kółko i krzyżyk

    }
}

@Composable
fun MenuScreen(navController: NavHostController) {
    LazyColumn (modifier = Modifier
        .background(color = Color(17,16,43))

        .fillMaxSize()
    ){
        item{
            Row (modifier = Modifier
                .fillMaxWidth()

            ){
                Spacer(modifier = Modifier
                    .weight(1f)

                )
                Button(onClick = { navController.navigate("jeden") },
                        modifier = Modifier
                            .weight(10f)
                            .height(60.dp)
                            .padding(5.dp)
                ) {
                    Text("Kostka")
                }
                Spacer(modifier = Modifier
                    .weight(1f)

                )
                Button(onClick = { navController.navigate("dwa") },
                        modifier = Modifier
                            .weight(10f)
                            .height(60.dp)
                            .padding(5.dp)
                    ) {
                    Text("Podział")
                }
                Spacer(modifier = Modifier
                    .weight(1f)

                )
            }

        }

        item{
            Row (modifier = Modifier

                .fillParentMaxWidth()

            ){
                Spacer(modifier = Modifier
                    .weight(1f)

                )
                Button(onClick = { navController.navigate("trzy") },
                    modifier = Modifier
                        .weight(10f)
                        .height(60.dp)
                        .padding(5.dp)
                ) {
                    Text("Losowanie")
                }
                Spacer(modifier = Modifier
                    .weight(1f)

                )
                Button(onClick = { navController.navigate("cztery") },
                    modifier = Modifier
                        .weight(10f)
                        .height(60.dp)
                        .padding(5.dp)
                ) {
                    Text("Ekran Cztery")
                }
                Spacer(modifier = Modifier
                    .weight(1f)

                )
            }

        }

    }
}




