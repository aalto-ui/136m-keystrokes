
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/samulid/src/typingmaster/conf/routes
// @DATE:Wed Jun 14 14:02:50 EEST 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseTypingTest TypingTest = new controllers.ReverseTypingTest(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseExternalAssets ExternalAssets = new controllers.ReverseExternalAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseTypingTest TypingTest = new controllers.javascript.ReverseTypingTest(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseExternalAssets ExternalAssets = new controllers.javascript.ReverseExternalAssets(RoutesPrefix.byNamePrefix());
  }

}
