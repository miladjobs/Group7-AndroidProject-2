package ir.iust.group7_androidproject_2.utils

import ir.iust.group7_androidproject_2.data.FileRepository
import ir.iust.group7_androidproject_2.data.FakeDatabase
import ir.iust.group7_androidproject_2.ui.home.HomeViewModel

object DataInjector {

    fun provideFileViewModelFactory(): HomeViewModel{
        val fileRepository = FileRepository.getInstance(FakeDatabase.getInstance().fileList)
        return HomeViewModel(fileRepository)
    }

}