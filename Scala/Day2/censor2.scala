// Write a Censor trait with a method that will replace the curse words
// Shoot and Darn with Pucky and Beans alternatives.
// Use a map to store the curse words and their alternatives.

trait Censor {
   //protected val content
   def censor: String = {
       val substitutions = Map("Shoot" -> "Pucky", "Darn" -> "Beans")

       substitutions.foldLeft(toString) {
          case (string, (key, value)) => string.replaceAll(key, value)
       }
   }
}

class Censorer extends Censor {
   override def toString(): String = {
      "Shoot, and Darn"
   }
}

val censorer = new Censorer
println(censorer.censor)
println(censorer.toString)
