package studio.afandi.myrandomquotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import studio.afandi.myrandomquotes.databinding.ActivityCoronaBinding

class CoronaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoronaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoronaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCovidData()
    }

    private fun getCovidData() {
        val client = AsyncHttpClient()
        val url = "https://api.kawalcorona.com/indonesia/"
        client.get(url, object : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray
            ) {
                val result = String(responseBody)
                try {
                    val jsonArray = JSONArray(result)
                    val responseObject = jsonArray.getJSONObject(0)
                    val positive = responseObject.getString("positif")
                    val dirawat = responseObject.getString("dirawat")
                    val sembuh = responseObject.getString("sembuh")
                    val meninggal = responseObject.getString("meninggal")
                    binding.tvPenderita.text = positive
                    binding.tvRawat.text = dirawat
                    binding.tvSembuh.text = sembuh
                    binding.tvMeninggal.text = meninggal
                } catch (e: Exception) {
                    Toast.makeText(this@CoronaActivity, e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable
            ) {
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                Toast.makeText(this@CoronaActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}