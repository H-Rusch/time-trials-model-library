package com.hrusch.timetrials.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hrusch.timetrials.model.exception.EnumDeserializationException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrackTest {

  @ParameterizedTest
  @ValueSource(strings = {"", "Mario"})
  void givenIncorrectString_whenBuildingTrackFromString_thenThrowExceptions(String value) {
    assertThatThrownBy(() -> Track.forValue(value))
        .isInstanceOf(EnumDeserializationException.class)
        .hasMessageStartingWith("No 'Track' can be built from value '");
  }

  @ParameterizedTest
  @ValueSource(strings = {"MARIO_CIRCUIT_DS", "DS Mario Circuit"})
  void givenValidString_whenBuildingTrackFromString_thenReturnCorrectTrack(String value)
      throws JsonProcessingException {
    assertThat(Track.forValue(value)).isEqualTo(Track.MARIO_CIRCUIT_DS);
  }
}
