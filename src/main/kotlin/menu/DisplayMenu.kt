package menu

class DisplayMenu(val screen: Screens, private val menu: Menu) {
   // TODO("val callback")
    fun printMenu() {

        val items = menu.getMenuItems()
        println(menu.getHeadOfMenu())
        for ((i, item) in items.withIndex()) {
            println("$i. $item")
        }
    }

}