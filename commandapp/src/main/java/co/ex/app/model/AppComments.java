package co.ex.app.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Builder(access = AccessLevel.PUBLIC)
public class AppComments {
  private List<String> comments;
}
