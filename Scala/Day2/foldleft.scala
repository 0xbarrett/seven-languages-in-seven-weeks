// Use foldLeft to compute the total size of a list of strings.

object StringListSize {
   def getListSize(list: List[String]): Int = {
         (0 /: list) {(sum, i) => sum + i.size}
   }
}

println(StringListSize.getListSize(List("a", "bcd", "efgh")))
