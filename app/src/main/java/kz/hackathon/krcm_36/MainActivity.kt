package kz.hackathon.krcm_36

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kz.hackathon.krcm_36.ui.navigation.Routing
import kz.hackathon.krcm_36.ui.screens.main.SearchScreen
import kz.hackathon.krcm_36.ui.screens.main.TopBarScreen
import kz.hackathon.krcm_36.ui.screens.navigation.NavigationItem
import kz.hackathon.krcm_36.ui.theme.Krcm36Theme
import kz.hackathon.krcm_36.ui.theme.PrimaryYellow

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Krcm36Theme {
                val items = listOf(
                    NavigationItem(
                        title = "My Account",
                        selectedIcon = Icons.Filled.AccountCircle,
                        unselectedIcon = Icons.Outlined.AccountCircle
                    ),
                    NavigationItem(
                        title = "My Cards",
                        selectedIcon = painterResource(id =R.drawable.ic_card),
                      //  unselectedIcon = painterResource(id = R.drawable.ic_card),
                    ),
                    NavigationItem(
                        title = "Settings",
                        selectedIcon = Icons.Filled.Settings,
                        unselectedIcon = Icons.Outlined.Settings
                    ),
                    NavigationItem(
                        title = "Log Out",
                        selectedIcon = Icons.Filled.ExitToApp,
                        unselectedIcon = Icons.Outlined.ExitToApp
                    )
                )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    
                    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val scope = rememberCoroutineScope()
                    var selectedItemIndex by rememberSaveable {
                        mutableIntStateOf(0)
                    }
                    ModalNavigationDrawer(
                        drawerContent = {
                            ModalDrawerSheet {
                                Spacer(modifier = Modifier.height(12.dp))
                                items.forEachIndexed { index, Item ->
                                    NavigationDrawerItem(
                                        label = { Text(Item.title) },
                                        selected = index == selectedItemIndex,
                                        onClick = {
                                            selectedItemIndex = index
                                            scope.launch {
                                                drawerState.close()
                                            }
                                        },
                                        icon = {
                                            if (Item.isSelectedIconImageVector){
                                                Icon(
                                                    imageVector = Item.selectedIcon as ImageVector,
                                                    contentDescription = "something"
                                                )
                                            } else if (Item.isSelectedIconPainter) {
                                                Icon(
                                                    painter = Item.selectedIcon as Painter,
                                                    contentDescription = null
                                                )
                                            } else {
                                                Icon(
                                                    imageVector = Icons.Default.Warning,
                                                    contentDescription = "Error"
                                                )
                                            }
                                        },
                                        badge = {
                                            Item.bagCount?.let {
                                                Text(text = Item.bagCount.toString())
                                            }
                                        },
                                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                                    )
                                }
                            }

                        },
                        drawerState = drawerState
                    ) {
                        Scaffold(
                            topBar = {
                                TopAppBar(
                                    title = {
                                        //Spacer(modifier = Modifier.height(12.dp))
                                          //TopBarScreen()
                                    },
                                    navigationIcon = {
                                        IconButton(onClick = {
                                            scope.launch {
                                                drawerState.open()
                                            }
                                        }) {
                                            Icon(
                                                painterResource(id = R.drawable.ic_sidebar) ,
                                                contentDescription = "Menu",
                                                tint = PrimaryYellow
                                            )
                                        }
                                    },
                                    //modifier = Modifier.size(width = 1000.dp, height = 150.dp)
                                )
                            },
                        ) {
                            Column(
                                modifier = Modifier.padding(it)
                            ){
                                Routing()
                            }
//                            Box(modifier = Modifier.fillMaxSize()){
//                                Spacer(modifier = Modifier.height(50.dp))
//                                Routing()
//                            }
                            Log.e("something", "${it.toString()}")
                        }
                    }

                }
                //Routing()
//                    Greeting("Android")
            }
        }
    }
}

