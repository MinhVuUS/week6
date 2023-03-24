//package com.example.week2.forMovieFragment
//
//import android.os.Bundle
//import android.util.Log
//import android.view.*
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProvider
//import androidx.navigation.fragment.findNavController
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.week2.R
//
//import com.example.week2.bottomNavigation.MovieAdapter
//
//import com.example.week2.databinding.FragmentNowPlayingBinding
//import com.example.week2.model.Movie
//import com.example.week2.profile.ProfileFragment
//import com.example.week2.viewModels.NowPlayingVM
//
//class NowPlayingFragment : Fragment() {
//    private lateinit var recyclerView: RecyclerView
//    lateinit var binding: FragmentNowPlayingBinding
//    lateinit var vm: NowPlayingVM
//    lateinit var adapter: MovieAdapter
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        setHasOptionsMenu(true)
//        super.onCreate(savedInstanceState)
//
//        Log.d("string", "OK")
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentNowPlayingBinding.inflate(inflater, container, false)
//        vm = ViewModelProvider(this).get(NowPlayingVM::class.java)
////        registerMovieList()
////        onStart()
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setUpMovieList()
//        registerMovieList()
//    }
//
//    override fun onStart() {
//        super.onStart()
//        vm.getNowPlaying()
//    }
//
//    private fun registerMovieList() {
//
//        val lm = LinearLayoutManager(context)
//        binding.rvNowPlaying.layoutManager = lm
//        binding.rvNowPlaying.adapter = adapter
//    }
//
//    private fun setUpMovieList() {
//        vm.movieData.observe(viewLifecycleOwner) {
//            adapter.submitList(it)
//        }
//    }
//
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.menu, menu)
//        super.onCreateOptionsMenu(menu, inflater)
//
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//                if (item.itemId == R.id.menu_item_avatar){
//            val controller = findNavController()
//            controller.navigate(R.id.action_restaurantFragment_to_profileFragment)
//        }
//        else
//        vm.setLayout(item.itemId)
//        return super.onOptionsItemSelected(item)
//
//
////        return when (item.itemId) {
////            R.id.menu_linear -> {
////
////                val lm = LinearLayoutManager(context)
////                binding.rvNowPlaying.layoutManager = lm
////                binding.rvNowPlaying.adapter = adapter
////                onStart()
////                true
////            }
////            R.id.menu_grid -> {
////
////                val lm = GridLayoutManager(context, 3)
////                binding.rvNowPlaying.layoutManager = lm
////                binding.rvNowPlaying.adapter = adapter
////                onStart()
////                true
////            }
////            else -> controller.navigate(R.id.action_nowPlayingFragment2_to_profileFragment)
////
////
////        }
//
//    }
//}
//
//
//
//
