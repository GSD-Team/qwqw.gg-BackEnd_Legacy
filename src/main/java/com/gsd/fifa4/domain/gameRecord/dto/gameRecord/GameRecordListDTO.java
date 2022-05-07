package com.gsd.fifa4.domain.gameRecord.dto.gameRecord;

import com.gsd.fifa4.domain.gameRecord.model.api.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GameRecordListDTO {

    private String myAccessId;

    private int myLevel;

    private List<GameRecordDTO> gameRecords;


    public GameRecordListDTO(User user, List<GameRecordDTO> gameRecords) {
        this.myAccessId = user.getAccessId();
        this.myLevel = user.getLevel();
        this.gameRecords = gameRecords;
    }

}
