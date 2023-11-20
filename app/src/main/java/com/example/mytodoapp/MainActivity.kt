package com.example.mytodoapp

import android.icu.text.CaseMap.Title
import android.os.Build
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytodoapp.ui.theme.MyTodoAppTheme
import java.lang.reflect.Field
import androidx.compose.ui.tooling.preview.Preview as Preview1

class MainActivity() : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.Q)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTodoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val todoList = remember { mutableStateListOf<String>() } // creer une variable todolist la liste pour stocker les taches
                    var newTodoItem: String by remember { mutableStateOf("") } // variable d'etat pour ajouter une nouvelle tache State variable for new todo item text

                    Column {
                        Title("MA TODO LIST")
                        Spacer(modifier = Modifier.height(16.dp))

                        Row {
                            TextField(
                                value = newTodoItem,
                                onValueChange = { newTodoItem = it },
                                label = { Text("entrer votre tache") }
                            )
                            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                            Button(onClick = {
                                if (newTodoItem.isNotEmpty()) {
                                    todoList.add(newTodoItem)
                                    newTodoItem = ""
                                }
                            }) {
                                Text("Ajouter")
                            }
                        }
                            // Display the list of todo items with delete buttons

                            todoList.forEach { task ->
                                Row { // Arrange task text and delete button
                                    Text(task) // Display the task text
                                    IconButton(onClick = {
                                        todoList.remove(task) // Remove the task from the list
                                    }) {
                                        Icon(
                                            Icons.Filled.Delete,
                                            contentDescription = "supprimer la tache"
                                        )
                                    }
                                }
                            }
                    }
                }
            }
        }
    }
}

/*@Composable
fun Title(name: String, modifier: Modifier = Modifier) {
    Text(
        text = " $name!",
        modifier = modifier
    )
}*/
@Composable
fun Title(name: String, modifier: Modifier = Modifier) {
        Text(
            text = " $name!",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Red, )
        )

}

@Preview1(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTodoAppTheme {
        Title("Android")
    }
}