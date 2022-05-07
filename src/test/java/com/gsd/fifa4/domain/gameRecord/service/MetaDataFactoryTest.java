//package com.gsd.fifa4.domain.gameRecord.service;
//
//import com.gsd.fifa4.DataCenter.adapter.DataCenterAdapter;
//import com.gsd.fifa4.domain.gameRecord.model.api.Matchapi.Match;
//import com.gsd.fifa4.domain.gameRecord.model.api.Matchapi.MatchInfo;
//import com.gsd.fifa4.domain.gameRecord.model.api.Matchapi.detail.Player;
//import com.gsd.fifa4.api.MatchApi;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//
//@SpringBootTest
//public class MetaDataFactoryTest {
//    @Autowired
//    private DataCenterAdapter dataCenterAdapter;
//
//    @Autowired
//    private MatchApi matchApi;
//
//    private static final String NICKNAME = "굴리트러브";
//    private static final String MATCH_ID = "5ebebd457a77ea1777b71694";
//
//
//    @Test
//    @DisplayName("선수 이름 장착~")
//    void setPlayername() {
//        long startTime = System.currentTimeMillis();
//
//        Match match = matchApi.getMatch(MATCH_ID, NICKNAME);
//        match.getMatchInfo().stream()
//                .flatMap(matchInfo -> matchInfo.getPlayers().stream())
//                .forEach(player ->
//                        player.setName(dataCenterAdapter.scrapingPlayerName(player.getId()))
//                );
//
//        long endTime = System.currentTimeMillis();
//    }
//
//    @Test
//    @DisplayName("구단 가치 가져오기.")
//    void getTotalPlayerPrice() {
//        //매치 정보 GET
//        List<MatchInfo> matchInfoList = matchApi.getMatch(MATCH_ID, NICKNAME).getMatchInfo();
//
//        //선수 단가 SET
//        List<Player> myPlayerList = matchInfoList.get(0).getPlayers();
//        List<Player> enemyPlayerList = matchInfoList.get(1).getPlayers();
//
//        System.out.println("--------내 선수리스트--------");
//        for (Player player : myPlayerList) {
//            String name =  dataCenterAdapter.scrapingPlayerName(player.getId());
//            Long price = dataCenterAdapter.scrapingPlayerPrice(player.getId(), player.getGrade());
//
//            if(price != 0) {
//                System.out.println("선수명 : " +  name);
//                System.out.println("선수 가치: " + price);
//            }
//        }
//
//        System.out.println("--------상대 선수리스트--------");
//        for (Player player : enemyPlayerList) {
//            String name =  dataCenterAdapter.scrapingPlayerName(player.getId());
//            Long price = dataCenterAdapter.scrapingPlayerPrice(player.getId(), player.getGrade());
//
//            if(price != 0) {
//                System.out.println("선수명 : " +  name);
//                System.out.println("선수 가치: " + price);
//            }
//        }
//
//
//        Long myClubPrice = myPlayerList.stream()
//                .mapToLong(player -> dataCenterAdapter.scrapingPlayerPrice(player.getId(), player.getGrade()))
//                .sum();
//
//        Long enemyClubPrice = enemyPlayerList.stream()
//                .mapToLong(player -> dataCenterAdapter.scrapingPlayerPrice(player.getId(), player.getGrade()))
//                .sum();
//
//
//
//        Map<String, Long> clubPriceMap = new LinkedHashMap<>();
//
//        //구단가치 SET
//        clubPriceMap.put("myClub", myClubPrice);
//        clubPriceMap.put("enemyClub", enemyClubPrice);
//
//        System.out.println(clubPriceMap.get("myClub"));
//        System.out.println(clubPriceMap.get("enemyClub"));
//    }
//
////    @Test
////    @DisplayName("구단가치를 int형으로 가져올 경우 범위문제로 BigInteger 사용.")
////    void getTotalPlayerPriceWithBigInteger() {
////        //매치 정보 GET
////        List<MatchInfo> matchInfoList = matchRepository.getMatch(MATCH_ID, NICKNAME).getMatchInfoList();
////
////        //선수 단가 SET
////        List<Player> myPlayerList = matchInfoList.get(0).getPlayers();
////        List<Player> enemyPlayerList = matchInfoList.get(1).getPlayers();
////
////        for(Player player : myPlayerList) {
////
////        }
////
////        for(Player player : enemyPlayerList) {
////
////        }
////    }
//
//}
//
//
//
