package com.gt.inside;

import com.gt.inside.api.util.excel.ExcelUtil;
import com.gt.inside.core.bean.function.performance.dto.PfmExcelDto;
import com.gt.inside.bean.WebDto;
import com.psr.tool.agile.AnalyticClass;
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
    public void testPfmNew() throws Exception {
        List<PfmExcelDto> list = new ArrayList<>();
        PfmExcelDto pfmExcelDto = new PfmExcelDto();
        AnalyticClass<PfmExcelDto> analyticClass = new AnalyticClass<>();
        list = analyticClass.buildList(PfmExcelDto.class, 5);

        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "技术/专业类员工2017年10月份绩效评定表");
        map.put("department", "惠州研发事业部");

        map.put("devNum", "11");
        map.put("devK1Num", "2");
        map.put("devK2Num", "4");
        map.put("devK3Num", "4");
        map.put("devK4Num", "1");

        map.put("majorNum", "5");
        map.put("majorK1Num", "1");
        map.put("majorK2Num", "1");
        map.put("majorK3Num", "2");
        map.put("majorK4Num", "1");

        ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "performance-template.xls", new FileOutputStream("E:/dev/pfmOut.xls"),
                list, PfmExcelDto.class, true);
    }

    private String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(new Date());
    }

}
