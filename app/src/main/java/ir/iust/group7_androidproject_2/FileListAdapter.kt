package ir.iust.group7_androidproject_2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.iust.group7_androidproject_2.data.File
import ir.iust.group7_androidproject_2.utils.DownloadImage

class FileListAdapter(private var fileList: List<File>, private val onItemClicked: (Int)->Unit): RecyclerView.Adapter<FileListAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val fileName: TextView
        val fileDownloadsCount: TextView
        val fileImage: ImageView

        init {
            Log.i("TEST", "Test: $view")
            fileName = view.findViewById(R.id.file_list_name)
            fileDownloadsCount = view.findViewById(R.id.file_list_downloads_count)
            fileImage = view.findViewById(R.id.file_list_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.file_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val file: File = fileList[position]
        holder.fileName.text = file.name
        holder.fileDownloadsCount.text = file.downloadsCount.toString()
        DownloadImage(holder.fileImage).execute(file.image_path)
        holder.itemView.setOnClickListener{
            onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return fileList.size
    }

    fun setFiles(files: List<File>){
        this.fileList = files
        notifyDataSetChanged()
    }


}