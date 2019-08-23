package com.dx.test;

import com.dx.util.DateToWordUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * Description: com.dx.test
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GetWordTest {


    @Autowired
    private DateToWordUtil dateToWordUtil;

    @Test
    public void testTeacherMapper() throws Exception {

        List<Map<String, Object>> table = null;

        try {
            table = dateToWordUtil.getTbaleList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        dateToWordUtil.toWord(table);
    }

}
