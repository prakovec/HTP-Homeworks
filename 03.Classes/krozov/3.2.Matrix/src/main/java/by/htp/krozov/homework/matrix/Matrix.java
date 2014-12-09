package by.htp.krozov.homework.matrix;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Arithmetic matrix.
 * Class is unmodifiable. Every modification operation create new Matrix object as a result.
 */
public class Matrix {
    private final Size size;
    private final int[][] values;

    /**
     * Create square matrix.
     *
     * @param size Matrix size. Number of columns is equals number of rows.
     */
    public Matrix(int size) {
        this(new Size(size));
    }

    public Matrix(Matrix matrix) {
        this.size = new Size(matrix.size);
        this.values = new int[matrix.size.rows][matrix.size.columns];
        System.arraycopy(matrix.values, 0, this.values, 0, matrix.values.length);
    }

    /**
     * Create matrix.
     *
     * @param rows    Number of rows.
     * @param columns Number of columns.
     */
    public Matrix(int rows, int columns) {
        this(new Size(rows, columns));
    }

    private Matrix(@NotNull Size size) {
        this.size = new Size(size);
        this.values = new int[size.rows][size.columns];
    }

    public int get(int row, int column) {
        if (size.isInBounds(row, column)) {
            return values[row - 1][column - 1];
        } else {
            throw new RuntimeException("Can't get item. Item position isn't valid.");
        }
    }

    public Matrix rotate(int angle) {
        if (angle % 90 != 0) {
            throw new RuntimeException("Angle must be divided by 90.");
        }

        int rotate90Count;
        if (angle < 0) {
            rotate90Count = (angle % 360 + 360) / 90;
        } else {
            rotate90Count = (angle % 360) / 90;
        }

        Matrix result = new Matrix(this);
        for (int rotate = 0; rotate < rotate90Count; rotate++) {
            result = result.rotate90();
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < size.rows; row++) {
            for (int columns = 0; columns < size.columns; columns++) {
                builder.append(String.format("%6d", values[row][columns]));
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    private Matrix rotate90() {
        Matrix result = new Matrix(size.columns, size.rows);
        for (int row = 0; row < result.size.rows; row++) {
            for (int column = 0; column < result.size.columns; column++) {
                result.values[row][column] = values[result.size.columns - 1 - column][row];
            }
        }
        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix(size.columns, size.rows);
        for (int row = 0; row < result.size.rows; row++) {
            for (int column = 0; column < result.size.columns; column++) {
                result.values[row][column] = values[column][row];
            }
        }
        return result;
    }

    public static Matrix getIdentityMatrix(int size) {
        Matrix identityMatrix = new Matrix(size);
        for (int i = 0; i < identityMatrix.size.rows; i++) {
            identityMatrix.values[i][i] = 1;
        }
        return identityMatrix;
    }

    public boolean isIdentity() {
        if (isSquare()) {
            for (int row = 0; row < size.rows; row++) {
                for (int column = 0; column < size.columns; column++) {
                    if (row != column) {
                        if (values[row][column] != 0) {
                            return false;
                        }
                    } else if (values[row][column] != 1) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void set(int row, int column, int value) {
        if (size.isInBounds(row, column)) {
            values[row - 1][column - 1] = value;
        } else {
            throw new RuntimeException("Can't set item. Item position isn't valid.");
        }
    }

    public Matrix add(@NotNull Matrix m) {
        if (size.equals(m.size)) {
            Matrix result = new Matrix(size);
            for (int row = 0; row < result.size.rows; row++) {
                for (int column = 0; column < result.size.columns; column++) {
                    result.values[row][column] =
                            m.values[row][column] + values[row][column];
                }
            }
            return result;
        } else {
            throw new RuntimeException("Can't compute sum of matrix with different sizes.");
        }
    }

    public Matrix multiply(int value) {
        Matrix result = new Matrix(size);
        for (int row = 0; row < result.size.rows; row++) {
            for (int column = 0; column < result.size.columns; column++) {
                result.values[row][column] = this.values[row][column] *= value;
            }
        }
        return result;
    }

    public Matrix multiplyRight(@NotNull Matrix rightMultiplier) {
        if (this.size.columns == rightMultiplier.size.rows) {
            Matrix result = new Matrix(this.size.rows, rightMultiplier.size.columns);
            for (int row = 0; row < result.size.rows; row++) {
                for (int column = 0; column < result.size.columns; column++) {
                    for (int i = 0; i < this.size.columns; i++) {
                        result.values[row][column] +=
                                this.values[row][i] * rightMultiplier.values[i][column];
                    }
                }
            }
            return result;
        } else {
            throw new RuntimeException("Can't multiply matrix.");
        }
    }

    public Matrix multiplyLeft(@NotNull Matrix leftMultiplier) {
        return leftMultiplier.multiplyRight(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Matrix matrix = (Matrix) o;
        return Arrays.deepEquals(values, matrix.values);

    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(values);
    }

    public Size getSize() {
        return size;
    }

    public boolean isSquare() {
        return size.rows == size.columns;
    }

    /**
     * Representation of matrix size.
     */
    public static class Size {
        public final int rows;
        public final int columns;

        private Size(int rows) {
            this(rows, rows);
        }

        private Size(@NotNull Size size) {
            this.rows = size.rows;
            this.columns = size.columns;
        }

        private Size(int rows, int columns) {
            if (rows < 1 || columns < 1) {
                throw new RuntimeException(
                        String.format("Illegal size of matrix (%d, %d)", rows, columns));
            }
            this.rows = rows;
            this.columns = columns;
        }

        private boolean isInBounds(int row, int column) {
            return 1 <= row && row <= rows
                    && 1 <= column && column <= columns;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Size size = (Size) o;
            return columns == size.columns && rows == size.rows;

        }

        @Override
        public int hashCode() {
            return 31 * rows + columns;
        }
    }
}
