package com.caiosilva.jankenpo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.caiosilva.jankenpo.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val options: List<String> = listOf("Papel", "Pedra", "Tesoura")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageViewPapel.setOnClickListener {
//            Toast.makeText(this, "Clicou no ${options[0]}", Toast.LENGTH_LONG).show()
            onOptionSelected(0)
        }

        binding.imageViewPedra.setOnClickListener {
//            Toast.makeText(this, "Clicou na ${options[1]}", Toast.LENGTH_LONG).show()
            onOptionSelected(1)
        }

        binding.imageViewTesoura.setOnClickListener {
//            Toast.makeText(this, "Clicou na ${options[2]}", Toast.LENGTH_LONG).show()
            onOptionSelected(2)
        }
    }

    private fun onOptionSelected(choice: Int) {
        println(choice)
        val computerChoice: Int = Random.nextInt(3)
        println(options[computerChoice])

        binding.resultTextView.text = checkWinner(Pair(computerChoice, choice))

//        when (computerChoice) {
//            0 -> {
//                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.papel))
//                when (choice) {
//                    0 -> {
//                        binding.resultTextView.text =
//                            getString(R.string.result_draw, options[computerChoice])
//                    }
//
//                    1 -> {
//                        binding.resultTextView.text =
//                            getString(R.string.result_app_wins, options[computerChoice])
//                    }
//
//                    2 -> {
//                        binding.resultTextView.text =
//                            getString(R.string.result_app_loses, options[computerChoice])
//                    }
//                }
//            }
//
//            1 -> {
//                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.pedra))
//                when (choice) {
//                    0 -> {
//                        binding.resultTextView.text =
//                            getString(R.string.result_app_loses, options[computerChoice])
//                    }
//
//                    1 -> {
//                        binding.resultTextView.text =
//                            getString(R.string.result_draw, options[computerChoice])
//                    }
//
//                    2 -> {
//                        binding.resultTextView.text =
//                            getString(R.string.result_app_wins, options[computerChoice])
//                    }
//                }
//            }
//
//            2 -> {
//                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.tesoura))
//                when (choice) {
//                    0 -> {
//                        binding.resultTextView.text =
//                            getString(R.string.result_app_wins, options[computerChoice])
//                    }
//
//                    1 -> {
//                        binding.resultTextView.text =
//                            getString(R.string.result_app_loses, options[computerChoice])
//                    }
//
//                    2 -> {
//                        binding.resultTextView.text =
//                            getString(R.string.result_draw, options[computerChoice])
//                    }
//                }
//            }
//        }
    }

    private fun checkWinner(choices: Pair<Int, Int>): String {
        if (choices.first == choices.second)
            return getString(R.string.result_draw, options[choices.first])

        return when (choices) {
            Pair(0, 1) -> {
                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.papel))
                getString(R.string.result_app_wins, options[choices.first])
            }

            Pair(0, 2) -> {
                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.papel))
                getString(R.string.result_app_loses, options[choices.first])
            }

            Pair(1, 0) -> {
                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.pedra))
                getString(R.string.result_app_loses, options[choices.first])
            }

            Pair(1, 2) -> {
                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.pedra))
                getString(R.string.result_app_wins, options[choices.first])
            }

            Pair(2, 0) -> {
                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.tesoura))
                getString(R.string.result_app_wins, options[choices.first])
            }

            Pair(2, 1) -> {
                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.tesoura))
                getString(R.string.result_app_loses, options[choices.first])
            }

            else -> ""
        }
    }
}
