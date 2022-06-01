package com.hagos.sportsteam.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.List;

@Data
public class Players {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Player> player;
}
