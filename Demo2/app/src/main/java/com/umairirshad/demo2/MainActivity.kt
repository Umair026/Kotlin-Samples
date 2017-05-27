package com.umairirshad.demo2

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import java.net.URL
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import org.ksoap2.SoapEnvelope
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapPrimitive
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*rest api*/
        makeApiCall()

        /*soap api*/
//        makeSoapApiCall()

    }

    private fun makeSoapApiCall() {
        doAsync {
            var value : String = ""

            // open server some time not respond proper, so dont worry
            val URL : String = "http://www.webservicex.net/globalweather.asmx?op=GetCitiesByCountry"
            val SOAP_ACTION : String  = "http://www.webserviceX.NET/GetCitiesByCountry"
            val METHOD_NAME: String  = "GetCitiesByCountry"
            val NAMESPACE : String  = "http://www.webserviceX.NET/"

            val Request = SoapObject(NAMESPACE,METHOD_NAME)
            Request.addProperty("CountryName","Pakistan")

            val soapEnvelope = SoapSerializationEnvelope(SoapEnvelope.VER11)
            soapEnvelope.dotNet = true
            soapEnvelope.setOutputSoapObject(Request)

            val transport = HttpTransportSE(URL)

            transport.call(SOAP_ACTION, soapEnvelope)

            val result = soapEnvelope.response
            value = result.toString()

            Log.d("responce", value)
        }
    }

    private fun makeApiCall() {
        val url = "https://maps.googleapis.com/maps/api/directions/json?origin=24.921804,67.022509&destination=24.922689,67.024698&sensor=false"

        doAsync {
            val jsonStr = URL(url).readText()
            Log.d("responce", jsonStr)
            textView.text = jsonStr
            uiThread { longToast("request performed") }
        }
    }
}