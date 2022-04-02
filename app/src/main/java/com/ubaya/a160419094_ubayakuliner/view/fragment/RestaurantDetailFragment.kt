package com.ubaya.a160419094_ubayakuliner.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Adapter
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.ubaya.a160419094_ubayakuliner.GlobalData
import com.ubaya.a160419094_ubayakuliner.R
import com.ubaya.a160419094_ubayakuliner.view.adapter.RestaurantMenuAdapter
import com.ubaya.a160419094_ubayakuliner.view.adapter.ViewPagerAdapter
import com.ubaya.a160419094_ubayakuliner.viewmodel.RestaurantDetailViewModel
import com.ubaya.a160419094_ubayakuliner.viewmodel.RestaurantMenusListViewModel
import kotlinx.android.synthetic.main.fragment_restaurant_detail.*
import kotlinx.android.synthetic.main.fragment_restaurant_list.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [RestaurantDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestaurantDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_detail, container, false)
    }
    var restoID = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        GlobalData.currentFragment = "RestaurantDetailFragment"
        viewPagerRestaurantDetail.adapter = ViewPagerAdapter(parentFragmentManager, lifecycle)

        TabLayoutMediator(tabLayoutRestaurant, viewPagerRestaurantDetail) { tab, position ->
            when(position){
                0->{
                    tab.text = "About"
                }
                1->{
                    tab.text = "Menu"
                }
                2->{
                    tab.text = "Reviews"
                }
            }
        }.attach()

        arguments?.let{
            restoID = RestaurantDetailFragmentArgs.fromBundle(requireArguments()).restaurantID
        }
        GlobalData.restoID = restoID

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_bookmark, menu)
        val item = menu?.findItem(R.id.itemBookmark)

        return super.onCreateOptionsMenu(menu, inflater)
    }
}