package com.backtocoding.chatappclone

import androidx.navigation.NavController

fun navigateTo(navController: NavController, route: String) {
    navController.navigate(route) {
        /**
         *  If we have multiple of these routes in the backstack,
         *  so if we have multiple components in the backstack, we don't
         *  want to just add another instance of that composable.
         *  We want to remove everything on top
         *  -> so pop up to everything until that route, until that screen.
         *  So we remove everything that's on top and
         *  we just display the screen without creating a new instance
         *  of that composable. That saves us a lot of memory.
         *  Also when we hit the back button, it won't go back in the history
         *  of us navigating between the screens, it will just go back to the
         *  original screen
         */
        popUpTo(route)
        /**
         * launchSingleTop allow us to not have multiple instances
         * of the same composable on top of each other.
         *  A SingleTop, a Single instance, again saving us memory.
         * */
        launchSingleTop = true
    }
}