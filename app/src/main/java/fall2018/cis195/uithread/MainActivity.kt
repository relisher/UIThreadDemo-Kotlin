package fall2018.cis195.uithread

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var b: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b = countdown
        b.setOnClickListener({ v -> runThread() })
    }

    private fun runThread() {

        object : Thread() {
            override fun run() {
                var i = 0
                while (i++ < 1000) {
                    try {
                        runOnUiThread { b.setText("#" + i) }
                        Thread.sleep(300)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                }
            }
        }.start()
    }
}
