package com.egyyazilim.eventsapp.ui.splash


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import com.egyyazilim.eventsapp.utils.Constant


class SplashViewModel :  ViewModel() {
    sealed class Event {
        object NavigateToHome : Event()
        object NavigateToOnBoardingScreen : Event()
    }
    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()


    fun startSplash()=viewModelScope.launch {
        delay(1000)
        val shouldShowOnBoardingScreen = Hawk.get(Constant.Prefs.KEY_SHOULD_SHOW_ON_BOARDING, true)
    }


}