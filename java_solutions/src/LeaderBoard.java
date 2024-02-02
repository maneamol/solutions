/*
https://leetcode.com/problems/design-a-leaderboard/description/
Design a Leaderboard class, which has 3 functions:

addScore(playerId, score): Update the leaderboard by adding score to the given player's score. If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
top(K): Return the score sum of the top K players.
reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the leaderboard). It is guaranteed that the player was added to the leaderboard before calling this function.
Initially, the leaderboard is empty.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeaderBoard {
/*
map1  = playerid, score

1 = 12

====
map1  = playerid, score

map2 = score, list of players -- treemap

===

map1 - sorted on the value

top = 3
100 - 1
99
98
97
95 - 5

 */

    private Map<Integer, Integer> playerScores = new HashMap<>();

    void addScore(int playerId, int score) {
        playerScores.put(playerId, playerScores.getOrDefault(playerId, 0) + score);
    }

    int top(int k) {
        // top 3
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() -  b.getValue());

        playerScores.entrySet().forEach(e -> {
                    if (pq.size() < k) {
                        pq.add(e);
                    } else {
                        if (e.getValue() >  pq.peek().getValue() ) {
                            pq.poll();
                            pq.add(e);
                        }
                    }
                }
        );

        int returnScore = 0;
        while (!pq.isEmpty()) {
            returnScore += (Integer) pq.poll().getValue();
        }

        return returnScore;
    }

    void reset(int playerId) {
        //player id always exist
        playerScores.remove(playerId);
    }

    public static void main(String[] args) {
        LeaderBoard leaderboard = new LeaderBoard();

        leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
        leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        leaderboard.top(1);           // returns 73;
        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        leaderboard.top(3);           // returns 141 = 51 + 51 + 39;

    }

}
