package com.testo

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.testo.api.ApiFactory
import com.testo.pojo.UserRequest
import com.testo.pojo.UserResponse
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()

    fun createUser(userRequest: UserRequest): UserResponse? {
        val disposable = ApiFactory.apiService.createUser(userRequest)
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d("Loading", "Success: ${it.toString()}")
            }, {
                Log.d("Loading", "Failure: ${it.message}")
            })

        compositeDisposable.add(disposable)

        return null
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}