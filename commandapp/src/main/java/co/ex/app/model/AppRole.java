package co.ex.app.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AppRole {

  private final Long actorId;
  private final String groupId;
  private final String loyaltyCode;
}
