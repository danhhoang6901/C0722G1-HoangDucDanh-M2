package ss8_clean_code_refactoring.exercise;

public class TennisGame {
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FOURTY = 3;

    public static String getScore(String firstPlayerName, String secondPlayerName, int firstPlayerScore, int secondPlayerScore) {
        String score = "";
        int tempScore = 0;
        if (firstPlayerScore == secondPlayerScore) {
            return result(firstPlayerScore);
        }

        if (firstPlayerScore >= 4 || secondPlayerScore >= 4) {
            return win(firstPlayerScore, secondPlayerScore);
        }

        return currentScore(firstPlayerScore, secondPlayerScore, score);
    }

    public static String result(int firstPlayerScore) {
        switch (firstPlayerScore) {
            case LOVE:
                return "Love-All";
            case FIFTEEN:
                return "Fifteen-All";
            case THIRTY:
                return "Thirty-All";
            case FOURTY:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    public static String win(int firstPlayerScore, int secondPlayerScore) {
        int minusResult = firstPlayerScore - secondPlayerScore;
        if (minusResult == 1) {
            return "Advantage player1";
        }

        if (minusResult == -1) {
            return "Advantage player2";
        }

        if (minusResult >= 2) {
            return "Win for player1";
        }

        return "Win for player2";
    }

    public static String currentScore(int firstPlayerScore, int secondPlayerScore, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = firstPlayerScore;
            else {
                score += "-";
                tempScore = secondPlayerScore;
            }
            switch (tempScore) {
                case LOVE:
                    score += "Love";
                    break;
                case FIFTEEN:
                    score += "Fifteen";
                    break;
                case THIRTY:
                    score += "Thirty";
                    break;
                case FOURTY:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }
}
