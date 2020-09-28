package id.ac.ui.cs.mobileprogramming.muhammadirfanamrullah.lab

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CounterUnitTest {

    @Test
    fun `addOne really adding one`() {
        val result = MainActivity().addOne(1)
        assertEquals(2, result)
    }
}
