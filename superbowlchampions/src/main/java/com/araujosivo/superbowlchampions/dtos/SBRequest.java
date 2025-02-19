package com.araujosivo.superbowlchampions.dtos;

import java.time.Year;

public record SBRequest(
                String champions, 
                String score, 
                String opponent,
                String mvp,
                Year season,
                String local
) {

}
