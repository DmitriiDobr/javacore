import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestAlgosCheck {


    @Test
    public void testbubbleSort(){
        int[] actual = {3,2,6,1,5,4}; int[] expected = {1,2,3,4,5,6};
        int[] result = AlgosCheck.bubbleSort(actual);
        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    public void testVstavkaSort(){
        int[] actual = {3,2,6,1,5,4}; int[] expected = {1,2,3,4,5,6};
        int[] result = AlgosCheck.vstavkaSort(actual);
        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    public void testlinearSearch(){
        int[] actual = {3,2,6,1,5,4}; int number = 6; int expectedIndex = 2;
        int result = AlgosCheck.linearSearch(actual,number);
        Assertions.assertEquals(expectedIndex,result);
    }




}












