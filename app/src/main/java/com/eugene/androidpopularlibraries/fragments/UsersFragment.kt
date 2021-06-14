package com.eugene.androidpopularlibraries.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.eugene.androidpopularlibraries.App
import com.eugene.androidpopularlibraries.adapter.UsersRVAdapter
import com.eugene.androidpopularlibraries.api.ApiHolder
import com.eugene.androidpopularlibraries.api.GlideImageLoader
import com.eugene.androidpopularlibraries.databinding.FragmentUsersBinding
import com.eugene.androidpopularlibraries.model.RetrofitGithubUsersRepo
import com.eugene.androidpopularlibraries.presenter.BackButtonListener
import com.eugene.androidpopularlibraries.presenter.UsersPresenter
import com.eugene.androidpopularlibraries.view.UsersView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }

    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            RetrofitGithubUsersRepo(ApiHolder.api),
            App.instance.router,
            AndroidSchedulers.mainThread()
        )
    }
    private var adapter: UsersRVAdapter? = null
    private var vb: FragmentUsersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUsersBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onDestroyView() {
        vb = null
        adapter = null
        super.onDestroyView()
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter, GlideImageLoader())
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}