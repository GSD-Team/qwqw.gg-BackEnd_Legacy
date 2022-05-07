package com.gsd.fifa4.domain.gameRecord.model.db;

import com.gsd.fifa4.domain.gameRecord.model.api.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created by Yohan lee
 * Created on 2021-02-26.
 **/
@GenericGenerator(name = "club_price_rank_seq_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "seq_club_price_rank"),
                @Parameter(name = "initial_value", value = "50"),
                @Parameter(name = "increment_size", value = "1")
        }
)

@Entity
@Getter
@NoArgsConstructor
@Table(name = "club_price_rank")
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class ClubPriceRank {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_price_rank_seq_generator")
    private Long id;

    @Column(name = "access_id")
    private String accessId;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "club_price")
    private Long clubPrice;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    public void update(String nickName, Long clubPrice) {
        this.nickName = this.nickName.equals(nickName) ? this.nickName : nickName;
        this.clubPrice = this.clubPrice.equals(clubPrice) ? this.clubPrice : clubPrice;
    }

    public ClubPriceRank(User user, Long clubPrice) {
        this.nickName = user.getNickName();
        this.accessId = user.getAccessId();
        this.clubPrice = clubPrice;
    }
}
