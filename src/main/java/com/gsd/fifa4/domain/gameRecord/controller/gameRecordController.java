package com.gsd.fifa4.domain.gameRecord.controller;

import com.gsd.fifa4.domain.gameRecord.service.ClubPriceRankService;
import com.gsd.fifa4.domain.gameRecord.service.MatchService;
import com.gsd.fifa4.domain.gameRecord.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/record")
public class gameRecordController {

    private final MatchService matchService;
    private final UserService userService;
    private final ClubPriceRankService clubPriceRankService;


    @GetMapping("/match/{nickName}")
    public ResponseEntity<?> getList(
            @PathVariable  String nickName,
            @RequestParam int offset,
            @RequestParam int limit){
        clubPriceRankService.saveRank(nickName);
        return ResponseEntity.ok(matchService.getRecordList(nickName, offset, limit));
    }

    @GetMapping("/user-info/{accessId}")
    public ResponseEntity<?> getUserInfo(@PathVariable String accessId) {
        return ResponseEntity.ok(userService.getUserInfo(accessId));
    }

    @GetMapping("/match-info/{nickName}/{matchId}")
    public ResponseEntity<?> getDetailInfo(@PathVariable String matchId, @PathVariable String nickName){
        return ResponseEntity.ok(matchService.getRecordInfo(matchId, nickName));
    }

    @GetMapping("/match-club-price")
    public ResponseEntity<?> getClubPrice(@RequestParam String matchId, @RequestParam String nickName) {
        Assert.notNull(nickName, "유저 닉네임값은 필수입니다.");
        Assert.notNull(matchId, "매치 아이디값은 필수입니다.");
        return ResponseEntity.ok(matchService.getClubPriceByMatch(matchId, nickName));
    }

    @GetMapping("/club-rank")
    public ResponseEntity<?> getClubRankList(Pageable pageable) {

        return ResponseEntity.ok(clubPriceRankService.getList(pageable));
    }


}
