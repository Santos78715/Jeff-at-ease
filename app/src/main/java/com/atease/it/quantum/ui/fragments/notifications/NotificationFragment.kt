package com.atease.it.quantum.ui.fragments.notifications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atease.it.quantum.adapter.NotificationAdapter
import com.atease.it.quantum.databinding.CustomToolbarBinding
import com.atease.it.quantum.databinding.FragmentNotificationBinding
import com.atease.it.quantum.network.DummyNotificationEarlierResponse
import com.atease.it.quantum.response.DummyNotificationData
import com.atease.it.quantum.network.DummyNotificationTodayResponse

class NotificationFragment : Fragment() {
    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!
    private var toolbarBinding: CustomToolbarBinding? = null

    lateinit var recyclerView1: RecyclerView
    lateinit var recyclerView2: RecyclerView

    lateinit var todayListAdapter: NotificationAdapter
    lateinit var earlierAdapter: NotificationAdapter

    var todayData: ArrayList<DummyNotificationData> = ArrayList()
    var earlierData: ArrayList<DummyNotificationData> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        toolbarBinding = binding.toolbar
        binding.toolbar.toolbarTitle.text = "Notifications"
        setUpRecyclerView()
        return binding.root

    }
    private fun setUpRecyclerView() {
        recyclerView1 = binding.recyclerToday
        todayListAdapter = NotificationAdapter(requireContext())
        recyclerView1.adapter = todayListAdapter
        recyclerView1.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        //to be deleted
        todayData = DummyNotificationTodayResponse().setDummyNotificationData()
        todayListAdapter.setData(todayData)


        recyclerView2 = binding.recyclerEarlier
        earlierAdapter = NotificationAdapter(requireContext())
        recyclerView2.adapter = earlierAdapter
        recyclerView2.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        //to be deleted
        earlierData = DummyNotificationEarlierResponse().setDummyNotificationData()
        earlierAdapter.setData(earlierData)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}