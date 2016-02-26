class TicTacToe(val board: List[Char]) {
   val myBoard = board
   if(!this.isSizedCorrectly()) {
      throw new IllegalArgumentException("Board is not sized correctly")
   }

   def isSizedCorrectly(): Boolean = if(myBoard.size == 9) true else false

   private val winningCombinations = List(
      (0, 1, 2),
      (3, 4, 5),
      (6, 7, 8),
      (0, 4, 8),
      (2, 4, 6),
      (0, 3, 6),
      (1, 4, 7),
      (2, 5, 8))

   def winner(): Char = {
      winningCombinations.foreach { combination =>
         if(myBoard(combination._1) == myBoard(combination._2) && myBoard(combination._2) == myBoard(combination._3)) {
            return myBoard(combination._1)
         }
      }
      return '_'
   }
}

var board = new TicTacToe(List(
   'O', 'X', 'O',
   'X', 'O', 'X',
   'X', 'O', 'O'))

println("Winner is " + board.winner)
