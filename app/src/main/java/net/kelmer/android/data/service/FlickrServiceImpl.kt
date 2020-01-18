package net.kelmer.android.data.service

import android.annotation.SuppressLint
import io.reactivex.Single
import net.kelmer.android.data.GsonSerializer
import net.kelmer.android.data.Serializer
import net.kelmer.android.data.model.ApiResponse
import net.kelmer.android.utils.HttpClient
import net.kelmer.android.utils.StringResponseHttpClient
import java.lang.Exception


class FlickrServiceImpl(private val baseUrl: String, private val serializer: Serializer, private val client: HttpClient) : FlickrService {


    override fun getSearch(apiKey: String, term: String): Single<ApiResponse> {
        return Single.fromCallable {
            searchRequest(apiKey, term) ?: throw Exception("Could not retrieve")
        }

    }

    private fun searchRequest(apiKey: String, term: String) : ApiResponse?{
        val fullUrl =
            "$baseUrl/services/rest?method=flickr.photos.search&format=json&nojsoncallback=1&api_key=$apiKey&text=$term"
        val response = client.doGet(fullUrl) ?: return null
        return deserialize(response)
    }

    private fun deserialize(response: String): ApiResponse? {
        return serializer.deserialize(response)
    }
}