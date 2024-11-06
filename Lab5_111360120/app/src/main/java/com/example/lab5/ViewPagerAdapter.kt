package com.example.lab5

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

// ViewPagerAdapter 繼承 FragmentStateAdapter 類別
// 傳遞 FragmentManager 和 Lifecycle 物件
class ViewPagerAdapter(
    fm: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {

    // 定義 Fragment 頁面列表，可以根據需要動態擴展
    private val fragmentList = listOf(FirstFragment(), SecondFragment(), ThirdFragment())

    // 回傳 Fragment 的數量，這裡可以根據 fragmentList 的大小來動態調整
    override fun getItemCount(): Int = fragmentList.size

    // 根據 position 位置回傳對應的 Fragment
    override fun createFragment(position: Int): Fragment {
        return fragmentList.getOrElse(position) { FirstFragment() } // 默認回傳 FirstFragment
    }
}
