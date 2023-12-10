package v1.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import v1.domain.NeighborMineCount

class NeighborMineCountTest {
    @Test
    fun `NeighborMineCount 생성시 음수가 들어오면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            NeighborMineCount(-1)
        }
    }
}
