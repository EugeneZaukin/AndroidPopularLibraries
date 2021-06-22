package com.eugene.androidpopularlibraries.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.eugene.androidpopularlibraries.App
import com.eugene.androidpopularlibraries.adapter.RepositoriesRVAdapter
import com.eugene.androidpopularlibraries.databinding.FragmentUserBinding
import com.eugene.androidpopularlibraries.model.GithubUser
import com.eugene.androidpopularlibraries.presenter.BackButtonListener
import com.eugene.androidpopularlibraries.presenter.UserPresenter
import com.eugene.androidpopularlibraries.view.UserView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {

    private var vb: FragmentUserBinding? = null
    private var adapter: RepositoriesRVAdapter? = null
    val presenter: UserPresenter by moxyPresenter {
        UserPresenter(arguments?.getParcelable<GithubUser>(USER) as GithubUser).apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun init() {
        vb?.rvRepos?.layoutManager = LinearLayoutManager(context)
        adapter = RepositoriesRVAdapter(presenter.reposListPresenter)
        vb?.rvRepos?.adapter = adapter
    }

    override fun setLogin(text: String) {
        vb?.userLoginText?.text = text
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()

    override fun onDestroyView() {
        vb = null
        adapter = null
        super.onDestroyView()
    }

    companion object {
        private const val USER = "USER"
        fun newInstance(user: GithubUser) =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(USER, user)
                }
            }
    }
}