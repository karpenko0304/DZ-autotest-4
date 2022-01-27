import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;



import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Треугольник")
public class TriangleTest {

    @Test
    @DisplayName("Площадь треугольника: прямоугольный треугольник")
    @Disabled("Перенесены в параметризированный тест")
    public void countAreaEgyptTriangleTest() {
        Triangle triangle = new Triangle(3, 4, 5, 6); //Arrange
        int area = triangle.countArea(); //Act
        assertEquals(6, area); //Assert
    }

    @Test
    @DisplayName("Площадь треугольника: равносторонний треугольник")
    @Disabled("Перенесены в параметризированный тест")
    public void countAreaTriangleWithEqualsSidesTest() {
        Triangle triangle = new Triangle(3, 3, 3, 4.5); //Arrange
        int area = triangle.countArea(); //Act
        assertEquals(3.897, area); //Assert
    }

    @Test
    @DisplayName("Площадь треугольника: тупоугольный треугольник")
    @Disabled("Перенесены в параметризированный тест")
    public void angleGreaterThan90AreaTest() {
        Triangle triangle = new Triangle(3, 4, 6, 6.5); //Arrange
        int area = triangle.countArea(); //Act
        assertEquals(5.333, area); //Assert
    }


    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5, 6), 6),
                Arguments.of(new Triangle(3, 3, 3, 4.5), 3),
                Arguments.of(new Triangle(3, 4, 6, 6.5), 5)
        );
    }

    @ParameterizedTest(name = "Площадь треугольника {0} равен {1}")
    @MethodSource("triangles")
    public void countAreaTriangleTest(Triangle triangle, double expectedArea) {
        int area = triangle.countArea(); //Act
        assertEquals(expectedArea, area); //Assert
    }
}