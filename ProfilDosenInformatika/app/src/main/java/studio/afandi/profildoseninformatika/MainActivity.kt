package studio.afandi.profildoseninformatika

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvDosen: RecyclerView
    private var list: ArrayList<Dosen> = arrayListOf()

    private var title: String = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvDosen = findViewById(R.id.rv_dosen)
        rvDosen.setHasFixedSize(true)

        list.addAll(DataDosen.listData)
        showRecyclerList()
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun showRecyclerList() {
        rvDosen.layoutManager = LinearLayoutManager(this)
        val listDosenAdapter = ListDosenAdapter(list)
        rvDosen.adapter = listDosenAdapter
    }

    private fun showRecyclerGrid() {
        rvDosen.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridDosenAdapter(list)
        rvDosen.adapter = gridHeroAdapter
    }

    private fun showRecyclerCardView() {
        rvDosen.layoutManager = LinearLayoutManager(this)
        val cardViewDosenAdapter = CardViewDosenAdapter(list)
        rvDosen.adapter = cardViewDosenAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_items, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()
            }
            R.id.action_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                title = "Mode CardView"
                showRecyclerCardView()
            }
        }
        setActionBarTitle(title)
    }
}