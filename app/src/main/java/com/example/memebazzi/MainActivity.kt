package com.example.memebazzi

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.memebazzi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()

        binding.button.setOnClickListener {
            getData()
        }
    }
    private fun getData() {

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("fetching meme")
        progressDialog.show()

        retrofit_instance.apiInterface.getdata().enqueue(object : Callback<responsedata?> {
            override fun onResponse(call: Call<responsedata?>, response: Response<responsedata?>) {
                Glide.with(this@MainActivity).load(response.body()?.url).into(binding.imageView)
                progressDialog.dismiss()
            }

            override fun onFailure(call: Call<responsedata?>, t: Throwable) {
                Toast.makeText(this@MainActivity,"error", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }
        })
    }
}