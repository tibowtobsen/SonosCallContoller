package org.tibow.sonos;

import engineer.nightowl.sonos.api.SonosApiClient;

public class Main {


  public static void main(String[] args) {
    System.out.println(PropertyReader.getMvProperty("apiKey"));
    establishSonosCon();
  }

  /**
   * Not that easy. First the user must be redirected to the sonos login for receiving an authKey
   */
  private static void establishSonosCon() {
    SonosApiClient client = new SonosConnector().getSonosApiClient();
    //
    try {
      SonosConnector.createAccessToken(client);
      client.authorize().createToken("ja?", SonosConnector.authToken);
      client.playback().pause("token", "group");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}