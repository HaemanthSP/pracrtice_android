package com.example.wakeup

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.wakeup.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var alarm_list: AlarmAdaptor


    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        alarm_list = AlarmAdaptor(binding.root.context)

        val alarm = FirstFragmentArgs.fromBundle(requireArguments()).alarmData
//        if (arguments?.getSerializable("alarm_data") != null) {
//            val alarm: Alarm = arguments?.get("alarm_data") as Alarm
//            alarm_list.addAlarm(alarm)
//        }

        if (alarm != null) {
            alarm_list.addAlarm(alarm)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let { this.setupRecyclerView(recyclerView = it.findViewById(R.id.alarm_list)) }

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // recycler view is the list of cells
    private fun setupRecyclerView(recyclerView: RecyclerView) {
        // let's create a RecyclerViewAdapter that manages the individual cells
        alarm_list.addAlarm(Alarm("07:23 AM", false, "Everyday", "IPL"))
        alarm_list.addAlarm(Alarm("08:26 AM",true, "Everyday", "Morning"))
        recyclerView.adapter = alarm_list
    }

}