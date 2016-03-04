// Use foldLeft to compute the total size of a list of strings.

object StringListSize {
   def getListSize(list: List[String]) = {
      list.foldLeft(0)((sum, current) => sum + current.size)
   }
}

println(StringListSize.getListSize(List("a", "bcd", "efgh")))
