package com.codewars.huzaus.streetfighters2;

import static java.util.Arrays.stream;

public class Solution {

    private enum Movement {
        RIGHT {
            @Override
            int[] move(int width, int height, int[] position) {
                return setX(position, (x(position) == width - 1) ? 0 : x(position) + 1);
            }
        },
        LEFT {
            @Override
            int[] move(int width, int height, int[] position) {
                return setX(position, (x(position) == 0) ? width - 1 : x(position) - 1);
            }
        },
        UP {
            @Override
            int[] move(int width, int height, int[] position) {
                return setY(position, (y(position) == 0) ? 0 : y(position) - 1);
            }
        },
        DOWN {
            @Override
            int[] move(int width, int height, int[] position) {
                return setY(position, (y(position) == height - 1) ? height - 1 : y(position) + 1);
            }
        }
        ;

        abstract int[] move(int width, int height, int[] position);
    }

    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
        validate(fighters, position, moves);

        return stream(moves)
                   .map(String::toUpperCase)
                   .map(Movement::valueOf)
                   .map(movement -> movement.move(width(fighters[y(position)]), height(fighters), position))
                   .map(fighterPosition -> fighter(fighters, fighterPosition))
                   .toArray(String[]::new);
    }

    private static int width(String[] fighterRow) {
        return fighterRow.length;
    }

    private static int height(String[][] fighters) {
        return fighters.length;
    }

    private static int x(int[] position) {
        return position[0];
    }

    private static int[] setX(int[] position, int value) {
        position[0] = value;
        return position;
    }

    private static int[] setY(int[] position, int value) {
        position[1] = value;
        return position;
    }

    private static String fighter(String[][] fighters, int[] position) {
        return fighters[y(position)][x(position)];
    }

    private static int y(int[] position) {
        return position[1];
    }

    private static void validate(String[][] fighters, int[] position, String[] moves) {
        if (fighters == null || position == null || moves == null) {
            throw new IllegalArgumentException();
        }

        if (height(fighters) == 0 || position.length != 2 || height(fighters) <= y(position) || width(fighters[y(position)]) <= x(
            position)) {
            throw new IllegalArgumentException();
        }
    }
}