package com.backtocoding.chatappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.backtocoding.chatappclone.ui.ChatListScreen
import com.backtocoding.chatappclone.ui.ProfileScreen
import com.backtocoding.chatappclone.ui.SignupScreen
import com.backtocoding.chatappclone.ui.SingleChatScreen
import com.backtocoding.chatappclone.ui.SingleStatusScreen
import com.backtocoding.chatappclone.ui.StatusListScreen
import com.backtocoding.chatappclone.ui.theme.ChatAppCloneTheme

sealed class DestinationScreen(val route: String) {
    object Signup : DestinationScreen("signup")
    object Login : DestinationScreen("login")
    object Profile : DestinationScreen("profile")
    object ChatList : DestinationScreen("chatList")
    object SingleChat : DestinationScreen("singleChat/{chatId}") {
        fun createRoute(id: String) = "singleChat/$id"
    }

    object StatusList : DestinationScreen("statusList")
    object SingleStatus : DestinationScreen("singleStatus/{statusId}") {
        fun createRoute(id: String) = "singleStatus/$id"
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChatAppNavigation()
                }
            }
        }
    }
}

@Composable
fun ChatAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = DestinationScreen.Profile.route) {
        composable(DestinationScreen.Signup.route) {
            SignupScreen()
        }
        composable(DestinationScreen.Login.route) {
            LoginScreen()
        }
        composable(DestinationScreen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(DestinationScreen.StatusList.route) {
            StatusListScreen(navController = navController)
        }
        composable(DestinationScreen.SingleStatus.route) {
            SingleStatusScreen(statusId = "123")
        }
        composable(DestinationScreen.ChatList.route) {
            ChatListScreen(navController = navController)
        }
        composable(DestinationScreen.SingleChat.route) {
            SingleChatScreen(chatId = "123")
        }
    }
}
