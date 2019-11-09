package com.ginilab.tomafood.base.contract

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.transaction
import com.ginilab.tomafood.base.core.BaseActivity
import com.ginilab.tomafood.base.core.BaseFragment
import com.ginilab.tomafood.base.core.PlainActivity
import com.ginilab.tomafood.base.core.PlainFragment

interface FragmentNavigation {

    fun startFragment(
        activity: PlainActivity,
        @IdRes contentId: Int,
        newFragment: BaseFragment<*>,
        addToBackstack: Boolean = true,
        withAnimation: Boolean = true,
        isAddFragment: Boolean = false
    ) {
        //with Animation
        activity.supportFragmentManager.transaction {
            if (withAnimation) setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

            //with Add Fragment
            if (isAddFragment) {
                add(contentId, newFragment, newFragment.fragmentTag())
            }else{
                replace(contentId, newFragment, newFragment.fragmentTag())
            }

            if (addToBackstack) addToBackStack(newFragment.fragmentTag())
        }
    }

    fun startWithClearBackStack(activity: BaseActivity<*>,
                                @IdRes contentId: Int,
                                newFragment: PlainFragment){

        val destinatioFragment: Fragment?
        with(activity.supportFragmentManager){

            destinatioFragment = findFragmentByTag(newFragment.fragmentTag())
            destinatioFragment?.arguments= newFragment.arguments
        }

        activity.supportFragmentManager.transaction {

            setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)

            for (fragment in activity.supportFragmentManager.fragments){
                detach(fragment)
            }

            if (destinatioFragment != null){
                attach(destinatioFragment)
            }else{
                replace(contentId, newFragment, newFragment.fragmentTag())
            }
        }
    }

    //uncomment for showing the base dilog
/*

    fun showDialog(activity: BaseActivity<*>, newFragment: BaseDialogFragment<*>) {
        newFragment.show(activity.supportFragmentManager, newFragment.fragmentTag())
    }
*/
}