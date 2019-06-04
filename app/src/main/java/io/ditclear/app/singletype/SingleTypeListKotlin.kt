package io.ditclear.app.singletype

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import io.ditclear.app.R
import io.ditclear.app.databinding.ListFragmentBinding
import io.ditclear.bindingadapterx.ItemClickPresenter
import io.ditclear.bindingadapterx.SingleTypeAdapter
import java.util.*

/**
 * 页面描述：PartialRefreshListKotlin
 *
 * Created by ditclear on 2017/12/2.
 */
class SingleTypeListKotlin : AppCompatActivity(), ItemClickPresenter<User> {

    override fun onItemClick(v: View, item: User) {
        item.photoUrl = "http://cdn.duitang.com/uploads/item/201610/03/20161003000301_Wfm5X.jpeg"
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
    }

    val dataSource = ObservableArrayList<User>()

    val mBinding by lazy { DataBindingUtil.setContentView<ListFragmentBinding>(this, R.layout.list_fragment) }

    val mAdapter by lazy {
        SingleTypeAdapter<User>(this, R.layout.list_item, dataSource).apply {
            itemPresenter = this@SingleTypeListKotlin
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        mBinding.recyclerView.adapter = mAdapter
        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mBinding.recyclerView.setItemViewCacheSize(0)
        mBinding.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        (0..6).map {
            User().apply {
                photoUrl = "http://b-ssl.duitang.com/uploads/item/201506/07/20150607010301_tKkQa.jpeg"
                name = "Item $it"
                sex = "女"
            }
        }.let {
            dataSource.addAll(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val randomIndex = Random().nextInt(if (dataSource.isNotEmpty()) dataSource.size else 1)
        when (item?.itemId) {
            R.id.add_item -> dataSource.add(randomIndex, User().apply {
                photoUrl = "http://cdn.duitang.com/uploads/item/201610/03/20161003000301_Wfm5X.jpeg"
                name = "Added Item $randomIndex"
                sex = "女"
            })
            R.id.remove_item -> {
                if (dataSource.isNotEmpty()) dataSource.removeAt(randomIndex)
                else Toast.makeText(this, "没数据了", Toast.LENGTH_SHORT).show()
            }
            R.id.clear_all -> dataSource.clear()
        }
        return super.onOptionsItemSelected(item)
    }
}