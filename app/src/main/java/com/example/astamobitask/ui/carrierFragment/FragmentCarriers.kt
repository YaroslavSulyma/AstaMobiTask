package com.example.astamobitask.ui.carrierFragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.astamobitask.R
import com.example.astamobitask.ui.FragmentCarriersViewModel
import com.example.astamobitask.ui.ItemsInterface
import com.example.astamobitask.ui.carrierFragment.carrierRecyclerView.CarriersAdapter
import com.example.astamobitask.ui.carrierFragment.carrierRecyclerView.Worker

class FragmentCarriers : Fragment(), ItemsInterface {
    override fun loadFinished(response: ArrayList<Worker>) {
        viewAdapter?.update(response)
    }

    override fun loadError(error: String) {
        Toast.makeText(activity, error, Toast.LENGTH_LONG).show()
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var pullToRefresh: SwipeRefreshLayout

    private lateinit var viewAdapter: CarriersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = FragmentCarriersViewModel()
        viewModel.viewModel = this
        viewModel.initLoad()

        viewAdapter = CarriersAdapter(arrayListOf())

       // recyclerView.adapter = viewAdapter

        return inflater.inflate(R.layout.fragment_carriers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pullToRefresh = view.findViewById(R.id.fragment_carriers_swipe_to_refresh)
        recyclerView = view.findViewById(R.id.fragment_carriers_recycler_view)
        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        pullToRefresh.setOnRefreshListener {
            Toast.makeText(context, "Refreshed", Toast.LENGTH_SHORT).show()
            viewAdapter.notifyDataSetChanged()
            pullToRefresh.isRefreshing = false
        }
    }

    override fun onStart() {
        super.onStart()
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = viewAdapter
        recyclerView.itemAnimator = DefaultItemAnimator()
        viewAdapter.notifyDataSetChanged()
    }
}