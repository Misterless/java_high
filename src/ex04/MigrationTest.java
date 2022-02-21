package ex04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

// 테스트 주도 개발!!
// 목적 : 5653개 다운로드 받기
// 전략 : (1) 다운로드 1번 -> totalCount 확인
//       (2) totalCount만큼 다운로드 - 파싱 - 검증(item 사이즈)
public class MigrationTest {

    public static void main(String[] args) {

        // 1. URL 주소 만들기 - totalCount 확인용
        StringBuffer totalCountCheckURL = new StringBuffer();

        totalCountCheckURL.append("http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService");
        totalCountCheckURL.append("?serviceKey="); // 서비스 키
        totalCountCheckURL.append("wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D");
        totalCountCheckURL.append("&pageNo="); // 몇번째 페이지 인지
        totalCountCheckURL.append("1");
        totalCountCheckURL.append("&numOfRows=");
        totalCountCheckURL.append("2"); // totalCount 체크만 할 것이기 때문에 2개만 받아도 된다.
                                        // 1개만 받으면 List를 Object로 받기 때문에 2개를 받는다.
        totalCountCheckURL.append("&_type=");
        totalCountCheckURL.append("json"); // 데이터 포맷은 JSON

        // 2. 다운로드 받기 - totalCount 확인용
        try {
            URL urlTemp = new URL(totalCountCheckURL.toString());
            HttpURLConnection connTemp = (HttpURLConnection) urlTemp.openConnection();

            BufferedReader brTemp = new BufferedReader(
                    new InputStreamReader(connTemp.getInputStream(), "utf-8"));

            StringBuffer sbTotalCountCheck = new StringBuffer(); // 통신결과 모아두기

            while (true) {
                String input = brTemp.readLine();

                // 버퍼가 비었을 때 break
                if (input == null) {
                    break;
                }

                sbTotalCountCheck.append(input);
            }

            // 3. 검증 - totalCountCheck

            System.out.println(sbTotalCountCheck.toString());

            // 4. 파싱
            // 결과를 1개만 받아오면 리스트 타입도 중괄호로 받아오기 때문에 파싱 오류 발생
            Gson gsonTemp = new Gson();
            ResponseDto totalCountCheckDto = gsonTemp.fromJson(sbTotalCountCheck.toString(), ResponseDto.class);

            // 5. totalCount 담기
            int totalCount = totalCountCheckDto.getResponse().getBody().getTotalCount();
            System.out.println("totalCount : " + totalCount);

            // 6. 전체 데이터 받기(totalCount)
            // (1) URL 주소 만들기
            StringBuffer sbURL = new StringBuffer();

            sbURL.append("http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService");
            sbURL.append("?serviceKey="); // 서비스 키
            sbURL.append("wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D");
            sbURL.append("&pageNo="); // 몇번째 페이지 인지
            sbURL.append("1");
            sbURL.append("&numOfRows=");
            sbURL.append(totalCount); // totalCount 체크만 할 것이기 때문에 2개만 받아도 된다.
                                      // 1개만 받으면 List를 Object로 받기 때문에 2개를 받는다.
            sbURL.append("&_type=");
            sbURL.append("json"); // 데이터 포맷은 JSON

            // (2) 다운로드 받기 - totalCount 확인용
            URL url = new URL(sbURL.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));

            StringBuffer sb = new StringBuffer(); // 통신결과 모아두기

            while (true) {
                String input = br.readLine();

                // 버퍼가 비었을 때 break
                if (input == null) {
                    break;
                }

                sb.append(input);
            }

            // (3) 파싱
            // 결과를 1개만 받아오면 리스트 타입도 중괄호로 받아오기 때문에 파싱 오류 발생
            Gson gson = new Gson();
            ResponseDto responseDto = gson.fromJson(sb.toString(), ResponseDto.class);

            // 7. 사이즈 검증
            if (responseDto.getResponse().getBody().getItems().getItem().size() == totalCount) {
                System.out.println("성공 ~~~~~~~");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}