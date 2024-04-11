package kr.co.daeddongclient.toilet.controller;

import kr.co.daeddongclient.address.domain.AddressCoordinates;
import kr.co.daeddongclient.toilet.domain.Toilet;
import kr.co.daeddongclient.toilet.service.ToiletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ToiletController {

    @Autowired
    private ToiletService toiletService;

    @GetMapping("/toiletList")
    @ResponseBody
    public Map<String,Object> getToiletList(@RequestParam(value="distance", defaultValue="")double distance,
                                            @RequestParam(value="latitude", defaultValue="")double latitude,
                                            @RequestParam(value="longitude", defaultValue="")double longitude){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        try {
            List<Toilet> toiletList = toiletService.getToiletList(distance,latitude,longitude);
            resultMap.put("resultCode", "0000");
            resultMap.put("toiletList", toiletList);
        }catch (IllegalArgumentException e){
            resultMap.put("resultCode", "9999");
            resultMap.put("resultMsg", e.getMessage());
        }
        return resultMap;
    }


}
