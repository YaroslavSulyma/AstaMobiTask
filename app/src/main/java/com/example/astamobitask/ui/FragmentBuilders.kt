package com.example.astamobitask.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.astamobitask.R
import com.example.astamobitask.ui.carrierFragment.recycler.Adapter
import com.example.astamobitask.ui.carrierFragment.recycler.Data
import io.supercharge.shimmerlayout.ShimmerLayout

class FragmentBuilders : Fragment(), ItemsInterface {
    override fun loadFinished(response: ArrayList<Data>) {
        shimmerLayout.startShimmerAnimation()
        viewAdapter.update(response)
        shimmerLayout.stopShimmerAnimation()
        shimmerLayout.visibility = View.GONE
    }

    override fun loadError(error: String) {
        Toast.makeText(activity, error, Toast.LENGTH_LONG).show()
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var pullToRefresh: SwipeRefreshLayout
    private lateinit var viewAdapter: Adapter
    private lateinit var shimmerLayout: ShimmerLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel =
            ViewModelProviders.of(this)[FragmentBuildersViewModel::class.java] //FragmentCarriersViewModel()
        viewModel.viewModel = this
        viewModel.initLoad()

        viewAdapter = Adapter(arrayListOf())

        return inflater.inflate(R.layout.fragment_builders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pullToRefresh = view.findViewById(R.id.fragment_builders_swipe_to_refresh)
        recyclerView = view.findViewById(R.id.fragment_builders_recycler_view)
        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        shimmerLayout = view.findViewById(R.id.place_holder) as ShimmerLayout
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
