package io.ditclear.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import io.ditclear.app.databinding.MainActivityBinding
import io.ditclear.app.multitype.MultiTypeListKotlin
import io.ditclear.app.partial.PartialRefreshListKotlin
import io.ditclear.app.singletype.SingleTypeListKotlin

class MainActivity : AppCompatActivity(), MainPresenter {

    override fun onClickSingle(v: View?) {
        startActivity(Intent(this, SingleTypeListKotlin::class.java))    }

    override fun onMultiple(v: View?) {
        startActivity(Intent(this, MultiTypeListKotlin::class.java))
    }

    override fun onPartialRefresh(v: View?) {
        startActivity(Intent(this, PartialRefreshListKotlin::class.java))    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)
        binding.presenter = this

    }

    fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
