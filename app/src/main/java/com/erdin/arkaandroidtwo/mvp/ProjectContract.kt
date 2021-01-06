package com.erdin.arkaandroidtwo.mvp

import com.erdin.arkaandroidtwo.project.ProjectModel

interface ProjectContract {

    interface View {
        fun addListProject(list: List<ProjectModel>)
        fun showProgressBar()
    }

    interface Presenter {
        fun bindToView(view: View)
        fun unbind()
        fun callProjectApi()
    }

}