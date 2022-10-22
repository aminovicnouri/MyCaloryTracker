package com.aminovic.onboarding_presentation.age

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.aminovic.core.R
import com.aminovic.core.util.UiEvent
import com.aminovic.core_ui.LocalSpacing
import com.aminovic.onboarding_presentation.components.ActionButton
import com.aminovic.onboarding_presentation.components.UnitTextField
import kotlinx.coroutines.flow.collect


@Composable
fun AgeScreen(
    scaffoldState: ScaffoldState,
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: AgeViewModel = hiltViewModel()
) {
    val localSpacing = LocalSpacing.current
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                }
                else -> Unit
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = localSpacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.whats_your_age),
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(localSpacing.spaceMedium))
            UnitTextField(
                value = viewModel.age,
                onValueChanged = viewModel::onAgeEnter,
                unit = stringResource(
                    id = R.string.years
                )
            )
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = viewModel::onNextScreen,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}