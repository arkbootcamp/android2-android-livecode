package com.erdin.arkaandroidtwo.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erdin.arkaandroidtwo.R
import com.erdin.arkaandroidtwo.databinding.ActivityProjectListBinding
import com.erdin.arkaandroidtwo.remote.ApiClient
import kotlinx.coroutines.*
import kotlin.math.log

class ProjectListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProjectListBinding
    private lateinit var coroutineScope: CoroutineScope
    private lateinit var service: ProjectsApiService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_project_list)
        coroutineScope = CoroutineScope(Job() + Dispatchers.Main)
        service = ApiClient.getApiClient()!!.create(ProjectsApiService::class.java)

        binding.recyclerView.adapter = ProjectListAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        getAllProject()
    }

    private fun getAllProject() {
        coroutineScope.launch {
            Log.d("android2", "Start: ${Thread.currentThread().name}")

            val result = withContext(Dispatchers.IO) {
                Log.d("android2", "CallApi: ${Thread.currentThread().name}")
                try {
                    service?.getAllProject()
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }

            if (result is ProjectResponse) {
                Log.d("android2", result.toString())
                val list = result.data?.map{
                    ProjectModel(it.projectId, it.projectName, it.projectDesc, it.projectType)
                }

                (binding.recyclerView.adapter as ProjectListAdapter).addList(list)
            }

        }

    }

    override fun onDestroy() {
        coroutineScope.cancel()
        super.onDestroy()
    }
}