package com.emira.fragment

import com.emira.kcomplete.R

class ManualFragment: BaseFragment() {
    override val logTag = "KComplete - Manual fragment"
    override fun getLayout(): Int {
        return R.layout.fragment_manual
    }
}