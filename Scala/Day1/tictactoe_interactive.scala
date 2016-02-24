import scala.io

class TicTacToe() {
  var board = Array(
    '_', '_', '_',
    '_', '_', '_',
    '_', '_', '_')

  def clear() = {
    board = Array(
      '_', '_', '_',
      '_', '_', '_',
      '_', '_', '_')
  }

  def isValidRowOrColumn(rowOrColumn: Int): Boolean = {
    return (rowOrColumn > 0 && rowOrColumn <= 3)
  }

  def newGame() = {
    this.clear
    var turn = 'X'
    var tryAgain = false
    var winner = '_'

    while(winner == '_') {
      println("Your turn " + turn + ", pick a row: ")
      val row = scala.io.StdIn.readChar.asDigit

      if(!isValidRowOrColumn(row)) {
        println("Quit screwing around! The only valid rows are 1, 2, and 3")
        tryAgain = true
      } else {
        println("Pick a column: ")
        val column = scala.io.StdIn.readChar.asDigit

        if(!isValidRowOrColumn(column)) {
          println("Quit screwing around! The only valid columns are 1, 2, and 3")
          tryAgain = true
        } else {
          if(board((column - 1) + ((row - 1) * 3)) != '_') {
            println("That cell is already taken, try again")
            tryAgain = true
          } else {
            board((column - 1) + ((row - 1) * 3)) = turn
          }
        }
      }

      board.slice(0, 3).foreach { char => print(char + " ") }
      println("")
      board.slice(3, 6).foreach { char => print(char + " ") }
      println("")
      board.slice(6, 9).foreach { char => print(char + " ") }
      println("")

      if(!tryAgain) {
        if(turn == 'X') turn = 'O' else turn = 'X'
      }

      tryAgain = false
      winner = this.winner
    }

    println("Winner is " + this.winner)
  }
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
      if(board(combination._1) == board(combination._2) && board(combination._2) == board(combination._3)) {
        return board(combination._1)
      }
    }
    return '_'
  }
}

   var board = new TicTacToe()
   board.newGame()
