import java.util.*;

class Solution {
    // 곡 정보 정렬을 위한 구조체
    static class SongInfo implements Comparable<SongInfo>{
        int id;
        int play;
        
        public SongInfo(int id, int play){
            this.id = id;
            this.play = play;
        }
        
        @Override
        public int compareTo(SongInfo si){
            // 재생수가 같으면 id 오름차정렬
            if(this.play == si.play){
                return Integer.compare(this.id, si.id);
            }
            
            // 기본적으로 재생수 내림차정렬
            return Integer.compare(si.play, this.play);
        }
    }
    
    // 장르 정보 정렬을 위한 구조체
    static class GenreInfo implements Comparable<GenreInfo>{
        String genre;
        int totalPlay;
        List<SongInfo> songList = new ArrayList<>();
        
        public GenreInfo(String genre, int play){
            this.genre = genre;
            this.totalPlay = play;
        }
        
        // totalPlay 내림차순으로 정렬
        @Override
        public int compareTo(GenreInfo gi){
            return Integer.compare(gi.totalPlay, totalPlay);
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> genreMap = new HashMap<>();
        List<GenreInfo> genreList = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            // 만약 이미 등록된 장르인 경우
            if(genreMap.containsKey(genre)){
                int index = genreMap.get(genre);
                genreList.get(index).totalPlay += plays[i];
                genreList.get(index).songList.add(new SongInfo(i, plays[i]));
            }
            // 등록 안됐었으면 새로 등록
            else {
                int index = genreList.size();
                genreMap.put(genre, index);
                genreList.add(new GenreInfo(genre, plays[i]));
                genreList.get(index).songList.add(new SongInfo(i, plays[i]));
            }
        }
        
        // 전체 장르 리스트 정렬 (by 총 플레이 수)
        Collections.sort(genreList);
        for(int i = 0; i < genreList.size(); i++){
            // 장르별로 각 노래들 정렬 후 상위 2개 곡 answerList에 추가
            if(genreList.get(i).songList.size() == 1) 
                answerList.add(genreList.get(i).songList.get(0).id);
            else{
                Collections.sort(genreList.get(i).songList);
                for(int j = 0; j < 2; j++) 
                    answerList.add(genreList.get(i).songList.get(j).id);
            }
        }
        
        // answerList를 answer로 변환하여 반환
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
        
    }
}