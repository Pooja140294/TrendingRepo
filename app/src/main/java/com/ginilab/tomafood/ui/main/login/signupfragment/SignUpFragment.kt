package com.ginilab.tomafood.ui.main.login.signupfragment

import android.view.View
import android.widget.Button
import android.widget.EditText

import com.ginilab.tomafood.R
import com.ginilab.tomafood.base.extensions.showLongToast
import com.ginilab.tomafood.ui.main.login.response.SignUp
import com.ginilab.tomafood.ui.main.login.response.SignUpResponse
import com.ginilab.tomafood.ui.main.login.response.UserDataSignUp
import org.json.JSONObject
import timber.log.Timber

class SignUpFragment : AbstractSignUpFragment() {

    private lateinit var et_firstName: EditText
    private lateinit var et_lastName: EditText
    private lateinit var et_phone: EditText
    private lateinit var et_email: EditText
    private lateinit var et_password: EditText
    private lateinit var btn_SignUp: Button

    override fun getLayoutRes(): Int = R.layout.fragment_signup

    override fun viewInitialization(view: View) {

        initView(view)

        setListeners()

    }

    private fun initView(view: View) {

        et_firstName = view.findViewById(R.id.et_FirstName)
        et_lastName = view.findViewById(R.id.et_LastName)
        et_email = view.findViewById(R.id.et_Email)
        et_phone = view.findViewById(R.id.et_Phone)
        et_password = view.findViewById(R.id.et_Password)
        btn_SignUp = view.findViewById(R.id.btn_SignUp)
    }

    private fun setListeners() {
        btn_SignUp.setOnClickListener {

            if (et_firstName.text.isNullOrEmpty() || et_lastName.text.isNullOrEmpty() || et_email.text.isNullOrEmpty() || et_phone.text.isNullOrEmpty() || et_password.text.isNullOrEmpty()) {

                activity?.showLongToast("Required Field Missing !")
            } else {


                fetchLoginData(
                    UserDataSignUp(
                        SignUp(et_firstName.text.toString(), et_lastName.text.toString(), et_email.text.toString(),
                    et_phone.text.toString(), et_password.text.toString())
                    )
                )
            }

            }
        }


    override fun setSignUpData(data: SignUpResponse) {

        Timber.tag("LOGIN FRAGMENT").d(data.user.toString())
    }

    override fun showLoadingState(state: Boolean) {
    }

}
