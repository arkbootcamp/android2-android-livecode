package com.erdin.arkaandroidtwo.mvp

import com.erdin.arkaandroidtwo.project.ProjectModel
import com.erdin.arkaandroidtwo.project.ProjectResponse
import com.erdin.arkaandroidtwo.project.ProjectsApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProjectPresenter(private val coroutineScope: CoroutineScope,
                       private val service: ProjectsApiService?) : ProjectContract.Presenter {

    private var view: ProjectContract.View? = null

    override fun bindToView(view: ProjectContract.View) {
        this.view = view
    }

    override fun unbind() {
        this.view = null
    }

    override fun callProjectApi() {
        coroutineScope.launch {
            val result = withContext(Dispatchers.IO) {
                try {
                    service?.getAllProject()
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }

            if (result is ProjectResponse) {
                view?.showProgressBar()
                val list = result.data?.map{
                    ProjectModel(it.projectId, it.projectName, it.projectDesc, it.projectType)
                }

                view?.addListProject(list)
            }

        }
    }
}