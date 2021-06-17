package com.example.mvvmEx.util


import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.findNavController
import com.example.mvvmEx.R
import timber.log.Timber


object NavigationUtil {

    private val options =
        NavOptions.Builder()
            .setEnterAnim(R.anim.nav_default_enter_anim)
            .setExitAnim(R.anim.nav_default_exit_anim)
            .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
            .build()

    fun View.findNavigationController() = this.findNavController()


    fun NavController.navigateTo(
        id: Int,
        args: Bundle? = null,
        navOptions: NavOptions = options,
        extras: Navigator.Extras? = null
    ) {
        try {
            this.navigate(id, args, navOptions, extras)
        } catch (t: Throwable) {
            Timber.e("Multiple navigation attempts handled. $t")
        }
    }


}
