package com.example.kotlinexamples

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class DownloadUrl {

    fun readUrl(myUrl: String){
        var data: String? = null
        var inputStream: InputStream;
        var urlConnection : HttpURLConnection

        try{

            var url: URL = URL(myUrl)

            urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.connect()

            inputStream = urlConnection.inputStream

            var bufferRead : BufferedReader = BufferedReader(InputStreamReader(inputStream))

           lateinit var stringBuffer: StringBuilder;

            var line = bufferRead.readLine()

            while({line = bufferRead.readLine();line}() != null ){

                stringBuffer.append(line)

            }
            data = stringBuffer.toString();
            bufferRead.close();

        }catch(e: MalformedURLException ){
            e.printStackTrace()

        }
        catch(e: IOException){
            e.printStackTrace()
        }

    }

}