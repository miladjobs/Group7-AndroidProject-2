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
import ir.iust.group7_androidproject_2.utils.DataInjector
import ir.iust.group7_androidproject_2.utils.DownloadImage


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
        fileImage = view.findViewById(R.id.file_image)
        fileDescription = view.findViewById(R.id.file_description)
        fileName = view.findViewById(R.id.file_name)
        fileDownloadsCount = view.findViewById(R.id.file_downloads_count)
        fileSize = view.findViewById(R.id.file_size)
        Log.i("FileDetailFragment", "file id is ${this.file_id}")
        val factory = DataInjector.provideFileViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(FileViewModel::class.java)
        val file: File = viewModel.getFile(file_id)
        fileName.text = file.name
        fileDescription.text = file.description
        fileSize.text = file.size.toString()
        fileDownloadsCount.text = file.downloadsCount.toString()
        DownloadImage(fileImage).execute(file.image_path)
        return view
    }

    companion object{

        @JvmStatic
        fun newInstance(param1: String, param2: String) = FileDetailFragment().apply {
            arguments = Bundle().apply {
                putString("file_id", param1)
                putString("param2", param2)
            }
        }
    }

}