package achives

data class Archive(
    val name: String,
    val note: List<String>
){
    override fun toString(): String {
        return name
    }
}
