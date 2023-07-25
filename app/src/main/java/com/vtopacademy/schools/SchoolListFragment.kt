package com.vtopacademy.schools

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vtopacademy.databinding.FragmentSchoolListBinding
import com.vtopacademy.viewmodel.MainViewModel
import com.vtopacademy.viewmodel.MainViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

/** Fragment for showing showing schools. */
@AndroidEntryPoint
class SchoolListFragment: Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var schoolAdapter: SchoolAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var binding: FragmentSchoolListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSchoolListBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(this)[MainViewModelImpl::class.java]
        mainViewModel.getSchoolListUiState().observe(viewLifecycleOwner) { result ->
            if (result.isFetchingSchools) {
                progressBar.visibility = View.VISIBLE
            } else {
                updateUI(result.schools)
                progressBar.visibility = View.GONE
            }
        }
    }

    private fun updateUI(schools: MutableList<School>){
        schoolAdapter = SchoolAdapter(schools) { school -> onItemClick(school) }
        recyclerView.adapter = schoolAdapter
    }

    private fun onItemClick(school: School){
        mainViewModel.setSelectedSchool(school)
        navigateToKclassListFragment()
    }

    private fun navigateToKclassListFragment(){
        //val action = SchoolListFragmentDirections
        //        .actionSchoolListFragmentToKclassListFragment();
        // binding.root.findNavController().navigate(action)
    }
}