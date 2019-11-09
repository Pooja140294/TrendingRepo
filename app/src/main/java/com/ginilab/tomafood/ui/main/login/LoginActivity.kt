package com.ginilab.tomafood.ui.main.login

import android.os.Bundle
import com.ginilab.tomafood.R
import com.ginilab.tomafood.base.contract.FragmentNavigation
import com.ginilab.tomafood.ui.main.login.loginfragment.LoginFragment
import com.ginilab.tomafood.ui.main.login.signupfragment.SignUpFragment

class LoginActivity : AbstractLoginActivity(), FragmentNavigation{

    override fun getLayoutRes(): Int = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // startFragment(this, R.id.fragmentLayout, SignUpFragment())
   //     supportFragmentManager.beginTransaction().replace(R.id.fragmentLayout, SignUpFragment()).commit()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentLayout,
                    SignUpFragment()
                )
                .commitNow()
        }
    }

}
