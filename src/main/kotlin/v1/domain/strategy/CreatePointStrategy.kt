package v1.domain.strategy

import v1.domain.BoardSettings
import v1.domain.Point

interface CreatePointStrategy {
    fun createMinePoints(boardSettings: BoardSettings): List<Point>
}
