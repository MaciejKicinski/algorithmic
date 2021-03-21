import org.junit.Assert;
import org.junit.Test;

public class CircularListTest {
    /**
     * @Test sprawdza wyświetlanie wielomianu a)
     */
    @Test
    public void firstPolynomialTest() {
        //Given
        String firstPolynomial = "+88x^40 +6x^30 -25x^1";
        CircularList circularList = new CircularList();
        circularList.add(88, 40);
        circularList.add(6, 30);
        circularList.add(-25, 1);
        //when
        String result = circularList.displayPolynomial().trim();
        //then
        Assert.assertEquals(firstPolynomial, result);
    }
    /**
     * @Test sprawdza wyświetlanie wielomianu b)
     */
    @Test
    public void secondPolynomialTest() {
        //Given
        String secondPolynomial = "-5x^18 +2x^10 +7x^4 -2";
        CircularList circularList = new CircularList();
        circularList.add(-5, 18);
        circularList.add(2, 10);
        circularList.add(7, 4);
        circularList.add(-2, 0);
        circularList.displayPolynomial();

        //when
        String result = circularList.displayPolynomial().trim();
        //then
        Assert.assertEquals(secondPolynomial, result);
    }
    /**
     * @Test sprawdza wyświetlanie wielomianu c)
     */
    @Test
    public void thirdPolynomialTest() {
        //Given
        String thirdPolynomial = "";
        CircularList circularList = new CircularList();

        circularList.displayPolynomial();

        //when
        String result = circularList.displayPolynomial().trim();
        //then
        Assert.assertEquals(thirdPolynomial, result);
    }

    /**
     * @Test sprawdza czy działanie metody delete,
     * porównuje ilość elementów wielomianu, pomija pierwszy element listy (0,-1)
     */
    @Test
    public void deleteMethodTest() {
        //Given
        int sizeOfCircularList = 2;
        CircularList circularList = new CircularList();
        circularList.add(88, 40);
        circularList.add(6, 30);
        circularList.add(-25, 1);
        //when
        circularList.deleteLast();
        //then
        Assert.assertEquals(sizeOfCircularList, circularList.returnNumberOfNodes());
    }
}
