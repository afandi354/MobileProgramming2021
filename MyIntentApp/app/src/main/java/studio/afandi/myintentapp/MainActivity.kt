package studio.afandi.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveActivityWithData: Button = findViewById(R.id.btn_move_activity_with_data)
        btnMoveActivityWithData.setOnClickListener(this)

        val btnMoveActivityWithObjects: Button = findViewById(R.id.btn_move_activity_with_object)
        btnMoveActivityWithObjects.setOnClickListener(this)

        val btnInternet: Button = findViewById(R.id.btn_internet)
        btnInternet.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_phone)
        btnDialPhone.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_move_activity -> {
                val moveActivity = Intent(this, MoveActivity::class.java)
                startActivity(moveActivity)
            }

            R.id.btn_move_activity_with_data -> {
                val moveWithDataActivity = Intent(this, MoveWithDataActivity::class.java)
                moveWithDataActivity.putExtra(MoveWithDataActivity.EXTRA_NAME, "Afandi NAT")
                moveWithDataActivity.putExtra(MoveWithDataActivity.EXTRA_AGE, 30)
                startActivity(moveWithDataActivity)
            }

            R.id.btn_move_activity_with_object -> {
                val moveWithObjectActivity = Intent(this, MoveWithObjectActivity::class.java)
                val person = Person(
                    "Afandi NAT",
                    30,
                    "afandi@polines.ac.id",
                    "Semarang"
                )
                moveWithObjectActivity.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectActivity)
            }

            R.id.btn_internet -> {
                val website = "https://www.polines.ac.id/id/"
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(website))
                startActivity(webIntent)
            }
        }
    }
}