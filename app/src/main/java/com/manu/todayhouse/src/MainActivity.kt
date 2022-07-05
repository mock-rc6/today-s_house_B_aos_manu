package com.manu.todayhouse.src

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.manu.todayhouse.R
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityMainBinding
import com.manu.todayhouse.src.main.home.HomeFragment
import com.manu.todayhouse.src.main.homeservice.HomeServiceFragment
import com.manu.todayhouse.src.main.mypage.MyPageFragment
import com.manu.todayhouse.src.main.plus.PlusFragment
import com.manu.todayhouse.src.main.store.StoreFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val fragmentOne by lazy { HomeFragment() }
    private val fragmentTwo by lazy { StoreFragment() }
    private val fragmentThree by lazy { HomeServiceFragment() }
    private val fragmentFour by lazy { MyPageFragment() }
    private val fragmentFive by lazy { PlusFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigationBar()


    }

    fun initNavigationBar() {

        binding.mainBtmNavigation.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.home_btn -> {
                        changeFragment(fragmentOne)

                    }
                    R.id.store_btn -> {
                        changeFragment(fragmentTwo)

                    }

                    R.id.home_service_btn -> {
                        changeFragment(fragmentThree)


                    }

                    R.id.mypage_btn -> {
                        changeFragment(fragmentFour)


                    }

                    R.id.main_btm_plus_button -> {
                        changeFragment(fragmentFive)


                    }

                }
                true
            }
            selectedItemId = R.id.home_btn
        }
    }

    private fun changeFragment(fragment: androidx.fragment.app.Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.btm_frg_view, fragment)
            .commit()
    }

}
