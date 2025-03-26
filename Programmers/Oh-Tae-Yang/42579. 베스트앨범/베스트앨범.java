import java.util.*;

class Solution {
    static int[] solution(String[] genres, int [] plays) {
        int[] answer = {};
        HashMap<String, GenreData> map = new HashMap<>();

        int len = genres.length;

        for (int i = 0; i < len; i++) {
            String genre = genres[i];
            map.putIfAbsent(genre, new GenreData());

            GenreData genreData = map.get(genre);
            genreData.total_cnt += plays[i]; //장르별 총 재생 수 증가
            genreData.list.add(new SongData(i, plays[i])); //개별 노래 추가
        }

        //1. total_cnt 기주능로 정렬
        List<GenreData> genreDataList = new ArrayList<>(map.values());
        Collections.sort(genreDataList);

        List<Integer> result = new ArrayList<>();

        for (GenreData genreData : genreDataList) {
            //2. song_cnt 내림차순, song_num 오름차순 정렬
            Collections.sort(genreData.list);

            //3. 각 장르별 최대 2곡까지
            int cnt = 0;
            for (SongData songData : genreData.list) {
                result.add(songData.song_num);
                cnt++;
                if (cnt == 2) break;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static class GenreData implements Comparable<GenreData>  {
        private int total_cnt;
        private ArrayList<SongData> list;

        public GenreData() {
            this.total_cnt = 0;
            this.list = new ArrayList<>();
        }

        @Override
        public int compareTo(GenreData o) {
            return Integer.compare(o.total_cnt, this.total_cnt);
        }
    }

    public static class SongData implements Comparable<SongData>{
        private int song_num;
        private int song_cnt;

        public SongData(int song_num, int song_cnt) {
            this.song_num = song_num;
            this.song_cnt = song_cnt;
        }

        @Override
        public int compareTo(SongData o) {
            // 2. song_cnt 내림차순
            if (this.song_cnt != o.song_cnt) {
                return Integer.compare(o.song_cnt, this.song_cnt);
            }
            // 3. song_num 오름차순
            return Integer.compare(this.song_num, o.song_num);
        }
    }
}

/**
 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록한다.
 * 2. 장르 내에서 많이 재생된 노래를 먼저 수록한다.
 * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록한다.
 */