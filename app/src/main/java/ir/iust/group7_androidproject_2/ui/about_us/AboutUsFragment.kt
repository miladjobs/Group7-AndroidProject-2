package ir.iust.group7_androidproject_2.ui.about_us

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import ir.iust.group7_androidproject_2.R
import ir.iust.group7_androidproject_2.ui.home.HomeFragment

class AboutUsFragment : Fragment() {
    private lateinit var btnBack: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about_us, container, false)
        btnBack = view.findViewById(R.id.btn_about_back)
        btnBack.setOnClickListener{
            Log.i("HomeFragment", "back from about us clicked")
            val homeFragment = HomeFragment()
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if(transaction != null){
                transaction.replace(R.id.nav_host_fragment, homeFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }

        return view
    }

}