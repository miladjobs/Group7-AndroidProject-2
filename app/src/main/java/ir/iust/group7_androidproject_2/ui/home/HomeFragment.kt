package ir.iust.group7_androidproject_2.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.iust.group7_androidproject_2.FileListAdapter
import ir.iust.group7_androidproject_2.R
import ir.iust.group7_androidproject_2.data.File
import ir.iust.group7_androidproject_2.ui.about_us.AboutUsFragment
import ir.iust.group7_androidproject_2.ui.file_detail.FileDetailFragment
import ir.iust.group7_androidproject_2.utils.DataInjector
import ir.iust.group7_androidproject_2.ui.file_detail.FileViewModel

class HomeFragment : Fragment() {
    private lateinit var fileList: RecyclerView
    private lateinit var btnAbout: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        fileList = view.findViewById(R.id.file_list)
        btnAbout = view.findViewById(R.id.btn_about)

        val filesList: List<File> = emptyList()
        val factory = DataInjector.provideFileViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(FileViewModel::class.java)
        fileList.layoutManager = LinearLayoutManager(context)
        fileList.adapter = FileListAdapter(filesList){
            Log.i("HomeFragment", "file $it clicked")
            val fileDetailFragment = FileDetailFragment()
            val bundle: Bundle = Bundle()
            fileDetailFragment.arguments = bundle
            bundle.putInt("file_id", it)
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if (transaction != null){
                transaction.replace(R.id.nav_host_fragment, fileDetailFragment)
                transaction.addToBackStack(null)
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                transaction.commit()
            }
        }
        viewModel.getFiles().observe(viewLifecycleOwner, Observer {
            files -> if (files != null){
                if(fileList.adapter != null)
                    (fileList.adapter as FileListAdapter).setFiles(files = files)
        }
        })

        btnAbout.setOnClickListener{
            Log.i("HomeFragment", "about us clicked")
            val aboutUsFragment = AboutUsFragment()
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if(transaction != null){
                transaction.replace(R.id.nav_host_fragment, aboutUsFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }

        return view
    }

}