package bagicode.aplikasi_skor_basket

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import bagicode.aplikasi_skor_basket.R.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var alertDialogBuilder: AlertDialog.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        bottomNavigationView = findViewById(id.bottomNavigation)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                id.nav_home -> {
                    val fragment = InputTim()
                    loadFragment(fragment)
                    return@setOnItemSelectedListener true
                }
                id.mulaiButton -> {
                    val  fragment = HitungSkor()
                    loadFragment(fragment)
                    return@setOnItemSelectedListener true
                }

                else -> return@setOnItemSelectedListener false
            }
        }

        alertDialogBuilder = AlertDialog.Builder(this)
    }
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(id.fragmentContainer, fragment)
        transaction.addToBackStack(null) // Untuk menambahkan transaksi ke back stack (opsional)
        transaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this, "anda menekan back", Toast.LENGTH_SHORT).show()
        alertDialogBuilder.setTitle("Tutup Aplikasi")
        alertDialogBuilder
            .setMessage("Apakah anda yakin ingin menutup aplikasi?")
            .setCancelable(false)
            .setPositiveButton("Ya",
                DialogInterface.OnClickListener{
                   dialogInterface: DialogInterface, i: Int ->
                        dialogInterface.cancel()
                        Toast.makeText(this, "Anda menekan Ya", Toast.LENGTH_SHORT).show()

                })
            .setNegativeButton("Tidak",
                DialogInterface.OnClickListener{
                    dialogInterface: DialogInterface?, which: Int ->
                        dialogInterface?.cancel()
                        Toast.makeText(this, "Anda menekan Tidak", Toast.LENGTH_SHORT).show()


                }).create().show()
    }
}