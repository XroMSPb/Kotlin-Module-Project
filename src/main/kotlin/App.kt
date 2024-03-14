import java.util.*

class App(private val scanner: Scanner = Scanner(System.`in`)) {
    private val archives: MutableList<Archive> = mutableListOf()

    fun run() {
        while (true) {
            val items = getMenuItems()
            printMenu("Список архивов:", items)
            val itemsCount = items.count()

            val choice = readInt()
            if (choice in 1..archives.size) {
                manageArchive(archives[choice - 1])
            } else {
                when (choice) {
                    0 -> addArchive()
                    (itemsCount - 1) -> {
                        println("Программа завершена.")
                        return
                    }
                    else -> println("Некорректный выбор. Введите число от 0 до ${items.count()-1}.")
                }
            }
        }
    }

    private fun getMenuItems(): List<String> {
        var listOfArch: MutableList<String> = mutableListOf()
        if (archives.isNotEmpty())
            listOfArch =  archives.map{it.toString()}.toMutableList()

        listOfArch.addFirst("Создать архив")
        listOfArch.addLast("Выход")
        return listOfArch
    }
    private fun printMenu(header: String, items:List<String>) {
        println(header)
        for ((i, item) in items.withIndex()) {
            println("$i. $item")
        }
    }
    private fun addArchive() {
        println("Введите название архива:")
        val archiveName = readlnOrNull().takeIf { it?.isNotBlank() == true } ?: run {
            println("Название архива не может быть пустым.")
            return
        }
        archives.add(Archive(archiveName))
        println("Архив $archiveName добавлен.")
    }

    private fun manageArchive(archive: Archive) {
        while (true) {
            printMenu("Управление архивом ${archive.name}:",
                listOf("Добавить заметку", "Просмотреть заметки", "Назад"))

            when (readInt()) {
                0 -> archive.addNote()
                1 -> manageNotes(archive)
                2 -> {
                    println("Возврат к выбору архива.")
                    return
                }
                else -> println("Некорректный выбор. Введите число от 0 до 2.")
            }
        }
    }

    private fun manageNotes(archive: Archive) {
        if (archive.notes.isEmpty()) {
            println("В архиве ${archive.name} нет заметок.")
        } else {
            while (true) {
                val list: MutableList<String> = mutableListOf()
                for (note in archive.notes)
                    list.add(note.title)
                list.add("Назад")
                printMenu("Список заметок в архиве ${archive.name}:",list)
                when (val count = readInt()) {
                    list.size-1 -> {
                        manageArchive(archive)
                        return
                    }
                    else -> archive.viewNote(count)
                }
            }
        }
    }

    private fun readInt(): Int {
        while (true) {
            val input = scanner.nextLine()
            val number = input.toIntOrNull()
            if (number != null) {
                return number
            } else {
                println("Некорректный ввод. Введите число.")
            }
        }
    }
}