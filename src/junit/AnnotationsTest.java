package junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

@RunWith(Suite.class)
@Suite.SuiteClasses({JunitTest1.class,JunitTest2.class})
public class AnnotationsTest {

    private ArrayList testList;

    @BeforeClass
    public static void onceExecuteBeforeAll(){
        System.out.println("@BeforeClass: onceExecuteBeforeAll");
    }
    @Before
    public void executeBeforeEach(){
        testList=new ArrayList();
        System.out.println("@Before: executeBeforeEach");
    }
    @AfterClass
    public static void onceExecuteAfterAll(){
        System.out.println("@AfterClass: oncExecuteAfterAll");
    }
    @After
    public void executedAfterEach() {
        testList.clear();
        System.out.println("@After: executedAfterEach");
    }
    @Test
    public void EmptyCollection() {
        assertTrue(testList.isEmpty());
        System.out.println("@Test: EmptyArrayList");
    }
    @Test
    public void OneItemCollection() {
        testList.add("oneItem");
        assertEquals(1, testList.size());
        System.out.println("@Test: OneItemArrayList");
    }
    @Ignore
    public void executionIgnored() {

        System.out.println("@Ignore: This execution is ignored");
    }
    @Test
    public void test(){
        String obj1 = "junit";
        String obj2 = "junit";
        String obj3 = "test";
        String obj4 = "test";
        String obj5 = null;
        int var1 = 1;
        int var2 = 1;
        int[] arithmetic1 = { 1, 2, 3 };
        int[] arithmetic2 = { 1, 2, 3 };
        assertEquals(obj1, obj2);
        assertSame(obj3, obj4);
        assertNotSame(obj2, obj4);
        assertNotNull(obj1);
        assertNull(obj5);
        assertTrue(var1==var2);
        assertArrayEquals(arithmetic1, arithmetic2);
    }
}
