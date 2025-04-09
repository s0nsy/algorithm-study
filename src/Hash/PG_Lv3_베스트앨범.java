import java.util.*;

class Solution {
   public ArrayList<Integer> solution(String[] genres, int[] plays) {
      ArrayList<Integer> answer = new ArrayList<>();

      Map<String, Integer> genPlayCount = new HashMap<>();
      Map<String, List<int[]>> genSong= new HashMap<>();

      for(int i =0;i<genres.length;i++){
         genPlayCount.put(genres[i], genPlayCount.getOrDefault(genres[i], 0) + plays[i]);
         genSong.putIfAbsent(genres[i], new ArrayList<>());
         genSong.get(genres[i]).add(new int[] {i, plays[i]});
      }

      List<String> genSort = new ArrayList<>(genPlayCount.keySet());
      genSort.sort((g1, g2) -> genPlayCount.get(g2) - genPlayCount.get(g1));

      for(String gen: genSort){
         List<int[]> songs= genSong.get(gen);
         songs.sort((s1,s2) -> {
            if(s1[0]==s2[0]){
               return s1[0]-s2[0];
            }
            return s2[1]-s1[1];
         });

         for(int i =0;i<Math.min(2,songs.size());i++){
            answer.add(songs.get(i)[0]);
         }
      }

      return answer;
   }
}