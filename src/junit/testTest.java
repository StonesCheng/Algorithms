package junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertEquals;
@RunWith(Suite.class)
@Suite.SuiteClasses({JunitTest1.class,JunitTest2.class})
public class testTest {

    junit.Test test=new junit.Test(2,5);
    @Test
    public void addAB() throws Exception {
        assertEquals(7,test.addAB());
    }
    @Test
    public void multiAB() throws Exception {
        assertEquals(10,test.multiAB());
    }

}