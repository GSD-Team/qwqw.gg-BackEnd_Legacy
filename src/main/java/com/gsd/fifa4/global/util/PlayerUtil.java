package com.gsd.fifa4.global.util;

/**
 * Created by Yohan lee
 * Created on 2021-02-01.
 **/

public class PlayerUtil {

    /**
     * 선수의 Image을 호출할 때 쓰일 id를 추출한다.
     * @param playerId 선수 고유 id
     * @return Image id
     */
    public static int getImageId(int playerId) {
        String id = Integer.toString(playerId);
        String sliceId = id.substring(id.length()-6);

        return Integer.parseInt(sliceId);
    }

    /**
     * 선수의 시즌정보에 해당하는 값을 추출한다.
     * @param playerId 선수 고유 id
     * @return 시즌정보가 담긴 int형 데이터
     */
    public static int getSeasonId(int playerId) {
        return Integer.parseInt(Integer.toString(playerId).substring(0,3));
    }

    /**
     * 선수의 마지막 name값을 추출한다.
     * @param name 선수의 Full Name
     * @return 선수의 마지막 name값
     */
    public static String getLastName(String name) {
        String[] nameArr = name.split(" ");
        return nameArr[nameArr.length -1];
    }

    /**
     * 강화등급에 따른 추가 능력치를 가져온다.
     * @param grade 강화등급
     * @return 강화등급에 따른 추가 능력치
     */
    public static int addAbility(int grade) {
        if(grade == 0) {
            return 0;
        }

        switch (grade) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 5;
            case 4:
                return 7;
            case 5:
                return 9;
            case 6:
                return 11;
            case 7:
                return 14;
            case 8:
                return 18;
            case 9:
                return 22;
            case 10:
                return 27;
            default:
                return 0;
        }

    }

    /**
     * 시즌 이미지 URL을 이용하여 카드 이미지 URL을 가져온다.
     * @param seasonImageURL 시즌이미지 URL
     * @return 카드 이미지 URL
     */
    public static String getCardImageURL(String seasonImageURL) {
        return seasonImageURL.replaceFirst("season", "card");
    }


}
