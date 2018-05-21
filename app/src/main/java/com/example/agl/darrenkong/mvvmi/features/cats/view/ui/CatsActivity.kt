package com.example.agl.darrenkong.mvvmi.features.cats.view.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.agl.darrenkong.mvvmi.R
import com.example.agl.darrenkong.mvvmi.common.BaseActivity
import com.example.agl.darrenkong.mvvmi.features.cats.model.CatNameItem
import com.example.agl.darrenkong.mvvmi.features.cats.view.adapter.OwnersAndCatsListAdapter
import com.example.agl.darrenkong.mvvmi.features.cats.view.viewmodel.CatsViewModel
import com.example.agl.darrenkong.mvvmi.features.cats.view.viewmodel.CatsViewModelFactory
import dagger.android.AndroidInjection

import kotlinx.android.synthetic.main.activity_cats.*
import javax.inject.Inject

class CatsActivity : BaseActivity() {

    lateinit var viewModel: CatsViewModel

    @Inject
    lateinit var viewModelFactory: CatsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cats)

        //setup recyclerview
        list_cats.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CatsViewModel::class.java)

        viewModel.isLoading.observe(this, Observer<Boolean> { onLoading(it) })
        viewModel.sortedData.observe(this, Observer<List<CatNameItem>> { onResults(it) })
        viewModel.error.observe(this, Observer<Throwable> { onError(it) })

        get_cats_button.setOnClickListener({ _ ->
            viewModel.geCatsData()
        })
    }

    private fun onLoading(isLoading: Boolean?) {
        if (isLoading!!)
            Toast.makeText(this, "loading data", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "finished loading", Toast.LENGTH_SHORT).show()
    }

    private fun onResults(pets: List<CatNameItem>?) {
        //Simplified example that creates a new adapter every time a new list is retrieved.

        val adapter = pets?.let { OwnersAndCatsListAdapter(it) }

        //insert into adapter
        list_cats.adapter = adapter
    }

    private fun onError(error: Throwable?) {
        //todo: deal with errors, out of scope for this simplified example
    }
}
