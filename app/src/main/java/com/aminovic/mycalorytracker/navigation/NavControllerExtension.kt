package com.aminovic.mycalorytracker.navigation

import androidx.navigation.NavController
import com.aminovic.core.util.UiEvent


fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}