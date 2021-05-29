package ir.iust.group7_androidproject_2.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FileList {
    private val fileList = mutableListOf<File>()
    private val files = MutableLiveData<List<File>>()

    init {
        files.value = fileList
    }

    fun addFile(file: File){
        fileList.add(file)
        files.value = fileList
    }

    fun getFiles() = files as LiveData<List<File>>

    fun getFile(id: Int): File {
        return fileList[id]
    }
}