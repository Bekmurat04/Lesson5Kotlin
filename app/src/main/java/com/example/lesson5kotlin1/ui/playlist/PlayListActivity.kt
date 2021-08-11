package com.example.lesson5kotlin1.ui.playlist

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lesson5kotlin1.R
import com.example.lesson5kotlin1.base.BaseActivity
import com.example.lesson5kotlin1.ui.disconnect.NetworkActivity
import com.example.lesson5kotlin1.ui.videos.VideoActivity
import com.example.youtubeparser27.ui.disconnect.NetworkCheker
import kotlinx.android.synthetic.main.activity_main.*

class PlayListActivity : BaseActivity(R.layout.activity_main), PlayListAdapter.PlayListClickListener {

    private var viewModel: PlayListViewModel? = null

    private var playListAdapter = PlayListAdapter()

    private lateinit var networkCheker: NetworkCheker


    override fun showDisconnectState() {
        networkCheker = NetworkCheker(this)
        if (!networkCheker.isNetworkAvaible(this)) {
            startActivity(Intent(this, NetworkActivity::class.java))
        }
        networkCheker.observe(this, Observer {
            if (it) {
                setUpLiveData()
            } else {
                startActivity(Intent(this, NetworkActivity::class.java))
            }
        })
    }

    override fun setUpUI() {
        viewModel = ViewModelProvider(this).get(PlayListViewModel::class.java)
        playListAdapter.addListener(this)
        res_View.adapter = playListAdapter

    }

    override fun setUpLiveData() {
        viewModel?.fetchPlayList()?.observe(this, {
            Toast.makeText(this, it?.kind.toString(), Toast.LENGTH_SHORT).show()
            if (it != null) {
                playListAdapter.addItems(it)
            }
        })
    }

    override fun itemClick(id: String) {
        var intent:Intent = Intent(this,VideoActivity::class.java)
        intent.putExtra("key",id)
        startActivity(intent)
    }


}