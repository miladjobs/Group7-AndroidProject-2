package ir.iust.group7_androidproject_2.ui.file_detail

import androidx.lifecycle.ViewModel
import ir.iust.group7_androidproject_2.data.File
import ir.iust.group7_androidproject_2.data.FileRepository

class FileViewModel(private val fileRepository: FileRepository): ViewModel() {
    fun getFiles() = fileRepository.getFiles()

    fun getFile(id: Int): File = fileRepository.getFile(id)

    fun addFile(file: File) = fileRepository.addFile(file)

    fun initializeData(){
        val file1 = File(name="Book", downloadsCount = 10, description = "Mathematics", size = 200.0, image_path = "@Str")
        val file2 = File(name="Music", downloadsCount = 5, description = "Shajarian", size = 20.0, image_path = "@Str")
        val file3 = File(name="Film", downloadsCount = 3, description = "The Final Destination", size = 2000.2, image_path = "@Str")

        this.addFile(file1)
        this.addFile(file2)
        this.addFile(file3)
    }
}