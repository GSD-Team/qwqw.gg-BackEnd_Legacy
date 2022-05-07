package com.gsd.fifa4.domain.gameRecord.service;

import com.gsd.fifa4.dataCenter.service.DataCenterService;
import com.gsd.fifa4.api.MatchApi;
import com.gsd.fifa4.domain.gameRecord.dto.ClubPriceDTO;
import com.gsd.fifa4.domain.gameRecord.dto.gameRecord.GameRecordDTO;
import com.gsd.fifa4.domain.gameRecord.dto.gameRecord.GameRecordDetailDTO;
import com.gsd.fifa4.domain.gameRecord.dto.gameRecord.GameRecordListDTO;
import com.gsd.fifa4.domain.gameRecord.model.api.match.Match;
import com.gsd.fifa4.domain.gameRecord.model.api.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchApi matchApi;
    private final UserService userService;
    private final MetaService metaService;
    private final DataCenterService dataCenterService;

    public GameRecordListDTO getRecordList(String nickName, int offset, int limit){
        User user = userService.getUser(nickName);

        //매칭 리스트 가져오기.
        List<GameRecordDTO> gameRecords = userService.getMatches(user.getAccessId(), offset, limit)
                .stream()
                .map(GameRecordDTO::new)
                .collect(Collectors.toList());

        return new GameRecordListDTO(user, gameRecords);
    }


    public GameRecordDetailDTO getRecordInfo(String matchId, String nickName) {
        Match match = matchApi.getMatch(matchId, nickName);

        match.getMatchInfo().forEach(dataCenterService::buildDataCenter);
        match.getMatchInfo().forEach(metaService::load);

        return new GameRecordDetailDTO(match);
    }

    public ClubPriceDTO getClubPriceByMatch(String matchId, String nickName) {
        Match match = matchApi.getMatch(matchId, nickName);

        Long myClub = dataCenterService.getClubPrice(match.getMyMatchInfo());
        Long enemyClub = dataCenterService.getClubPrice(match.getEnemyMatchInfo());
        return new ClubPriceDTO(myClub, enemyClub);
    }

    public Long getMyClubPrice(String matchId, String nickName) {
        Match match = matchApi.getMatch(matchId, nickName);
        return dataCenterService.getClubPrice(match.getMyMatchInfo());
    }
}
