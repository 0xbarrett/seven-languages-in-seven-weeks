// Write a Censor trait with a method that will replace the curse words
// Shoot and Darn with Pucky and Beans alternatives.
// Use a map to store the curse words and their alternatives.

trait Censor {
   def censor(list: List[String]): List[String] = {
      val alternatives = Map("Shoot" -> "Pucky", "Darn" -> "Beans")
      var newList = new StringBuilder
      
      list.foreach { word =>
         if(alternatives.contains(word)) {
            alternatives(word).addString(newList)
         } else {
            word.addString(newList)
         }
      }
      return List(newList.mkString)
   }
}

object Censorer extends Censor {

}

println(Censorer.censor(List("Shoot, Darn")))
