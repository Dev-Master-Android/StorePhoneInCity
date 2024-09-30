package phoneStore.util


import java.util.Scanner

object InputReader {
    private val scanner = Scanner(System.`in`)

    fun readInt(): Int {
        return scanner.nextInt()
    }

    fun readString(): String {
        return scanner.next()
    }
}
