package com.cse3200.midterm_timers.ui.mins

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cse3200.midterm_timers.databinding.FragmentMinsBinding
import org.w3c.dom.Text

class MinsFragment : Fragment() {

    private var _binding: FragmentMinsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val minsViewModel =
            ViewModelProvider(this).get(MinsViewModel::class.java)

        _binding = FragmentMinsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMins
        minsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.startButton.setOnClickListener {
            minsViewModel.minsTimeStart = (System.currentTimeMillis() / 60000)
        }

        binding.stopButton.setOnClickListener {
            if (minsViewModel.minsTimeStart > minsViewModel.minsTimeStop) {
                minsViewModel.minsTimeStop = System.currentTimeMillis() / 60000
                updateTime(minsViewModel.minsTimeStop - minsViewModel.minsTimeStart)
            }
        }

        return root
    }

    private fun updateTime(time : Long) {
        binding.timeText.text = time.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}