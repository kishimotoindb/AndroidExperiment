package com.fearlessbear.androidexperiment.uri

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fearlessbear.androidexperiment.R


/*
  Uri.parse(uriStr)，uriStr的参数值已经encode过的情况下，parse的时候会不会二次encode
  uri.toString输出的是啥？
  ret=https://app.kwaixiaodian.com/merchant/shop/home?key1=中国&key2=%E4%B8%AD%E5%9B%BD
  parse之后的uri，getParams返回的是decode过的值？

  key2=中国，expect 中国
  key2=中国，expect %E4%B8%AD%E5%9B%BD
  key3 in uri=https://app.kwaixiaodian.com/merchant/shop/home?key1=中国&key2=%E4%B8%AD%E5%9B%BD&key3=%E4%B8%AD%E5%9B%BD
  从uri拿出来的key3，是什么？
  key3=中国

  往uri中set一个encoded值，是否会被二次encode？
  key3 in uri=https://app.kwaixiaodian.com/merchant/shop/home?key1=中国&key2=%E4%B8%AD%E5%9B%BD&key3=%25E4%25B8%25AD%25E5%259B%25BD
  从uri拿出来的key3，是什么？
  key3=%E4%B8%AD%E5%9B%BD
 */

class UriEncodeActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_uri_encode2)

    test()
  }

  private fun test() {
    Log.i("UriTest", "Uri.parse(uriStr)，uriStr的参数值已经encode过的情况下，parse的时候会不会二次encode")
    val uri = Uri.parse("https://app.kwaixiaodian" +
        ".com/merchant/shop/home?key1=中国&key2=%E4%B8%AD%E5%9B%BD")
    Log.i("UriTest", "uri.toString输出的是啥？")
    Log.i("UriTest", "ret=${uri}")

    Log.i("UriTest", "parse之后的uri，getParams返回的是decode过的值？")
    Log.i("UriTest", "key2=${uri.getQueryParameter("key1")}，expect 中国")
    Log.i("UriTest", "key2=${uri.getQueryParameter("key2")}，expect %E4%B8%AD%E5%9B%BD")


    print("往uri中set一个原始值，是否会被encode？")
    val uri1 = uri.buildUpon().appendQueryParameter("key3", "中国").build()
    Log.i("UriTest", "key3 in uri=${uri1}")
    Log.i("UriTest", "从uri拿出来的key3，是什么？")
    Log.i("UriTest", "key3=${uri1.getQueryParameter("key3")}")

    Log.i("UriTest", "往uri中set一个encoded值，是否会被二次encode？")
    val uri2 = uri.buildUpon().appendQueryParameter("key3", "%E4%B8%AD%E5%9B%BD").build()
    Log.i("UriTest", "key3 in uri=${uri2}")
    Log.i("UriTest", "从uri拿出来的key3，是什么？")
    Log.i("UriTest", "key3=${uri2.getQueryParameter("key3")}")
  }
}