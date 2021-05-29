package ir.iust.group7_androidproject_2.data

data class File(val name: String, val downloadsCount: Int, val description: String, val size: Double, val image_path: String) {
    override fun toString(): String {
        return name
    }
}