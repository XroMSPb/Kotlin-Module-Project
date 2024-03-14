import achives.Archive
import menu.*

fun main(args: Array<String>) {
    var archives: MutableList<Archive> = listOf()
    val firstScreen = DisplayMenu(Screens.SELECT_ARCH, MainMenu(archives))
    firstScreen.printMenu()
}