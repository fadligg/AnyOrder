package lat.pam.anyorder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Hubungkan ke layout activity_home.xml
        setContentView(R.layout.activity_home)

        // 2. Temukan BottomNavigationView
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        // 3. Temukan NavHostFragment (wadah fragment)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_home) as NavHostFragment

        // 4. Dapatkan NavController (pengontrol navigasi)
        val navController = navHostFragment.navController

        // 5. Hubungkan BottomNavigationView dengan NavController
        // Ini adalah bagian "ajaib" yang membuat semuanya bekerja otomatis!
        NavigationUI.setupWithNavController(navView, navController)
    }
}
