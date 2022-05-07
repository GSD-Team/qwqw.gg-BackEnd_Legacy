package com.gsd.fifa4.domain.gameRecord.service;

import com.gsd.fifa4.domain.gameRecord.model.api.User;
import com.gsd.fifa4.domain.gameRecord.model.api.match.Match;
import com.gsd.fifa4.domain.gameRecord.model.db.ClubPriceRank;
import com.gsd.fifa4.domain.gameRecord.repository.ClubPriceRankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by Yohan lee
 * Created on 2021-03-04.
 **/

@Service
@RequiredArgsConstructor
public class ClubPriceRankService {


    private final UserService userService;
    private final MatchService matchService;
    private final ClubPriceRankRepository clubPriceRankRepository;


    @Transactional
    public void saveRank(String nickName) {
        User user = userService.getUser(nickName);

        Long myClubPrice = getRecentClubPrice(user);
        Optional<ClubPriceRank> rank = clubPriceRankRepository.findByAccessId(user.getAccessId());
        if(rank.isPresent()) {
            rank.get().update(nickName, myClubPrice);
        } else {
            clubPriceRankRepository.save(new ClubPriceRank(user, myClubPrice));
        }
    }

    @Transactional(readOnly = true)
    public Page<ClubPriceRank> getList(Pageable pageable) {
        return clubPriceRankRepository.findAll(pageable);
    }

    private Long getRecentClubPrice(User user) {
        Match recentMatch = userService.getRecentMatch(user.getAccessId());
        return matchService.getMyClubPrice(recentMatch.getMatchId(), user.getNickName());
    }
}
