package jp.lemon.art.example.aws.lambda.apigateway.utils;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

/**
 * APIGatewayProxyResponseEventを作成するユーティリティ
 * 
 * @author seita
 */
public class CreateAWSAPIGatewayResponse {
  private CreateAWSAPIGatewayResponse() {}

  private static final Gson gson = new Gson();

  /**
   * APIGatewayProxyResponseEvent を作成する。
   * 
   * @param <T> レスポンスボディクラス
   * @param statusCode HTTPステータスコード
   * @param body レスポンスボディ
   * @param bodyType レスポンスボディクラス
   * @return APIGatewayProxyResponseEvent
   */
  public static <T> APIGatewayProxyResponseEvent createResponse(int statusCode, Object body,
      Class<T> bodyType) {
    APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
    response.setStatusCode(statusCode);
    response.setBody(gson.toJson(body, bodyType));
    return response;
  }

}
