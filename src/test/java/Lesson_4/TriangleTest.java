package Lesson_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class TriangleTest {
    @Test
    void triangleAreaTest() {
        Triangle triangle = new Triangle(7, 7, 7);
        String actualResult = triangle.calculateArea();
        Assertions.assertEquals(21.218, actualResult);
    }

}