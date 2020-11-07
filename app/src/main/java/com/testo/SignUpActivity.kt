package com.testo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.testo.pojo.UserRequest
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
        ).get(UserViewModel::class.java)


        btnMainSignUp.setOnClickListener {
//            Create user
//            viewModel.createUser(UserRequest(
//                firstName = "test",
//                lastName = "test",
//                email = "iamazizMavlyanov@yandex.com",
//                password = "test12345"
//            ))

            val intent = EmailVerificationActivity.newIntent(
                this@SignUpActivity
            )
            startActivity(intent)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SignUpActivity::class.java)
        }
    }
}