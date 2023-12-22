package com.hrusch.timetrials.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.hrusch.timetrials.model.combination.Combination;
import com.hrusch.timetrials.model.config.jackson.serialization.CustomDurationDeserializer;
import com.hrusch.timetrials.model.config.jackson.serialization.CustomDurationSerializer;
import java.time.Duration;
import java.time.LocalDateTime;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Time {

    @Id
    @JsonIgnore
    private String id;

    private String username;

    private Track track;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Combination combination;

    @JsonSerialize(using = CustomDurationSerializer.class)
    @JsonDeserialize(using = CustomDurationDeserializer.class)
    private Duration duration;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
}
