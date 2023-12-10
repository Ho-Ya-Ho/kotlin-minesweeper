package v1.controller

import v1.domain.GameBoard
import v1.domain.BoardSettings
import v1.domain.Point
import v1.domain.enums.GameStatus
import v1.dto.GameBoardDto
import v1.dto.GameResultDto
import v1.view.InputView
import v1.view.OutputView

fun main() {
    val gameBoard = gameSetUp()
    val gameResult = gameStart(gameBoard)
    OutputView.printGameResult(gameResult)
}

private fun gameSetUp(): GameBoard {
    OutputView.printEnterHeight()
    val height = InputView.inputNumber()
    OutputView.printEnterWidth()
    val width = InputView.inputNumber()
    OutputView.printEnterMineCount()
    val mineCount = InputView.inputNumber()
    val boardSettings = BoardSettings(height, width, mineCount)

    return GameBoard.of(boardSettings)
}

private fun gameStart(gameBoard: GameBoard): GameResultDto {
    OutputView.printMineGameStart()
    while (true) {
        val point = openCells(gameBoard)
        if (gameBoard.getGameStatus(point) != GameStatus.PLAYING) { break }
        printGameBoard(gameBoard)
    }

    return GameResultDto(gameBoard)
}

private fun printGameBoard(gameBoard: GameBoard) {
    val gameBoardDto = GameBoardDto(gameBoard)
    OutputView.printGameBoard(gameBoardDto)
}

private fun openCells(gameBoard: GameBoard): Point {
    OutputView.printOpen()
    val inputPoint = InputView.inputPoint()
    val point = Point.parsePoint(inputPoint)
    gameBoard.openCells(point)

    return point
}
