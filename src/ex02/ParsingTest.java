package ex02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

// 테스트 주도 개발!!
// 목적 : 파싱(json -> java) : gson 
public class ParsingTest {

    public static void main(String[] args) {
        
    

        // 1. URL 주소 만들기(끝)
        StringBuffer sbUrl = new StringBuffer();

        sbUrl.append("http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService");
        sbUrl.append("?serviceKey="); // 서비스 키
        sbUrl.append("wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D");
        sbUrl.append("&pageNo="); // 몇번째 페이지 인지
        sbUrl.append("1");
        sbUrl.append("&numOfRows=");
        sbUrl.append("10"); // 한 페이지당 몇개씩 가져올지
        sbUrl.append("&_type=");
        sbUrl.append("json"); // 데이터 포맷은 JSON

        // 2. 다운로드 받기(끝)
        try {
            // URL라이브러리가 ==을 %3D%3D로 바꿔줌 => url이 safe한 상태
            // 쿼리 스트링 때문에!!
            // 이미 인코드된 것을 또 인코드할 수도 있는데
            // URL 라이브러리는 URL safe가 적용되어 있으면 더 이상 반영하지 않는다.
            URL url = new URL(sbUrl.toString());
            // http인지 https인지 모르기때문에 다운캐스팅해서 맞춰써라
            // conn이 socket!
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));

            StringBuffer sbDownload = new StringBuffer(); // 통신결과 모아두기

            while (true) {
                String input = br.readLine();

                // 버퍼가 비었을 때 break
                if (input == null) {
                    break;
                }

                sbDownload.append(input);
            }

            // 3. 파싱
            Gson gson = new Gson();
            ResponseDto responseDto = gson.fromJson(sbDownload.toString(), ResponseDto.class);

            // 4. 검증
            int itemSize = responseDto.getResponse().getBody().getItems().getItem().size();
            System.out.println("아이템 사이즈 : " + itemSize);
            System.out.println("totalCount : " + responseDto.getResponse().getBody().getTotalCount());
            System.out.println(responseDto);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}