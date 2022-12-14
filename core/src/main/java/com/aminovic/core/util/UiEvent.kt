package com.aminovic.core.util


//
// Created by Mohamed El Amine Nouri on 20/10/2022.
// Copyright (c) 2021 Track24. All rights reserved.
//

sealed class UiEvent {
    object Success : UiEvent()
    object NavigateUp : UiEvent()
    data class ShowSnackbar(val message: UiText) : UiEvent()
}