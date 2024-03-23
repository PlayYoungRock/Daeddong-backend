package kr.co.daeddongclient.address.controller;

import kr.co.daeddongclient.address.domain.Address;
import kr.co.daeddongclient.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/sidoList")
    @ResponseBody
    public Map<String,Object> getSidoList(){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        List<Address> sidoList = addressService.getSidoList(resultMap);
        resultMap.put("resultCode","0000");
        resultMap.put("sidoList",sidoList);
        return resultMap;
    }

    @GetMapping("/sigunguList")
    @ResponseBody
    public Map<String,Object> getSigunguList(@RequestParam(value="sido", defaultValue="")String sido) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        List<Address> sigunguList = addressService.getSiGunguList(sido);
            resultMap.put("resultCode","0000");
            resultMap.put("sigunguList",sigunguList);
        return resultMap;
    }

}
