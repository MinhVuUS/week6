package com.example.week2.restaurant

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.week2.R
import com.example.week2.databinding.FragmentRestaurantBinding
//import com.example.week2.forMovieFragment.NowPlayingFragment
//import com.example.week2.forMovieFragment.TopRatedFragment
import com.example.week2.model.Movie

import com.example.week2.singleonData.DataStore
import com.example.week2.viewModels.RestaurantViewModel

//class RestaurantFragment : Fragment() {
//    lateinit var binding: FragmentRestaurantBinding
//    lateinit var adapter: ResAdapter
//    lateinit var viewModel: RestaurantViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        setHasOptionsMenu(true)
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//        }
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_restaurant,false)
//        binding.lifecycleOwner = this
////        viewModel = ViewModelProvider(this)[RestaurantViewModel::class.java]
////        setUpRecyclerView()
////        setUpViewModelObservers()
//        viewModel = ViewModelProvider(this)[RestaurantViewModel::class.java]
//        return binding.root
//
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val controller = findNavController()
////        replaceFragment(NowPlayingFragment())
//        binding.bottomNavigationView.setOnItemSelectedListener {
//            viewModel.setTabID(it.itemId)
//            true
////            when (it.itemId) {
////                R.id.nplaying -> controller.navigate(R.id.action_restaurantFragment_to_nowPlayingFragment2)
////                R.id.trated -> controller.navigate(R.id.action_restaurantFragment_to_topRatedFragment)
////                else -> {
////                }
////            }
////            true
//      }
//        setUpRecyclerView()
//        setUpViewModelObservers()
//    }
//
//    private fun setUpViewModelObservers() {
//        viewModel.menuLayoutType.observe(viewLifecycleOwner){
//            binding.rvRestaurant.layoutManager = activity?.let { it1 -> viewModel.getLayout(it1) }
//        }
//        viewModel.newList.observe(viewLifecycleOwner){
//            adapter.submitList(it)
//        }
//    }
//
//    private fun setUpRecyclerView() {
//        binding.rvRestaurant.layoutManager = activity?.let { viewModel.getLayout(it) }
//        adapter = ResAdapter()
//        binding.rvRestaurant.adapter = adapter
//
//        run {
//            adapter.submitList(DataStore.restaurantData.value)
//        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.menu, menu)
//        super.onCreateOptionsMenu(menu, inflater)
//
//    }
////    fun replaceFragment(fragment: Fragment) {
////        val fragmentManager = supportFragmentManager
////        val fragmentTransaction = fragmentManager.beginTransaction()
////        fragmentTransaction.replace(R.id.frame_layout, fragment)
////        fragmentTransaction.addToBackStack(null)
////        fragmentTransaction.commit()
////    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
////        if (item.itemId == R.id.menu_item_avatar){
////            val controller = findNavController()
////            controller.navigate(R.id.action_restaurantFragment_to_profileFragment)
////        }
////        else
////        viewModel.setLayout(item.itemId)
//
//        return super.onOptionsItemSelected(item)
//    }
//    override fun onResume() {
//        super.onResume()
//        (activity as AppCompatActivity?)!!.supportActionBar?.show()
//        (activity as AppCompatActivity?)!!.supportActionBar?.title = "My movies"
//    }
//
//    override fun onPause() {
//        super.onPause()
//        (activity as AppCompatActivity?)!!.supportActionBar?.hide()
//    }
//    override fun onDestroy() {
//        super.onDestroy()
//        (activity as AppCompatActivity?)!!.supportActionBar?.hide()
//    }
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @return A new instance of fragment RestaurantFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance() =
//            RestaurantFragment().apply {
//                arguments = Bundle().apply {
//                }
//            }
//    }
//
//
//
//    }
class RestaurantFragment : Fragment() {
    lateinit var binding: FragmentRestaurantBinding
    lateinit var adapter: ResAdapter
    lateinit var viewModel: RestaurantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_restaurant, container, false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[RestaurantViewModel::class.java]

        // Inflate the layout for this fragment

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigationView.setOnItemSelectedListener {
            viewModel.setTabID(it.itemId)
            true
        }
        setUpRecyclerView()
        setUpViewModelObservers()
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar?.show()
        (activity as AppCompatActivity?)!!.supportActionBar?.title = "My movies"
    }

    override fun onPause() {
        super.onPause()
        (activity as AppCompatActivity?)!!.supportActionBar?.hide()
    }
    override fun onDestroy() {
        super.onDestroy()
        (activity as AppCompatActivity?)!!.supportActionBar?.hide()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment RestaurantFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            RestaurantFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private fun setUpViewModelObservers() {
        viewModel.menuLayoutType.observe(viewLifecycleOwner){
            binding.rvRestaurant.layoutManager = activity?.let { it1 -> viewModel.getLayout(it1) }
        }

        viewModel.newList.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        viewModel.tabID.observe(viewLifecycleOwner){
            viewModel.getMovies()
        }
    }

    private fun setUpRecyclerView() {
        binding.rvRestaurant.layoutManager = activity?.let { viewModel.getLayout(it) }
        adapter = ResAdapter(onRestaurantItemClick)
        binding.rvRestaurant.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.menu_linear -> viewModel.setLayout(item.itemId)
            R.id.menu_grid -> viewModel.setLayout(item.itemId)
            R.id.menu_item_avatar -> {
                val controller = findNavController()
                controller.navigate(R.id.action_restaurantFragment_to_profileFragment)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private val onRestaurantItemClick = object : OnHomeItemClick{
        override fun onClickItem(item: View, restaurant: Movie) {
            val controller = findNavController()
            viewModel.handleItemWhenClicked(item, restaurant, controller)

        }

        override fun onLongClick(item: View) {
            viewModel.handleItemWhenLongClicked(item)
        }
    }

}