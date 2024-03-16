data class Note(val title: String, val content: String)
data class Archive(
    val name: String
){
    val notes: MutableList<Note> = mutableListOf()
    override fun toString(): String {
        return name
    }

    fun addNote() {
        println("Введите заголовок заметки:")
        val title = readlnOrNull().takeIf { it?.isNotBlank() == true } ?: run {
            println("Заголовок не может быть пустым.")
            return
        }
        println("Введите содержание заметки:")
        val content = readlnOrNull().takeIf { it?.isNotBlank() == true } ?: run {
            println("Содержание не может быть пустым.")
            return
        }
        notes.add(Note(title, content))
        println("Заметка добавлена в архив $name.")
    }

    fun viewNote(index: Int) {
        if (notes.isEmpty())
            println("В архиве $name нет заметок.")
        else{
            println("Содержимое заметки ${notes[index].title}:")
            println("\u001B[32m ${notes[index].content}\u001B[0m")
            }
    }

}
