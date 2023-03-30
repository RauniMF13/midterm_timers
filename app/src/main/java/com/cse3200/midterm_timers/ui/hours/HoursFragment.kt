package com.cse3200.midterm_timers.ui.hours

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cse3200.midterm_timers.databinding.FragmentHoursBinding

class HoursFragment : Fragment() {

    private var _binding: FragmentHoursBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HoursViewModel::class.java)

        _binding = FragmentHoursBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHours
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}