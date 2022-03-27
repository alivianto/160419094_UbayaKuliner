package com.ubaya.a160419094_ubayakuliner.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ubaya.a160419094_ubayakuliner.GlobalData
import com.ubaya.a160419094_ubayakuliner.R
import com.ubaya.a160419094_ubayakuliner.util.loadImage
import com.ubaya.a160419094_ubayakuliner.viewmodel.RestaurantDetailViewModel
import kotlinx.android.synthetic.main.fragment_restaurant_about.*

/**
 * A simple [Fragment] subclass.
 * Use the [RestaurantAboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestaurantAboutFragment : Fragment() {
    private lateinit var viewModel: RestaurantDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_about, container, false)
    }
    var restoID = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        restoID = GlobalData.restoID

        viewModel = ViewModelProvider(this).get(RestaurantDetailViewModel::class.java)
        viewModel.fetch(restoID)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.restaurantDetailLiveData.observe(viewLifecycleOwner) {
            val restaurantDetail = viewModel.restaurantDetailLiveData.value
            restaurantDetail?.let{
                for(item in it) {
                    if(item.id == restoID){
                        textRestoName.text = item.name
                        textRestoAddress.text = "Address: ${item.address}"
                        textRestoRating.text = item.rating
                        imageViewRestoDetailPhoto.loadImage(item.photo, progressBarRestoDetailPhoto)

                        textMondayOH.text = item.opening_hours.monday
                        textTuesdayOH.text = item.opening_hours.tuesday
                        textWednesdayOH.text = item.opening_hours.wednesday
                        textThursdayOH.text = item.opening_hours.thursday
                        textFridayOH.text = item.opening_hours.friday
                        textSaturdayOH.text = item.opening_hours.saturday
                        textSundayOH.text = item.opening_hours.sunday
                    }
                }
            }
        }
    }
}