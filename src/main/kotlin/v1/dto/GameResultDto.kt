package v1.dto

import v1.domain.GameBoard

data class GameResultDto(val status: String) {
    constructor(gameBoard: GameBoard) : this(gameBoard.gameResult.gameStatus.name)
}
