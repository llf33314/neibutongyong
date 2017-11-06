package com.gt.inside;

import com.gt.inside.api.util.excel.ExcelUtil;
import com.gt.inside.bean.PFMDto;
import com.gt.inside.bean.WebDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by psr on 2017/11/6 0006.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ExportExcelTest {

    @Test
    public void test() throws Exception {
        List<WebDto> list = new ArrayList<WebDto>();
        list.add(new WebDto("知识林", "http://www.zslin.com", "admin", "111111", 555));
        list.add(new WebDto("权限系统", "http://basic.zslin.com", "admin", "111111", 111));
        list.add(new WebDto("校园网", "http://school.zslin.com", "admin", "222222", 333));

        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "网站信息表");
        map.put("total", list.size()+" 条");
        map.put("date", getDate());

        ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "web-info-template.xls", new FileOutputStream("F:/dev/out.xls"),
                list, WebDto.class, true);
    }

    @Test
    public void testPfm() throws Exception {
        List<PFMDto> list = new ArrayList<>();
        PFMDto pfmDto1 = new PFMDto();
        pfmDto1.setGzyj("1、制定工作计划；2、完成工作任务；3、招聘人员’5、开发定制小公园");
        pfmDto1.setIndex(1);
        pfmDto1.setJb("P1-1");
        pfmDto1.setLevel("K2");
        pfmDto1.setName("赵一");
        pfmDto1.setZw("研发工程师");

        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "技术/专业类员工2017年10月份绩效评定表");
        map.put("department", "惠州研发事业部");

        ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "performance-template.xls", new FileOutputStream("F:/dev/pfmOut.xls"),
                list, PFMDto.class, true);
    }

    private String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(new Date());
    }

}
