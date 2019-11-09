package com.ginilab.tomafood.ui.main.kishan


import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.ginilab.tomafood.R
import com.ginilab.tomafood.base.common.Cell
import com.ginilab.tomafood.model.TrendingResponse
import com.ginilab.tomafood.ui.main.kishan.adapter.TrendingAdapter
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : AbstractMainFragment(), TrendingAdapter.CellListener {
    override fun onCellClick(cell: Cell) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutRes() = R.layout.main_fragment

    private lateinit var trendingAdapter: TrendingAdapter

    private lateinit var shimmer: ShimmerFrameLayout
    private lateinit var toolbar: Toolbar
    private lateinit var trendingList: List<TrendingResponse>
    private lateinit var swipeRefresh: SwipeRefreshLayout


    companion object {
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

   /* override fun viewInitialization(view: View) {
        super.viewInitialization(view)
        initViews(view)
        setToolbar()
        setSwipeRefresh()
        setAdapter()
    }

    private fun initViews(view: View) {
        toolbar = view.findViewById(R.id.my_toolbar)
        swipeRefresh = view.findViewById(R.id.swipe_refresh_layout)
        shimmer = view.findViewById(R.id.shimmer_view_container)
    }

    private fun setSwipeRefresh() {
        swipeRefresh.setOnRefreshListener {
            fetchData("kotlin")
            swipeRefresh.isRefreshing = false
        }
    }

    private fun setToolbar() {
        toolbar.inflateMenu(R.menu.navigation)
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_sort_name -> sortByName()
                R.id.action_sort_star -> sortByStars()
            }
            true
        }
    }


    private fun sortByStars() {
        val starSortedList = trendingList.sortedWith(compareBy { it.stars })
        setTrendingData(starSortedList)
    }

    private fun sortByName() {
        val nameSortedList = trendingList.sortedWith(compareBy { it.name })
        setTrendingData(nameSortedList)
    }

    override fun onPause() {
        super.onPause()
        shimmer.stopShimmerAnimation()
    }


    private fun setAdapter() {
        trendingAdapter =
            TrendingAdapter(listOf(), this)
        with(trendingRecycler) {
            adapter = trendingAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    override fun setTrendingData(list: List<TrendingResponse>) {
        trendingList = list
        trendingAdapter.run {
            items = trendingList
            notifyDataSetChanged()
        }
    }

    override fun showLoadingState(loading: Boolean) {
        if (loading) {
            shimmer.startShimmerAnimation()
        } else {
            shimmer.stopShimmerAnimation()
            shimmer.visibility = View.GONE
        }
    }

    override fun onCellClick(cell: Cell) {
    }

*/}
