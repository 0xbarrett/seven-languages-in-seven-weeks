import scala.io._
import scala.actors._
import Actor._

object PageLoader {
  def getPageSize(url : String) = Source.fromURL(url).mkString.length

  def getPageLinkCount(url : String) = {
    val source = Source.fromURL(url).mkString
    val linkRegex = "(?i)<a.+?href=\"(http.+?)\".*?>(.+?)</a>".r

    linkRegex.findAllIn(source).size
  }
}

var urls = List("http://www.amazon.com/",
                "http://www.cnn.com",
                "https://github.com",
                "https://twitter.com/search")

def timeMethod(method: () => Unit) = {
  val start = System.nanoTime
  method()
  val end = System.nanoTime
  println("Method took " + (end - start)/100000000000.0 + "seconds.")
}

def getPageSizeSequentially() = {
  for(url <- urls) {
    println("Size for " + url + ": " + PageLoader.getPageSize(url))
  }
}

def getPageSizeConcurrently() = {
  val caller = self

  for(url <- urls) {
    actor { caller ! (url, PageLoader.getPageSize(url)) }
  }

  for(i <- 1 to urls.size) {
    receive {
      case (url, size) =>
        println("Size for " + url + ": " + size)
    }
  }
}

def getNumberOfLinksSequentially() = {
  for(url <- urls) {
    println("Link count for  " + url + ": " + PageLoader.getPageLinkCount(url))
  }

}

println("Sequential run:")
timeMethod { getPageSizeSequentially }

println("Concurrent run:")
timeMethod { getPageSizeConcurrently }

timeMethod { getNumberOfLinksSequentially }
