package com.cybertek.tests.d18_data_driven_testing;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

public class ExcelUtilityDemo {

    @Test
    public void readExcelTest(){

        // create an instance of the excel utility
        // argument 1: location of the file
        // argument 2: sheet we want to open
        ExcelUtil qa1Short = new ExcelUtil("src/test/resources/Vytrack testusers.xlsx", "QA3-all");

    }

}


