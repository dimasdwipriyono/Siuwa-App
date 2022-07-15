package com.dimasdwipriyono_19102187.siuwa

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dimasdwipriyono_19102187.siuwa.adapter.ListMyDataAdapter
import com.dimasdwipriyono_19102187.siuwa.broadcast.ConnectivityReceiver
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_umkm_main.*

class MainActivity : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {
    lateinit var snackBar : Snackbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_umkm_main)
        rv_mydata.setHasFixedSize(true)
        list.addAll(getListMyDatas())
        showRecyclerList()
        registerReceiver(ConnectivityReceiver() , IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }
    private val list = ArrayList<MyData>()

    private fun getListMyDatas(): ArrayList<MyData> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.item_photo)
        val dataAlamat = resources.getStringArray(R.array.data_alamat)
        val dataHarga = resources.getStringArray(R.array.data_harga)
        val dataLat = resources.getStringArray(R.array.data_lat)
        val dataLang = resources.getStringArray(R.array.data_lang)
        val jamBuka = resources.getStringArray(R.array.data_buka)
        val listMyData = ArrayList<MyData>()
        for (position in dataName.indices) {
            val myData = MyData(
                dataName[position],
                dataDescription[position],
                dataPhoto[position],
                dataHarga[position],
                dataAlamat[position],
                jamBuka [position],
                dataLat[position].toDouble(),
                dataLang[position].toDouble()
            )
            listMyData.add(myData)
        }
        return listMyData
    }

    private fun showRecyclerList() {
        rv_mydata.layoutManager = LinearLayoutManager(this)
        val listMyDataAdapter = ListMyDataAdapter(list, this@MainActivity)
        rv_mydata.adapter = listMyDataAdapter
    }

//    Broadcast Receiver
    override fun onNetworkConnectionChanger(isConnected: Boolean) {
        shoNetworkMessage(isConnected)
    }

        private fun shoNetworkMessage(isConnected: Boolean) {
            if (isConnected){
                snackBar = Snackbar.make(this.findViewById(android.R.id.content), "You are Online ", Snackbar.LENGTH_LONG)
                snackBar.show()
            }else{
                snackBar = Snackbar.make(this.findViewById(android.R.id.content), "You are Offline ", Snackbar.LENGTH_LONG);
                snackBar.show()
            }
        }
        override fun onResume() {
            super.onResume()
            ConnectivityReceiver.connectivityReceiverListener = this
        }
}