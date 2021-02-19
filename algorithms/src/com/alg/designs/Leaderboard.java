package com.alg.designs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Player implements Comparable<Player> {
    int playerId;
    int score;
    public Player(int id, int score) {
        this.playerId = id;
        this.score = score;
    }
    @Override
    public int compareTo(Player p) {
        return p.score - this.score;
    }
}
public class Leaderboard {
    List<Player> players;
    public Leaderboard() {
        players = new ArrayList<>();
    }

    public void addScore(int playerId, int score) {
        List<Player> targetPlayer = players.stream()
                .filter(p->p.playerId == playerId)
                .collect(Collectors.toList());

        if(targetPlayer.isEmpty()) {
            Player player = new Player(playerId, 0);
            players.add(new Player(playerId, score));
        } else {
            Player player = targetPlayer.get(0);
            player.score += score;
        }
    }

    public int top(int K) {
        // Note: It requires to return the SUM of top K players' scores
        List<Player> orderedPlayers = players.stream()
                .sorted().collect(Collectors.toList());
        int sum = 0;
        for(int i = 0; i < K; i++){
            sum += orderedPlayers.get(i).score;
        }
        return sum;
    }

    public void reset(int playerId) {
        Player player = players.stream()
                .filter(p->p.playerId == playerId).collect(Collectors.toList()).get(0);
        player.score = 0;
    }

    public static void main(String[] args) {
//        Leaderboard leaderboard = new Leaderboard ();
//        leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
//        leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
//        leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
//        leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
//        leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
//        System.out.println(leaderboard.top(1));           // returns 73;
//        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
//        leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
//        leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
//        System.out.println(leaderboard.top(3));           // returns 141 = 51 + 51 + 39;

        Leaderboard leaderboard = new Leaderboard ();
        leaderboard.addScore(1,13);
        leaderboard.addScore(2,93);
        leaderboard.addScore(3,84);
        leaderboard.addScore(4,6);
        leaderboard.addScore(5,89);
        leaderboard.addScore(6,31);
        leaderboard.addScore(7,7);
        leaderboard.addScore(8,1);
        leaderboard.addScore(9,98);
        leaderboard.addScore(10,42);
        System.out.println(leaderboard.top(5));
        leaderboard.reset(1);
        leaderboard.reset(2);
        leaderboard.addScore(3,76);
        leaderboard.addScore(4,68);
        System.out.println(leaderboard.top(1));
        leaderboard.reset(3);
        leaderboard.reset(4);
        leaderboard.addScore(2, 70);
        leaderboard.reset(2);

//        [[],[1,13],[2,93],[3,84],[4,6],[5,89],[6,31],[7,7],[8,1],[9,98],[10,42],[5],[1],[2],[3,76],[4,68],[1],[3],[4],[2,70],[2]]
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */