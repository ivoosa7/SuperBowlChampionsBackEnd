package com.araujosivo.superbowlchampions.mapper;

import com.araujosivo.superbowlchampions.dtos.SBRequest;
import com.araujosivo.superbowlchampions.dtos.SBResponse;
import com.araujosivo.superbowlchampions.entities.SBChampions;

public class SBMapper {
    //dto Response
    public static SBResponse toDTO(SBChampions sb){
        return new SBResponse(
            sb.getId(),
            sb.getChampions(),
            sb.getScore(),
            sb.getOpponent(),
            sb.getMvp(),
            sb.getSeason(),
            sb.getLocal()
        );
    }

    public static SBChampions toEntity(SBRequest sbRequest){
        SBChampions sb = new SBChampions();
        sb.setChampions(sbRequest.champions());
        sb.setScore(sbRequest.score());
        sb.setOpponent(sbRequest.opponent());
        sb.setMvp(sbRequest.mvp());
        sb.setSeason(sbRequest.season());
        sb.setLocal(sbRequest.local());

        return sb;
    }
}
