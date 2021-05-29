package ir.iust.group7_androidproject_2

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.viewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.iust.group7_androidproject_2.ui.file_detail.FileViewModel
import ir.iust.group7_androidproject_2.utils.DataInjector

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val factory = DataInjector.provideFileViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(FileViewModel::class.java)
        viewModel.initializeData()
        Log.i("MainActivity", "initialize app and fetch data")
        viewModel.getFiles().observe(this, Observer { files -> files.forEach{
            file -> Log.i("MainActivity", "fetch $file")
        } })

    }

}