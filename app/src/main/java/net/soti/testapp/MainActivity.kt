package net.soti.testapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import net.soti.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tapButton.setOnClickListener {
            binding.tapButton.text = getString(R.string.button_tapped)
            binding.tapButton.isEnabled = false

            handler.postDelayed({
                binding.tapButton.text = getString(R.string.button_label)
                binding.tapButton.isEnabled = true
            }, 1500L)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}
