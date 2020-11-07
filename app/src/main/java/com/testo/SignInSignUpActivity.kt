package com.testo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_sign_in_sign_up.*

class SignInSignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_sign_up)
        Log.d("applanguage", intent.getStringExtra(APP_LANGUAGE))

        val buttons = listOf<View>(btnSignUp, btnSignIn)

        buttons.forEach { it ->
            it.setOnClickListener {
                if (it.id == btnSignUp.id) {
                    val intent = TermsAndConditionsActivity.newIntent(
                        this@SignInSignUpActivity
                    )
                    startActivity(intent)
                } else {
                    val intent = SignInActivity.newIntent(
                        this@SignInSignUpActivity
                    )
                    startActivity(intent)
                }
            }
        }
    }

    companion object {
        private const val APP_LANGUAGE = "appLanguage"

        fun newIntent(context: Context, language: String): Intent {
            val intent = Intent(context, SignInSignUpActivity::class.java)
            intent.putExtra(APP_LANGUAGE, language)
            return intent
        }
    }
}