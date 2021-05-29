package ir.iust.group7_androidproject_2.ui.file_detail

import androidx.lifecycle.ViewModel
import ir.iust.group7_androidproject_2.data.File
import ir.iust.group7_androidproject_2.data.FileRepository

class FileViewModel(private val fileRepository: FileRepository): ViewModel() {
    fun getFiles() = fileRepository.getFiles()

    fun getFile(id: Int): File = fileRepository.getFile(id)

    fun addFile(file: File) = fileRepository.addFile(file)

    fun initializeData(){
        val file1 = File(name="Book", downloadsCount = 10, description = "Mathematics", size = 200.0, image_path = "https://www.google.com/url?sa=i&url=http%3A%2F%2Fhardworkingteachers.blogfa.com%2Fpost%2F37%2F%25D8%25B1%25DB%258C%25D8%25A7%25D8%25B6%25DB%258C-%25D8%25B4%25D8%25B4%25D9%2585-%25D8%25AF%25D8%25A8%25D8%25B3%25D8%25AA%25D8%25A7%25D9%2586&psig=AOvVaw08l60lzXYQXXwLsYWQE1DC&ust=1622407016506000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLj2-6Lf7_ACFQAAAAAdAAAAABAD")
        val file2 = File(name="Music", downloadsCount = 5, description = "Shajarian", size = 20.0, image_path = "@Str")
        val file3 = File(name="Film", downloadsCount = 3, description = "The Final Destination", size = 2000.2, image_path = "@Str")

        this.addFile(file1)
        this.addFile(file2)
        this.addFile(file3)
    }
}