package com.franciscovm.loja.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.franciscovm.loja.R
import com.franciscovm.loja.data.FilterIten
import com.franciscovm.loja.data.toChip
import com.franciscovm.loja.databinding.FragmentHomeBinding
import com.franciscovm.loja.ui.adapter.ItemAdapter
import com.google.android.material.chip.Chip

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private var spanCount: Int = 3

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

        val home_rv = binding.homeRv
        home_rv.hasFixedSize()

        val joias = homeViewModel.joias.value

        home_rv.layoutManager = GridLayoutManager(this.context,spanCount)
        home_rv.adapter = joias?.let { ItemAdapter(it) }

        val filters = arrayOf(
            FilterIten(1,"Aneis"),
            FilterIten(2, "Colares"),
            FilterIten(3,"Brincos"),
            FilterIten(4, "Argolas")
            )

        filters.forEach {
            binding.homeChipgroupFilter.addView(it.toChip(requireContext()))
        }


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