package binar.greta.tugasdependencyinjection_mvvmnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import binar.greta.tugasdependencyinjection_mvvmnews.model.GetAllNewsItem
import binar.greta.tugasdependencyinjection_mvvmnews.network.ApiClient
import binar.greta.tugasdependencyinjection_mvvmnews.network.ApiService
import binar.greta.tugasdependencyinjection_mvvmnews.view.AdapterNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class VMNews @Inject constructor(apiService: ApiService) : ViewModel(){

    private var newsLiveData = MutableLiveData<List<GetAllNewsItem>>()
    val news : LiveData<List<GetAllNewsItem>> = newsLiveData

    init {
        viewModelScope.launch {
            val datanews = apiService.getAllNews()
            delay(2000)
            newsLiveData.value = datanews
        }
    }

}


//    lateinit var liveDataNews: MutableLiveData<List<GetAllNewsItem>>
//
//    init {
//        liveDataNews = MutableLiveData()
//    }
//
//    fun getLiveNewsObserver() : MutableLiveData<List<GetAllNewsItem>>{
//        return liveDataNews
//    }
//
//    fun getApiNews(){
//        ApiClient.instance.getAllNews()
//            .enqueue(object  : Callback<List<GetAllNewsItem>>{
//                override fun onResponse(
//                    call: Call<List<GetAllNewsItem>>,
//                    response: Response<List<GetAllNewsItem>>
//                ) {
//                    if (response.isSuccessful){
//                        liveDataNews.postValue(response.body())
//                    }else{
//                        liveDataNews.postValue(null)
//                    }
//                }
//
//                override fun onFailure(call: Call<List<GetAllNewsItem>>, t: Throwable) {
//                    liveDataNews.postValue(null)
//                }
//
//            })
//    }


