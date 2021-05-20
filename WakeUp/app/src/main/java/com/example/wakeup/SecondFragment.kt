package com.example.wakeup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wakeup.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            val timeFormated = formatTime(binding.addAlarmPickTime)
            val alarm = Alarm(timeFormated, true, binding.addAlarmRepeat.text.toString(), binding.addAlarmTitle.text.toString())

            val bundle = Bundle()
            bundle.putSerializable("alarm_data", alarm)

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun formatTime(timePicker: TimePicker): String {
        var hour = timePicker.hour
        val minute = timePicker.minute
        var format = "AM"
        var is24= timePicker.is24HourView

        when {
            hour > 12 -> {
                format = "PM"
                hour -= 12
            }
            hour == 0 -> {
                hour = 12
            }
            hour == 12 -> {
                format = "PM"
            }
        }

        return "$hour : $minute $format"
    }
}