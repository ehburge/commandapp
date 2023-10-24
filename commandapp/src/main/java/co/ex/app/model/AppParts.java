package co.ex.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Builder
public class AppParts {

  private String partsCompatibility;
  private List<AppPart> parts;
}
