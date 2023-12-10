package v1.domain

import v1.domain.enums.GameStatus
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import v1.domain.BoardSettings
import v1.domain.GameBoard
import v1.domain.GameResult
import v1.domain.Point

class GameResultTest {

    private lateinit var gameBoard: GameBoard

    @BeforeEach
    fun setUp() {
        val boardSettings = BoardSettings(row = 3, col = 3, mineCount = 0)
        gameBoard = GameBoard.of(boardSettings)
    }

    @Test
    fun `Mine 이 있는 Cell 을 선택하였을 경우 LOSE 를 반환한다`() {
        gameBoard.board[1].cells[1].installMine()

        val gameResult = GameResult(GameStatus.PLAYING)
        val gameStatus = gameResult.getGameStatus(Point(1, 1), gameBoard.board)
        assertEquals(GameStatus.LOSE, gameStatus)
    }

    @Test
    fun `지뢰를 제외한 모든 Cell 에 open 이 되었을 경우 WIN 을 반환한다`() {
        installMines()
        gameBoard.board[2].cells[2].openCell()
        val gameResult = GameResult(GameStatus.PLAYING)

        val gameStatus = gameResult.getGameStatus(Point(2, 2), gameBoard.board)
        assertEquals(GameStatus.WIN, gameStatus)
    }

    private fun installMines() {
        val minePoints = listOf(
            Point(0, 0), Point(0, 1), Point(0, 2),
            Point(1, 0), Point(1, 1), Point(1, 2),
            Point(2, 0), Point(2, 1)
        )
        minePoints.forEach { gameBoard.board[it.row].cells[it.col].installMine() }
    }
}
