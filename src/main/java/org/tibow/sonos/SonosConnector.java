package org.tibow.sonos;

import engineer.nightowl.sonos.api.SonosApiClient;
import engineer.nightowl.sonos.api.SonosApiConfiguration;
import engineer.nightowl.sonos.api.domain.SonosToken;

public class SonosConnector {
  private final SonosApiConfiguration configuration = new SonosApiConfiguration();
  public static String authToken = null;

  public final SonosApiClient getSonosApiClient() {
    configuration.setApiKey(PropertyReader.getMvProperty("apiKey"));
    configuration.setApiSecret(PropertyReader.getMvProperty("apiSecret"));
    configuration.setApplicationId(PropertyReader.getMvProperty("apiAppId"));
    //
    return new SonosApiClient(configuration);
  }

  public static void createAccessToken(SonosApiClient client) {
    try {
      // TODO Auth Code ?
      SonosToken token = client.authorize().createToken("http://localhost", PropertyReader.getMvProperty("apiKey"));
      authToken = token.getAccessToken();
      System.out.println(authToken);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}