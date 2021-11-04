package studio.afandi.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    private lateinit var edtBil1: EditText
    private lateinit var edtBil2: EditText
    private lateinit var btnPlus: Button
    private lateinit var btnMin: Button
    private lateinit var btnBagi: Button
    private lateinit var btnKali: Button
    private lateinit var btnClear: Button
    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtBil1 = findViewById(R.id.edtAngka1)
        edtBil2 = findViewById(R.id.edtAngka2)
        btnPlus = findViewById(R.id.btnPlus)
        btnMin = findViewById(R.id.btnMin)
        btnBagi = findViewById(R.id.btnBagi)
        btnKali = findViewById(R.id.btnKali)
        btnClear = findViewById(R.id.btnClear)
        tvHasil = findViewById(R.id.tvHasil)

        btnPlus.setOnClickListener(this)

        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvHasil.text = result
        }
    }

    override fun onClick(v: View) {
        if(v.id == R.id.btnPlus){
            val inputAngka1 = edtBil1.text.toString().trim()
            val inputAngka2 = edtBil2.text.toString().trim()

            var isEmptyField = false

            if(inputAngka1.isEmpty()){
                isEmptyField = true
                edtBil1.error = "Field Tidak Boleh Kosong"
            }

            if(inputAngka2.isEmpty()){
                isEmptyField = true
                edtBil2.error = "Field Tidak Boleh Kosong"
            }

            if(!isEmptyField){
                val jumlah = inputAngka1.toDouble() + inputAngka2.toDouble()
                tvHasil.text = jumlah.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvHasil.text.toString())
    }
}