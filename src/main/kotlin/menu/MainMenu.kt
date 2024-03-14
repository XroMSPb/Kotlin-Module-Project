package menu

import achives.Archive

class MainMenu(private val listOfArchive: List<Archive>): Menu {
    override fun getHeadOfMenu(): String = "Список архивов:"
    override fun getMenuItems(): List<String> {
        var listOfArch: MutableList<String> = listOf()
        if (!listOfArchive.isEmpty())
            for (arch in listOfArchive)
                listOfArch.add(arch.toString())
        return listOf("Создать архив", listOfArch , "Выход")
    }

}