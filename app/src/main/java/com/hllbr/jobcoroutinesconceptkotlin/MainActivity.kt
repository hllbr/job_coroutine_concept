package com.hllbr.jobcoroutinesconceptkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        Lauch çalıştırılan heryerde karşımıza JOB kavramı çıkabiliyor.lauch çalıştırılan herşey job'a eşitlenebilir.
        ve biz bu döndürülen işleri sonradan görebiliyoruz/kontrol edebiliyoruz.
        ister iptal ederim .ister başka işler veririm ve bunları yap derim. İstersem iç içe kullanabilirim.

         */
        main()
    }
    fun main(){
        runBlocking {
            val myjob = launch { //this is crazy effect :)
                delay(2000)
                println("job")
                val secondJob = launch {
                    println("Second_Job = 2.job :)")
                }
            }
            myjob.invokeOnCompletion {
                //myJob bittiğinde ne yapılacağını yazabildiğimiz bir alan oluşturuyor bu yapı bana
                println("my job end")
            }
            myjob.cancel()//myjob çalışmadan önce delayde o arada cancell devreye girip çalışmalarını durduruyor ve sadece ekrana my job end ifadesi düşer bu yapıyı aktif edersek
            //bir iş iptal edildiğinde içindeki diğer işte iptal edilmiş oluyor doğal olarak bu yapı genelde onDestroyed methodlar içerisinde gereksiz işlemleri arkaplandan kaldırmak için kullanıyoruz

        }
    }
}