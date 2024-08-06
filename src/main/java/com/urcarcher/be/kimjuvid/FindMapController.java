package com.urcarcher.be.kimjuvid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class FindMapController {
//	
//	@Value("${kakao.api.key}")
//    private String apiKey;
//
//    @GetMapping("/directions")
//    public String getDirections(@RequestParam String origin, @RequestParam String destination) {
//        String url = String.format("https://apis-navi.kakaomobility.com/v1/directions?origin=%s&destination=%s&waypoints=&priority=RECOMMEND&car_fuel=GASOLINE&car_hipass=false&alternatives=false&road_details=false",
//                origin, destination);
//
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject(url, String.class);
//    }
//}
