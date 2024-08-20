//package com.urcarcher.be.syc98syc.reservation;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/api/reservation")
//public class ReservationController {
//
//    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
//
//    @Value("${kopisapi.key}")
//    private String serviceKey;
//
//    @GetMapping("/reservation-info")
//    public String getTourDetail(
//            @RequestParam(value = "stdate", defaultValue = "20160601") String stdate,
//            @RequestParam(value = "eddate", defaultValue = "20160630") String eddate,
//            @RequestParam(value = "cpage", defaultValue = "1") String cpage,
//            @RequestParam(value = "rows", defaultValue = "10") String rows,
//            @RequestParam(value = "shcate", defaultValue = "AAAA") String shcate,
//            @RequestParam(value = "shprfnm", defaultValue = "사랑") String shprfnm,
//            @RequestParam(value = "shprfnmfct", defaultValue = "예술의전당") String shprfnmfct,
//            @RequestParam(value = "prfplccd", defaultValue = "FC000003-01") String prfplccd,
//            @RequestParam(value = "signgucode", defaultValue = "11") String signgucode,
//            @RequestParam(value = "signgucodesub", defaultValue = "1111") String signgucodesub,
//            @RequestParam(value = "kidstate", defaultValue = "Y") String kidstate,
//            @RequestParam(value = "prfstate", defaultValue = "01") String prfstate,
//            @RequestParam(value = "openrun", defaultValue = "Y") String openrun,
//            @RequestParam(value = "newsql", defaultValue = "Y") String newsql) {
//
//        StringBuilder urlBuilder = new StringBuilder("https://www.kopis.or.kr/openApi/restful/pblprfr");
//        urlBuilder.append("serviceKey=").append(serviceKey)
//                  .append("&stdate=").append(stdate)
//                  .append("&eddate=").append(eddate)
//                  .append("&cpage=").append(cpage)
//                  .append("&rows=").append(rows)
//                  .append("&shcate=").append(shcate)
//                  .append("&shprfnm=").append(shprfnm)
//                  .append("&shprfnmfct=").append(shprfnmfct)
//                  .append("&prfplccd=").append(prfplccd)
//                  .append("&signgucode=").append(signgucode)
//                  .append("&signgucodesub=").append(signgucodesub)
//                  .append("&kidstate=").append(kidstate)
//                  .append("&prfstate=").append(prfstate)
//                  .append("&openrun=").append(openrun)
//                  .append("&newsql=").append(newsql);
//
//        
//
//        try {
//            URI uri = new URI(urlBuilder.toString());
//            RestTemplate restTemplate = new RestTemplate();
//            String response = restTemplate.getForObject(uri, String.class);
//            // test
//            System.out.println(response);
//            logger.info("API Response: {}", response);
//            return response;
//        } catch (URISyntaxException e) {
//            logger.error("Invalid URI syntax", e);
//            return "Error creating URI: " + e.getMessage();
//        } catch (Exception e) {
//            logger.error("Error fetching tour information", e);
//            return "Error fetching tour information: " + e.getMessage();
//        }
//    }
//    
// // 새로운 세부 정보 조회 엔드포인트
////    @GetMapping("/tour-detail")
////    public String getTourDetail(
////            @RequestParam(value = "contentId") String contentId,
////            @RequestParam(value = "MobileOS", defaultValue = "ETC") String mobileOS,
////            @RequestParam(value = "MobileApp", defaultValue = "AppTest") String mobileApp,
////            @RequestParam(value = "_type", defaultValue = "json") String type) {
////
////        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/detailCommon1?");
////        urlBuilder.append("serviceKey=").append(serviceKey)
////                  .append("&contentId=").append(contentId)
////                  .append("&MobileOS=").append(mobileOS)
////                  .append("&MobileApp=").append(mobileApp)
////                  .append("&_type=").append(type)
////                  .append("&defaultYN=Y")
////                  .append("&firstImageYN=Y")
////                  .append("&areacodeYN=Y")
////                  .append("&catcodeYN=Y")
////                  .append("&addrinfoYN=Y")
////                  .append("&mapinfoYN=Y")
////                  .append("&overviewYN=Y");
////
////        try {
////            URI uri = new URI(urlBuilder.toString());
////            RestTemplate restTemplate = new RestTemplate();
////            String response = restTemplate.getForObject(uri, String.class);
////            logger.info("API Response: {}", response);
////            return response;
////        } catch (URISyntaxException e) {
////            logger.error("Invalid URI syntax", e);
////            return "Error creating URI: " + e.getMessage();
////        } catch (Exception e) {
////            logger.error("Error fetching tour detail", e);
////            return "Error fetching tour detail: " + e.getMessage();
////        }
////    }
//}
