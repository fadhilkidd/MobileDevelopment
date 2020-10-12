package id.ac.ui.rahmatfadhilah.helloworld;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test_is_hello_world() {
        MainActivity mulai = new MainActivity();
        assertEquals(true, mulai.isHelloWorld("HELLO WORLD!"));
        assertEquals(false, mulai.isHelloWorld("NOT A HELLO WORLD!"));
    }
}