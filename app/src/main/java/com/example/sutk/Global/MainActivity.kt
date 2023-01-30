package com.example.sutk.Global

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.sutk.DataHolder
import com.example.sutk.R
import com.example.sutk.com.example.sutk.dto.User.User
import com.example.sutk.databinding.ActivityMainBinding
import com.example.sutk.navigation.NavigationController
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    companion object{
        var res = User()
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    public var navController: NavigationController? = NavigationController()

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {

        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        navController?.setContext(applicationContext)

        hideSystemUI()
//        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DataHolder.context = applicationContext
        DataHolder.activity = this

        val window: Window = this.getWindow()

//// clear FLAG_TRANSLUCENT_STATUS flag:
//
//// clear FLAG_TRANSLUCENT_STATUS flag:
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//
//// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
//
//// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//
//// finally change the color
//
//// finally change the color
//        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

//        setSupportActionBar(binding.toolbar)

//        if (supportActionBar != null) {
//            val actionBar: ActionBar? = supportActionBar
//            actionBar?.setDisplayHomeAsUpEnabled(false)
//        }

//        val actionBar: android.app.ActionBar? = getActionBar()
//        if (actionBar != null) {
//            actionBar.setHomeButtonEnabled(false) // disable the button
//            actionBar.setDisplayHomeAsUpEnabled(false) // remove the left caret
//            actionBar.setDisplayShowHomeEnabled(false) // remove the icon
//        }

//        getActionBar()?.setDisplayHomeAsUpEnabled(false)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

//        CoroutineScope(Dispatchers.IO).launch{
//            val user = Client.getUserById(0)
//            withContext(Dispatchers.Main){
//
//            }
//        }

    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window,
            window.decorView.findViewById(android.R.id.content)).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())

            // When the screen is swiped up at the bottom
            // of the application, the navigationBar shall
            // appear for some time
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

//        if (Build.VERSION.SDK_INT >= 21) {
//            val window = this.window
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            window.statusBarColor = this.resources.getColor(R.color.white)
//        }

//        getSupportActionBar()?.setBackgroundDrawable(ColorDrawable(Color.parseColor(R.color.white.toString())));
//        setStatusBarColor("#FFFFFF")
    }

    fun setStatusBarColor(color: String?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            val statusBarColor = Color.parseColor(color)
            if (statusBarColor == Color.BLACK && window.getNavigationBarColor() === Color.BLACK) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            } else {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            }
            window.setStatusBarColor(statusBarColor)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

//    public fun activeAdminPanel(view: View){
//        Navigation.findNavController(this, R.id.nav_graph_pages).navigate(R.id.action_Pages_Manage_to_Admin)
//    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}