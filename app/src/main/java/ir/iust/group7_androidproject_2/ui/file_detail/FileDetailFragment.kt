package ir.iust.group7_androidproject_2.ui.file_detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import ir.iust.group7_androidproject_2.R
import ir.iust.group7_androidproject_2.data.File



class FileDetailFragment: Fragment() {
    private var file_id: Int = -1
    private var param2: String? = null
    private lateinit var fileImage: ImageView
    private lateinit var fileName: TextView
    private lateinit var fileDownloadsCount: TextView
    private lateinit var fileSize: TextView
    private lateinit var fileDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            file_id = it.getInt("file_id")
            param2 = it.getString("param2")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_file_detail, container, false)
        return view //change
    }


}