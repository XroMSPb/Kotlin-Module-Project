package menu

import achives.Archive

class MainMenu(private val listOfArchive: List<Archive>): Menu {
    override fun getHeadOfMenu(): String = "Список архивов:"
    override fun getMenuItems(): List<String> {
        return listOf("Создать архив", listOfArchive.toString(), "Выход")
    }

}