package com.ticmas.desarrollo_aplicaciones_moviles.proyecto.comparator.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ticmas.desarrollo_aplicaciones_moviles.proyecto.comparator.R
import com.ticmas.desarrollo_aplicaciones_moviles.proyecto.comparator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.match.observe(this) {
            val matchCaption = getString(R.string.match_inputs)
            val noMatchCaption = getString(R.string.no_match_inputs)

            binding.stateTxt.text = if (it.state) matchCaption else noMatchCaption
        }

        binding.compareBtn.setOnClickListener {
            val input1 = binding.input1.text.toString()
            val input2 = binding.input2.text.toString()

            val stateTxt = findViewById<TextView>(R.id.stateTxt)
            stateTxt.visibility = View.VISIBLE

            mainViewModel.compareInputs(input1, input2)
        }
    }
}