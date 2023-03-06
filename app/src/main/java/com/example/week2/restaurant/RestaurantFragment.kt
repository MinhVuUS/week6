package com.example.week2.restaurant

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.week2.R
import com.example.week2.databinding.FragmentRestaurantBinding

import com.example.week2.singleonData.DataStore
import com.example.week2.viewModels.RestaurantViewModel

class RestaurantFragment : Fragment() {
    lateinit var binding: FragmentRestaurantBinding
    private lateinit var adapter: ResAdapter
    lateinit var viewModel: RestaurantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRestaurantBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this)[RestaurantViewModel::class.java]
        setUpRecyclerView()
        setUpViewModelObservers()
        return binding.root

    }
    private fun setUpViewModelObservers() {
        viewModel.menuLayoutType.observe(viewLifecycleOwner){
            binding.rvRestaurant.layoutManager = activity?.let { it1 -> viewModel.getLayout(it1) }
        }
    }

    private fun setUpRecyclerView() {
        binding.rvRestaurant.layoutManager = activity?.let { viewModel.getLayout(it) }
        adapter = ResAdapter()
        binding.rvRestaurant.adapter = adapter

        run {
            adapter.submitList(DataStore.restaurantData.value)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_item_avatar){
            val controller = findNavController()
            controller.navigate(R.id.action_restaurantFragment_to_profileFragment)
        }
        else
        viewModel.setLayout(item.itemId)

        return super.onOptionsItemSelected(item)
    }



    }
