package v1.domain.strategyImpl

import v1.domain.BoardSettings
import v1.domain.Point
import v1.domain.strategy.CreatePointStrategy

class RandomPointFactory : CreatePointStrategy {
    override fun createMinePoints(boardSettings: BoardSettings): List<Point> {
        val minePoints = mutableListOf<Point>()
        while (minePoints.size < boardSettings.mineCount) {
            addPoint(boardSettings, minePoints)
        }
        return minePoints
    }

    private fun addPoint(boardSettings: BoardSettings, minePoints: MutableList<Point>) {
        val point = Point((0 until boardSettings.row).random(), (0 until boardSettings.col).random())
        if (!minePoints.contains(point)) { minePoints.add(point) }
    }
}
