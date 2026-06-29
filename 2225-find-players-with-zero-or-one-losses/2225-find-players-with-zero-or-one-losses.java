class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        HashMap<Integer, Integer> lossMap = new HashMap<>();
        HashSet<Integer> players = new HashSet<>();

        // Count losses and store all players
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            players.add(winner);
            players.add(loser);

            lossMap.put(loser, lossMap.getOrDefault(loser, 0) + 1);
        }

        List<Integer> neverLost = new ArrayList<>();
        List<Integer> lostOnce = new ArrayList<>();

        // Check every player
        for (int player : players) {
            int losses = lossMap.getOrDefault(player, 0);

            if (losses == 0) {
                neverLost.add(player);
            } else if (losses == 1) {
                lostOnce.add(player);
            }
        }

        Collections.sort(neverLost);
        Collections.sort(lostOnce);

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(neverLost);
        answer.add(lostOnce);

        return answer;
    }
}