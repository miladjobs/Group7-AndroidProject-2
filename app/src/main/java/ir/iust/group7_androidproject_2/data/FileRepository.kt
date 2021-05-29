package ir.iust.group7_androidproject_2.data

class FileRepository private constructor(private val fileList:FileList){
    fun addFile(file: File){
        fileList.addFile(file)
    }

    fun getFiles() = fileList.getFiles()

    fun getFile(id: Int): File{
        return fileList.getFile(id)
    }

    companion object{
        @Volatile private var instance: FileRepository ? = null

        fun getInstance(fileLise: FileList) = instance ?: synchronized(lock = this){
            instance ?: FileRepository(fileLise).also { instance = it }
        }
    }

}