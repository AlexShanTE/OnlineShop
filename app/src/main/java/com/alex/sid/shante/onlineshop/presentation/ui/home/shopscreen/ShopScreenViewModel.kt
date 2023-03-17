package com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.sid.shante.onlineshop.di.IoDispatcher
import com.alex.sid.shante.onlineshop.domain.models.FlashSaleItem
import com.alex.sid.shante.onlineshop.domain.models.LatestItem
import com.alex.sid.shante.onlineshop.domain.models.ShopCategory
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
class ShopScreenViewModel @Inject constructor(
    private val repository: ShopRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _state = MutableStateFlow(ShopScreenState())
    val state: StateFlow<ShopScreenState> = _state.asStateFlow()

    private var latestList: List<LatestItem>? = null
    private var flashSalesList: List<FlashSaleItem>? = null

    init {
        getGoods()
    }

    private fun getGoods() {
        viewModelScope.launch(dispatcher) {
            try {
                val latestData = repository.getLatest()
                val flashSalesData = repository.getFlashSales()
                latestList = latestData.latest
                flashSalesList = flashSalesData.flashSales
                _state.update { state ->
                    state.copy(
                        latestData = latestData,
                        flashSalesData = flashSalesData,
                        selectedCategory = null
                    )
                }
            } catch (e: Throwable) {
                //todo
            }
        }
    }

    fun onSearchTextChange(text: String) {
        _state.update { state ->
            state.copy(textFieldValue = text)
        }
    }

    fun onCategorySelected(context: Context, category: ShopCategory?) {
        when (category) {
            null -> {
                makeToast(context, "No category Selected")
                getGoods()
            }
            else -> {
                makeToast(context, "${category.title} category is Selected")
                val newListOfLatest = latestList?.filter { it.category == category.title }
                val newListOfFlashSales = flashSalesList?.filter { it.category == category.title }
                _state.update { state ->
                    state.copy(
                        selectedCategory = category,
                        latestData = newListOfLatest?.let { state.latestData?.copy(latest = it) },
                        flashSalesData = newListOfFlashSales?.let {
                            state.flashSalesData?.copy(
                                flashSales = it
                            )
                        }
                    )
                }
            }
        }
    }

    fun makeToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
