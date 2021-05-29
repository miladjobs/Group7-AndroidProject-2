package ir.iust.group7_androidproject_2.data

class FakeDatabase private constructor(){
    var fileList = FileList()
        private set

    companion object{
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(lock = this){
            instance ?: FakeDatabase().also { instance = it }
        }
    }
}