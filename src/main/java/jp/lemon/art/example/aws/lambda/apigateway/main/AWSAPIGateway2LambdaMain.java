package jp.lemon.art.example.aws.lambda.apigateway.main;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import jp.lemon.art.example.aws.lambda.apigateway.utils.CreateAWSAPIGatewayResponse;

/**
 * AWS Lambda Main.<br>
 * メインロジックを記載する。
 * 
 * @author seita
 */
public class AWSAPIGateway2LambdaMain {

  /**
   * メインロジック.
   * 
   * @param queryStringParameters APIGatewayProxyRequestEvent#getQueryStringParameters()
   * @param pathParameters APIGatewayProxyRequestEvent#getPathParameters()
   * @return APIGatewayProxyResponseEvent
   */
  public APIGatewayProxyResponseEvent execute(Map<String, String> queryStringParameters,
      Map<String, String> pathParameters) {

    // パラメーターチェック
    if (MapUtils.isEmpty(queryStringParameters)) {
      // パラメーターがない場合、nullが送られてくるため、チェック処理が必要
    }

    if (MapUtils.isEmpty(pathParameters)) {
      // パラメーターがない場合、nullが送られてくるため、チェック処理が必要
    }

    // ダミーレスポンス
    Map<String, String> responsMap = new HashMap<>();
    responsMap.putAll(queryStringParameters);
    responsMap.putAll(pathParameters);

    // レスポンス作成
    APIGatewayProxyResponseEvent respons = CreateAWSAPIGatewayResponse
        .createResponse(HttpURLConnection.HTTP_OK, responsMap, Map.class);
    return respons;
  }
}
