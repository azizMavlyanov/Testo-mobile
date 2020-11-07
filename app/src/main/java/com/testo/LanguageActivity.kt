package com.testo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class LanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttons = listOf<View>(btnEnglish, btnRussian, btnUzbek)

        buttons.forEach { it ->
            it.setOnClickListener {
                val intent = SignInSignUpActivity.newIntent(
                    this@LanguageActivity,
                    it.resources.getResourceEntryName(it.id)
                )
                startActivity(intent)
            }
        }
    }
}