package com.ticmas.desarrollo_aplicaciones_moviles.proyecto.comparator.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ticmas.desarrollo_aplicaciones_moviles.proyecto.comparator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.match.observe(this) {
            var caption = if (it.state) "Contraseñas coincidentes!" else "Las contraseñas NO coinciden!"
            binding.StateTxt.text = caption
        }

        binding.compareBtn.setOnClickListener {
            val input1 = binding.input1.text.toString()
            val input2 = binding.input2.text.toString()

            mainViewModel.compareInputs(input1, input2)
        }
    }
}