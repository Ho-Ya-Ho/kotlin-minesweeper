package domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameBoardTest {

    @Test
    fun `높이, 너비를 입력하면 그 크기만큼 gameBoard 가 만들어 진다`() {
        val boardSettings = BoardSettings(height = 10, width = 3, mineCount = 5)
        val gameBoard = GameBoard.createGameBoard(boardSettings)

        assertEquals(10, gameBoard.board.size)
        assertEquals(3, gameBoard.board[0].size)
    }

    @Test
    fun `mineCount 의 갯수 만큼 지뢰가 만들어진다`() {
        val boardSettings = BoardSettings(height = 10, width = 3, mineCount = 4)
        val gameBoard = GameBoard.createGameBoard(boardSettings)

        var mineCount = 0
        gameBoard.board.forEach { row ->
            row.forEach { cell ->
                if (cell == GameBoard.MINE) {
                    mineCount++
                }
            }
        }
        assertEquals(4, mineCount)
    }
}