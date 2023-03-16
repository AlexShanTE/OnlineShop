package com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.sid.shante.onlineshop.di.IoDispatcher
import com.alex.sid.shante.onlineshop.domain.repositories.ShopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ShopScreenViewModel @Inject constructor(
    private val repository: ShopRepository,
    @IoDispatcher private val dispatcher:CoroutineDispatcher
): ViewModel() {

    private val _state = MutableStateFlow(ShopScreenState())
    val state: StateFlow<ShopScreenState> = _state.asStateFlow()

    fun getGoods(context: Context) {
        viewModelScope.launch(dispatcher) {
            try {
                val latestData = repository.getLatest()
                val flashSalesData = repository.getFlashSales()
                _state.update {state ->
                    state.copy(latestData = latestData, flashSalesData = flashSalesData)
                }
            } catch (e: Throwable) {
                withContext(Dispatchers.Main) {
                    makeToast(context,e.message.toString())
                }
            }
        }
    }

    fun makeToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}