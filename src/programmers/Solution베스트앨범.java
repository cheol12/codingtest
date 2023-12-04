package programmers;

import java.util.*;

public class Solution베스트앨범 {

    static class Song{
        int idx, count;
        Song(int idx, int count){
            this.idx = idx;
            this.count = count;
        }
    }

    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        ArrayList<Integer> answerList = new ArrayList<>();

        int size = genres.length;
        Map<String, Integer> genreMap = new HashMap<>();
        for(int i=0; i<size; i++){
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> genreList = new ArrayList<>(genreMap.keySet());

        Collections.sort(genreList, (o2, o1) -> genreMap.get(o1) - genreMap.get(o2));

        for(String temp : genreList){
            List<Song> songList = new ArrayList<>();
            for(int i=0; i<size; i++){
                if(temp.equals(genres[i])){
                    songList.add(new Song(i, plays[i]));
                }
            }
            Collections.sort(songList, new Comparator<Song>(){
                @Override
                public int compare(Song o1, Song o2){
                    if(o1.count == o2.count) return o1.idx - o2.idx;
                    return o2.count - o1.count;
                }
            });
            answerList.add(songList.get(0).idx);
            if(songList.size() >= 2) answerList.add(songList.get(1).idx);
        }

//        리스트 -> 배열로 바꾸는 메소드
//        answer = answerList.stream().mapToInt(i -> i).toArray();

        answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
//https://hy-ung.tistory.com/102