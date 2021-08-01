package com.example.mvvmEx.util


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import timber.log.Timber


object NavigationUtil {


    fun Fragment.popStack() = catch { findNavController().popBackStack() }

    fun Fragment.navigateTo(
        id: Int,
        args: Bundle? = null,
        navOptions: NavOptions? = null,
        extras: Navigator.Extras? = null
    ) = catch { findNavController().navigate(id, args, navOptions, extras) }


    private fun catch(navigate: () -> Unit) =
        try {
            navigate()
        } catch (t: Throwable) {
            Timber.e("Multiple navigation attempts handled. $t")
        }
}
