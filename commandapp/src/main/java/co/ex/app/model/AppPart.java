package co.ex.app.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder(access = AccessLevel.PUBLIC)
public class AppPart {

  private final String partId;
  private final int qty;
  private final String lineAction;
  private final String promoCodes;
}
