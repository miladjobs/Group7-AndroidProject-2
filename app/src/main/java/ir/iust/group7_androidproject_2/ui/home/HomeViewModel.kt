package ir.iust.group7_androidproject_2.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.iust.group7_androidproject_2.data.FileRepository
import ir.iust.group7_androidproject_2.ui.file_detail.FileViewModel

class HomeViewModel(private val fileRepository: FileRepository): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FileViewModel(fileRepository) as T
    }
}