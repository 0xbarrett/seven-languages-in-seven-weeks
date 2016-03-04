// Write a Censor trait with a method that will replace the curse words Shoot and Darn
// with Pucky and Beans alternatives. Use a map to store the curse words and their alternatives.

trait Censor {
   def censor(list: List[String]): List[String] = {
      val alternatives = Map("Shoot" -> "Pucky", "Darn" -> "Beans")
      var newList
      list.foreach(word => newList.addString(alternatives(word)))

      return newList
   }
}
