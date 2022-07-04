package com.manu.todayhouse.src.main.mypage.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentProfileBinding
import com.manu.todayhouse.src.main.home.popluar.PopluarService
import com.manu.todayhouse.src.main.mypage.profile.model.UserMyPageData


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::bind, R.layout.fragment_profile), ProfileFragmentInterface {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MyProfileService(this@ProfileFragment).getBannerImage()

    }

    override fun onGetMyProfileSuccess(response: UserMyPageData) {

        val result = response.result


//        Glide.with(this@ProfileFragment).load(response.result?.profilePic).into(binding.profileImg)
//        binding.myIdText.text = response.result?.name
//        binding.followerCount.text = result.followers?.toString()
//        binding.followingCount.text = result.follows?.toString()
    }

    override fun onGetMyProfileeFail(message: String) {
        showCustomToast("오류 : ${message}")
    }

}