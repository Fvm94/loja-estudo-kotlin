package com.franciscovm.loja.data

import android.content.Context
import android.view.LayoutInflater
import com.franciscovm.loja.R
import com.google.android.material.chip.Chip

data class FilterIten(
    val id:Int,
    val text: String,
)
fun FilterIten.toChip(context: Context) : Chip {

    val chip = LayoutInflater.from(context).inflate(R.layout.chip_choice_layout,null,false) as Chip

    chip.setChipStrokeColorResource(R.color.leve_bazar_secundary)
    chip.chipStrokeWidth =2f
    chip.text = text

    return chip
}