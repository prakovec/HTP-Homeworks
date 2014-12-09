package by.htp.krozov.homework.matrix;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MatrixTest {

    @Test
    public void testRotate90() {
        Matrix m = new Matrix(2, 3);
        m.set(1, 1, 1);
        m.set(1, 2, 2);
        m.set(1, 3, 3);
        m.set(2, 1, 4);
        m.set(2, 2, 5);
        m.set(2, 3, 6);

        Matrix expectedRotate90 = new Matrix(3, 2);
        expectedRotate90.set(1, 1, 4);
        expectedRotate90.set(1, 2, 1);
        expectedRotate90.set(2, 1, 5);
        expectedRotate90.set(2, 2, 2);
        expectedRotate90.set(3, 1, 6);
        expectedRotate90.set(3, 2, 3);

        Matrix rotatedMatrix = m.rotate(90);
        Assert.assertNotNull(rotatedMatrix);
        Assert.assertEquals(expectedRotate90, rotatedMatrix);
    }

    @Test
    public void testIsIdentity(){
        Matrix matrix = new Matrix(2, 2);
        matrix.set(1, 1, 1);
        matrix.set(2, 2, 1);
        Assert.assertTrue(matrix.isIdentity());

        Matrix squareZeroMatrix = new Matrix(10, 10);
        Assert.assertFalse(squareZeroMatrix.isIdentity());
    }

    @Test
    public void testCreateIdentity(){
        int maxSize = 100;
        for (int size = 1; size <= maxSize; size++) {
            Matrix identityMatrix = new Matrix(size);
            for (int i = 1, matrixSize = identityMatrix.getSize().rows; i <= matrixSize; i++) {
                identityMatrix.set(i, i, 1);
            }
            Assert.assertEquals(identityMatrix, Matrix.getIdentityMatrix(size));
        }
    }

    @Test
    public void testRotate0() {
        Matrix matrix = new Matrix(2, 3);
        matrix.set(1, 1, 1);
        matrix.set(1, 2, 2);
        matrix.set(1, 3, 3);
        matrix.set(2, 1, 4);
        matrix.set(2, 2, 5);
        matrix.set(2, 3, 6);

        Matrix rotate0Matrix = matrix.rotate(0);
        Assert.assertNotSame(matrix, rotate0Matrix);
        Assert.assertEquals(matrix, rotate0Matrix);
    }
}
