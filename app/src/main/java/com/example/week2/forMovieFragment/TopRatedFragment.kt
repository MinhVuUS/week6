//package com.example.week2.forMovieFragment
//
//import android.os.Bundle
//import android.view.*
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProvider
//import androidx.navigation.fragment.findNavController
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.week2.R
////import com.example.week2.bottomNavigation.BottomActivity
//import com.example.week2.bottomNavigation.MovieAdapter
//import com.example.week2.databinding.FragmentTopRatedBinding
//import com.example.week2.databinding.MovieItemBinding
//import com.example.week2.viewModels.TopRatedVM
//
//class TopRatedFragment : Fragment() {
//    private lateinit var recyclerView: RecyclerView
//    lateinit var binding: FragmentTopRatedBinding
//    lateinit var vm: TopRatedVM
//    lateinit var adapter: MovieAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        setHasOptionsMenu(true)
//        super.onCreate(savedInstanceState)
//
//    }
//
//
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentTopRatedBinding.inflate(inflater,container,false)
//        vm = ViewModelProvider(this).get(TopRatedVM::class.java)
////        registerMovieList()
////        onStart()
//        return binding.root
//    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setUpMovieList()
//        registerMovieList()
//    }
//
//    override fun onStart() {
//        super.onStart()
//        vm.getTopRated()
//    }
//
//    private fun registerMovieList() {
//
//        val lm = LinearLayoutManager(context)
//        binding.rvTopRated.layoutManager = lm
//        binding.rvTopRated.adapter = adapter
//    }
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.menu, menu)
//        super.onCreateOptionsMenu(menu, inflater)
//
//    }
//    private fun setUpMovieList() {
//    vm.movieData.observe(viewLifecycleOwner){
//        adapter.submitList(it)
//    }
//    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        if (item.itemId == R.id.menu_item_avatar){
//            val controller = findNavController()
//            controller.navigate(R.id.action_nowPlayingFragment2_to_profileFragment)
//        }
//        else
//            vm.setLayout(item.itemId)
//        return super.onOptionsItemSelected(item)
//
//
//////        return when (item.itemId){
////            R.id.menu_linear -> {
//////                adapter = MovieAdapter()
////                val lm = LinearLayoutManager(context)
////                binding.rvTopRated.layoutManager = lm
////                binding.rvTopRated.adapter = adapter
////                onStart()
////                true
////            }
////            R.id.menu_grid -> {
//////                adapter = MovieAdapter()
////                val lm = GridLayoutManager(context,3)
////                binding.rvTopRated.layoutManager = lm
////                binding.rvTopRated.adapter = adapter
////                onStart()
////                true
////            }
////            else -> return super.onOptionsItemSelected(item)
//        }
//    }
//
