package com.araujosivo.superbowlchampions.dtos;

import java.time.Year;

public record SBResponse(
                Long id,
                String champions, 
                String score, 
                String opponent,
                String mvp,
                Year season,
                String local
) {
    
}
