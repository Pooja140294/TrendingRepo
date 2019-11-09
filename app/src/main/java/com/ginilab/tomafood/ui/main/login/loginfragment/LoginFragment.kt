package com.ginilab.tomafood.ui.main.login.loginfragment

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

import com.ginilab.tomafood.R
import com.ginilab.tomafood.base.extensions.showShortToast
import com.ginilab.tomafood.ui.main.login.response.LoginBody
import com.ginilab.tomafood.ui.main.login.response.LoginResponse
import kotlinx.android.synthetic.main.login_item.*
import org.json.JSONObject


class LoginFragment : AbstractLoginFragment() {

    private lateinit var et_firstName: EditText
    private lateinit var et_lastName: EditText
    private lateinit var et_phone: EditText
    private lateinit var et_email: EditText
    private lateinit var et_password: EditText
    private lateinit var btn_Login: Button
    private lateinit var txt_title: TextView
    private lateinit var txt_FirstName: TextView
    private lateinit var txt_LastName: TextView
    private lateinit var txt_Phone: TextView

    override fun getLayoutRes(): Int = R.layout.fragment_login

    override fun viewInitialization(view: View) {

        intiViews(view)
        setListener()
    }

    private fun intiViews(view: View) {

        et_firstName = view.findViewById(R.id.et_FirstName)
        et_lastName = view.findViewById(R.id.et_LastName)
        et_email = view.findViewById(R.id.et_Email)
        et_phone = view.findViewById(R.id.et_Phone)
        et_password = view.findViewById(R.id.et_Password)
        btn_Login = view.findViewById(R.id.btn_Login)
        txt_FirstName = view.findViewById(R.id.txt_FirstName)
        txt_LastName = view.findViewById(R.id.txt_LastName)
        txt_Phone = view.findViewById(R.id.txt_Phone)
        txt_title = view.findViewById(R.id.txt_title)

        et_firstName.visibility = View.GONE
        et_lastName.visibility = View.GONE
        et_phone.visibility = View.GONE
        txt_FirstName.visibility = View.GONE
        txt_LastName.visibility = View.GONE
        txt_Phone.visibility = View.GONE
        view_FirstName.visibility = View.GONE
        view_LastName.visibility = View.GONE
        view_Phone.visibility = View.GONE
        txt_title.text = getString(R.string.login)

    }

    private fun setListener() {

        btn_Login.setOnClickListener{

            if (et_email.text.isNullOrEmpty() || et_password.text.isNullOrEmpty()){

                activity?.showShortToast("Required Field Missing !")
            }else{

                fetchLoginData(LoginBody(et_email.text.toString(), et_password.text.toString()))

            }
        }

    }

    override fun setLoginData(data: LoginResponse) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
