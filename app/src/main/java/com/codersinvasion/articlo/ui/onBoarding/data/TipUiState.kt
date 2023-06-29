package com.codersinvasion.articlo.ui.onBoarding.data

import androidx.annotation.DrawableRes

data class TipUiState(
    @DrawableRes
    val imageRes: Int,
    val title: String,
    val subtitle: String,
)