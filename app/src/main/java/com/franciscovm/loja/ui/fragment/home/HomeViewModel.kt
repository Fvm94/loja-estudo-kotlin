package com.franciscovm.loja.ui.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.franciscovm.loja.data.ItemType
import com.franciscovm.loja.data.Joia

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _joias = MutableLiveData<List<Joia>>().apply {
        val anel = Joia("Anel de Coração",15.60, ItemType.anel,"Lindo Anel com detalhe de Coração")
        val brinco = Joia("Argolas Douradas",10.00, ItemType.brinco,"")
        val brinco2 = Joia("Brinco diamante",15.45, ItemType.brinco,"")
        val colar = Joia("Colar Cobra",19.90, ItemType.colar,"")
        val anel2 = Joia("Anel de Coração",15.60, ItemType.anel,"Lindo Anel com detalhe de Coração")
        val brinco3 = Joia("Argolas Douradas",10.00, ItemType.brinco,"")
        val brinco4 = Joia("Brinco diamante",15.45, ItemType.brinco,"")
        val colar2 = Joia("Colar Cobra",19.90, ItemType.colar,"")


        value = listOf(anel,brinco,brinco2,colar,anel2,brinco2,brinco3,
            brinco4,colar2,anel,brinco,brinco2,colar,anel2,brinco2,brinco3,
            brinco4,colar2,anel,brinco,brinco2,colar,anel2,brinco2,brinco3,
            brinco4,colar2
        )
    }

    val joias = _joias

}