package com.erdin.arkaandroidtwo.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erdin.arkaandroidtwo.R
import com.erdin.arkaandroidtwo.databinding.ActivityProjectListBinding
import com.erdin.arkaandroidtwo.project.ProjectListAdapter
import com.erdin.arkaandroidtwo.project.ProjectModel
import com.erdin.arkaandroidtwo.project.ProjectsApiService
import com.erdin.arkaandroidtwo.remote.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

class ProjectActivity : AppCompatActivity(), ProjectContract.View {
    private lateinit var binding: ActivityProjectListBinding
    private lateinit var coroutineScope: CoroutineScope
    private var presenter: ProjectPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_project_list)
        coroutineScope = CoroutineScope(Job() + Dispatchers.Main)
        val service = ApiClient.getApiClient()?.create(ProjectsApiService::class.java)

        presenter = ProjectPresenter(coroutineScope, service)

        binding.recyclerView.adapter = ProjectListAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    }

    override fun addListProject(list: List<ProjectModel>) {
        (binding.recyclerView.adapter as ProjectListAdapter).addList(list)
    }

    override fun showProgressBar() {
        // Action show progress bar
    }

    override fun onStart() {
        super.onStart()
        presenter?.bindToView(this)
        presenter?.callProjectApi()
    }

    override fun onStop() {
        presenter?.unbind()
        super.onStop()
    }

    override fun onDestroy() {
        coroutineScope.cancel()
        presenter = null
        super.onDestroy()
    }

}