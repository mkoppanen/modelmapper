package org.modelmapper.bugs;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.Map;

import org.modelmapper.AbstractTest;
import org.testng.annotations.Test;

/**
 * https://github.com/jhalterman/modelmapper/issues/105
 */
@Test
public class GH105 extends AbstractTest {
  static class Source {
    Map<String, Map<String, String>> map;
  }

  static class Dest {
    Map<String, Map<String, String>> map;
  }

  public void shouldMapToDestinationWithFluentSetters() {
    Source source = new Source();
    source.map = Collections.singletonMap("test", Collections.singletonMap("a", "1"));

    Dest dest = modelMapper.map(source, Dest.class);
    assertEquals(source.map, dest.map);
  }
}
