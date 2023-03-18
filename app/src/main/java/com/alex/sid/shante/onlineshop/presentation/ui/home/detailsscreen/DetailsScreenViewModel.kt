package com.alex.sid.shante.onlineshop.presentation.ui.home.detailsscreen

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.sid.shante.onlineshop.di.IoDispatcher
import com.alex.sid.shante.onlineshop.domain.repositories.ShopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val repository: ShopRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _state = MutableStateFlow(DetailsScreenState())
    val state: StateFlow<DetailsScreenState> = _state.asStateFlow()

    init {
        getDetails()
    }

    fun getDetails() {
        viewModelScope.launch(dispatcher) {
            try {
                val details = repository.getItemDetails()
                _state.update { state ->
                    state.copy(
                        details = details,
                        itemsQuantity = 1,
                        totalPrice = details.price.toString()
                    )
                }
            } catch (e: Exception) {
                //todo
            }
        }
    }

    fun onPreviewChanged(imageUrl: String) {
        _state.update { state->
            state.copy(currentImagePreview = imageUrl)
        }
    }

    fun onQuantityChange(value: Int) {
        _state.update { state ->
            val quantity = state.itemsQuantity + value
            state.copy(
                itemsQuantity = quantity,
                totalPrice = (state.details.price * quantity).toString()
            )
        }
    }

    fun makeToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}