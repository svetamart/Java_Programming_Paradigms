/*
Трассировка пути в лабиринте:
__
Описание: Имеется двумерный массив, представляющий лабиринт, где '0' - это проход, а '1' - это стена.
Начальная и конечная точки заданы. Необходимо определить путь от начальной до конечной точки.
Почему это структурное программирование:
Задача может быть решена с помощью последовательных шагов, ветвлений (проверка на наличие стены или уже посещенной клетки)
и циклов (для обработки всех возможных направлений движения).

Задание: Создайте функцию, которая принимает двумерный массив (лабиринт) и начальную и конечную точки.
Функция должна возвращать путь от начальной до конечной точки или сообщение, что путь невозможен.
Входные данные:
Двумерный массив размера MxN, где '0' - это проход, а '1' - это стена.
Координаты начальной и конечной точки.
Выходные данные:
Массив координат пути или сообщение об ошибке.
 */

package structured;

import java.util.*;

public class PathFinder {
    public static void main(String[] args) {

        int[][] maze = {
                {0, 1, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 1, 1},
                {0, 1, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0}
        };

        int[] start = {0, 0};
        int[] end = {4, 7};

        List<int[]> path = findPathInMaze(maze, start, end);
        if (path != null) {
            System.out.println("Путь найден!");
            for (int[] point : path) {
                System.out.println("(" + point[0] + ", " + point[1] + ")");
            }
            printMaze(maze, path);
        } else {
            System.out.println("Не удалось найти выход из лабиринта.");
        }
    }


    public static List<int[]> findPathInMaze(int[][] maze, int[] start, int[] end) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int numRows = maze.length;
        int numCols = maze[0].length;

        boolean[][] visited = new boolean[numRows][numCols];
        int[][] parentRow = new int[numRows][numCols];
        int[][] parentCol = new int[numRows][numCols];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == end[0] && current[1] == end[1]) {
                return bfs(parentRow, parentCol, start, end);
            }

            for (int[] direction : directions) {
                int newRow = current[0] + direction[0];
                int newCol = current[1] + direction[1];

                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols
                        && maze[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                    queue.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                    parentRow[newRow][newCol] = current[0];
                    parentCol[newRow][newCol] = current[1];
                }
            }
        }

        return null;
    }

    // алгоритм поиска в ширину (Breadth-first search)
    public static List<int[]> bfs(int[][] parentRow, int[][] parentCol, int[] start, int[] end) {
        List<int[]> path = new ArrayList<>();
        int[] current = end;

        while (current[0] != start[0] || current[1] != start[1]) {
            path.add(current);
            int newRow = parentRow[current[0]][current[1]];
            int newCol = parentCol[current[0]][current[1]];
            current = new int[]{newRow, newCol};
        }

        path.add(start);
        Collections.reverse(path);
        return path;
    }


    // метод печати лабиринта с разными цветами
    public static void printMaze(int[][] maze, List<int[]> path) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (isPathCell(i, j, path)) {
                    System.out.print("\u001B[31m");  // красим красным проложенный путь
                } else if (maze[i][j] == 1) {
                    System.out.print("\u001B[30m");  // стены лабиринта красим черным
                } else {
                    System.out.print("\u001B[37m");  // белым красим проходы
                }
                System.out.print(maze[i][j] + " ");
            }
            System.out.println("\u001B[0m"); // сброс цвета
        }
    }

    // проверяем, является ли ячейка частью проложенного пути от начальной до конечной точки
    private static boolean isPathCell(int row, int col, List<int[]> path) {
        for (int[] cell : path) {
            if (cell[0] == row && cell[1] == col) {
                return true;
            }
        }
        return false;
    }
}

/*

Метод с алгоритмом поиска в глубину.
Решила не использовать, потому что находился длинный и неоптимальный путь.


    public static List<int[]> findPathInMaze(int[][] maze, int[] start, int[] end) {
        List<int[]> path = new ArrayList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        if (dfs(maze, start, end, visited, path)) {
            Collections.reverse(path);
            return path;
        } else {
            return null;
        }
    }

    // алгоритм поиска в глубину (Depth-first search)
    private static boolean dfs(int[][] maze, int[] current, int[] end, boolean[][] visited, List<int[]> path) {
        if (current[0] == end[0] && current[1] == end[1]) {
            path.add(current);
            return true;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited[current[0]][current[1]] = true;

        for (int[] direction : directions) {
            int newRow = current[0] + direction[0];
            int newCol = current[1] + direction[1];

            if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length
                    && maze[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                if (dfs(maze, new int[]{newRow, newCol}, end, visited, path)) {
                    path.add(current);
                    return true;
                }
            }
        }
        return false;
    }

 */
