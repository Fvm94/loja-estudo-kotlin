package com.franciscovm.loja.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.franciscovm.loja.data.ItemType
import com.franciscovm.loja.data.Joia
import com.franciscovm.loja.databinding.FragmentHomeBinding
import com.franciscovm.loja.ui.adapter.ItemAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val anel = Joia("Anel de Coração",15.60,ItemType.anel,"Lindo Anel com detalhe de Coração")
        val brinco = Joia("Argolas Douradas",10.00, ItemType.brinco,"")
        val brinco2 = Joia("Brinco diamante",15.45, ItemType.brinco,"")
        val colar = Joia("Colar Cobra",19.90,ItemType.colar,"")


        val joias = listOf(anel,brinco,brinco2,colar
        )


        val home_rv = binding.homeRv
        home_rv.hasFixedSize()
        home_rv.layoutManager = GridLayoutManager(this.context,2)
        home_rv.adapter = ItemAdapter(joias)

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}