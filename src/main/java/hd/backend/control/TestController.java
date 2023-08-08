package hd.backend.control;

import hd.backend.control.domain.Human;
import hd.backend.control.domain.HumanList;
import hd.backend.control.domain.ToDo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@RequestMapping("test")
@Controller
public class TestController {
    @RequestMapping("")
    public void m00(){
        pln("#m00() - defult URL");
    }
    @RequestMapping("/base1")
    public void m01(){
        pln("#m01() - Get, Post, put , Delete,..지원");
    }
    @RequestMapping(value = "/base2", method = RequestMethod.GET)//@GetMapping("/base2")
    public void m02(){
        pln("#m02(): only Get방식");
    }
    @RequestMapping(value = "/base3", method = {RequestMethod.GET,RequestMethod.POST})
    public void m03(){
        pln("#m03(): only Get방식 & Post방식");
    }
    @GetMapping(value = "/param1")
    public void m04(Human dto){
        pln("#m04(): dto:" + dto);
    }
    @GetMapping("/param2")
    public void m05(@RequestParam("name") String na, @RequestParam("age") int a) {
        pln("#m05(): na: " + na + ", a: " + a);
    }
    @GetMapping("/param3")
    public void m06(@RequestParam ArrayList<String> names) {
        pln("#m06(): names:" + names);
    }
    @GetMapping("/param4")
    public void m07(@RequestParam("ns") ArrayList<String> names) {
        pln("#m07(): names:" + names);
    }
    @GetMapping("/param5")
    public void m08(@RequestParam String[] names) {
        pln("#m08(): names: " + names);
        for(String name:names) pln("name: "+ name);
    }
    @GetMapping("/param6")
    public void m09(HumanList list) {
        pln("#m09()list: " + list);

    }
    @GetMapping("/param7")
    public void m10(Human dto, @RequestParam int page) {
        pln("#m10() dto: " + dto + ", page: " + page);
    }
    @RequestMapping("/param8")
    public void m11(ToDo dto) {
        pln("#m11() - dto: " + dto);

        Date d = dto.getCdate();
        Calendar c  = Calendar.getInstance();
        c.setTime(d);

        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1;
        int dt = c.get(Calendar.DAY_OF_MONTH);
        int h = c.get(Calendar.HOUR);
        int mi = c.get(Calendar.MINUTE);
        int s = c.get(Calendar.SECOND);

        pln(y + "년 " + m + "월 " + dt + "일 "+ h + ":"+mi+":" + s);
    }
    @GetMapping("/json1")
    public ResponseEntity<String> m12() {
        String msg = "{\"name\":\"홍길동\", \"age\":20}"; //JSON
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=utf-8");

        return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
    }
    @GetMapping("/json2")
    public @ResponseBody Human m13(){
        Human man = new Human("강감찬", 50);
        return man;
    }
    void pln(String str){
        System.out.println(str);
    }
}
