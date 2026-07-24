class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        return check(board, word) || check(board, new StringBuilder(word).reverse().toString());
    }

    private boolean check(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int len = word.length();

        // Check rows
        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < n) {
                while (j < n && board[i][j] == '#') {
                    j++;
                }

                int start = j;
                while (j < n && board[i][j] != '#') {
                    j++;
                }

                if (j - start == len) {
                    boolean match = true;
                    for (int k = 0; k < len; k++) {
                        if (board[i][start + k] != ' ' &&
                            board[i][start + k] != word.charAt(k)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        return true;
                    }
                }
            }
        }

        // Check columns
        for (int j = 0; j < n; j++) {
            int i = 0;
            while (i < m) {
                while (i < m && board[i][j] == '#') {
                    i++;
                }

                int start = i;
                while (i < m && board[i][j] != '#') {
                    i++;
                }

                if (i - start == len) {
                    boolean match = true;
                    for (int k = 0; k < len; k++) {
                        if (board[start + k][j] != ' ' &&
                            board[start + k][j] != word.charAt(k)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
