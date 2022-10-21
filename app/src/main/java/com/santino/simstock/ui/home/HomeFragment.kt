package com.santino.simstock.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.santino.simstock.data.models.Company
import com.santino.simstock.data.service.TokenService
import com.santino.simstock.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null
    private var homeAdapter: HomeAdapter? = null

    private val token: TokenService by inject()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*
    * Setup observers
    * */
    private fun setupObservers() {
        if (token.isFirstAccess()) {
            token.setFirstAccess(false)
            viewModel.initCompanyData()
        } else {
            viewModel.loadCompanies()
        }
        viewModel.listCompanies.observe(viewLifecycleOwner, ::fillCompanyAdapter)
        viewModel.loadState.observe(viewLifecycleOwner, ::showProgress)
    }


    /*
    *  Setup listeners events
    * */
    private fun setupListeners() {
        //binding.btnSortUp.setOnClickListener {  }
        //binding.btnSortDown.setOnClickListener {  }
        binding.btnUpdate.setOnClickListener {
            viewModel.updateCompanyData()
        }
    }

    private fun fillCompanyAdapter(listCompanies: List<Company>) {
        homeAdapter = HomeAdapter(listCompanies)
        binding.rvCompanies.adapter = homeAdapter
        binding.rvCompanies.layoutManager = LinearLayoutManager(context)
    }

    private fun showViews() {
        /*binding.apply {
            //homeLayout.visibility = View.GONE
            homeLayout.animate().alpha(1.0f).duration = 500
            progressBar.visibility = View.GONE
        }*/
    }

    private fun hideViews() {
        /*binding.apply {
            //homeLayout.visibility = View.VISIBLE
            homeLayout.animate().alpha(0.0f).duration = 500
            progressBar.visibility = View.VISIBLE

        }*/
    }

    private fun showProgress(visible: Boolean) {
        binding.progressBar.isVisible = visible
    }
}