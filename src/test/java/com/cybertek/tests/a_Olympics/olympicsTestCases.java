package com.cybertek.tests.a_Olympics;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @author Nurgeldi
 * Note: Change the configuration file as needed for this project.
 */
public class olympicsTestCases extends TestBase {

    /**
     * 1. Verify that by default the Medal table is sorted by rank.
     * 2. Verify that the table is now sorted by the country names.
     * 3. Verify that Rank column is not in ascending order anymore,
     * */
    @Test
    public void test1() {
        List<WebElement> rankElements1 = driver.findElements(By.xpath("//table[9]//td[1]"));
        List<Integer> actualRanks1 = new ArrayList<>();

        for(int i=0; i<10; i++){
            actualRanks1.add(Integer.parseInt(rankElements1.get(i).getText()));
        }

        List<Integer> expectedRanks = new ArrayList<>(actualRanks1);
        Collections.sort(expectedRanks);

        Assert.assertEquals(actualRanks1, expectedRanks); // 1 Verification

        //________________________________________________________________

        driver.findElement(By.xpath("//th[.='NOC']")).click();

        List<WebElement> countries = driver.findElements(By.xpath("//table[9]/tbody//th"));
        List<String> countriesStr = BrowserUtils.getElementsText(countries);

        for (int i = 0; i < countriesStr.size()-1; i++) {
            String country1 = countriesStr.get(i);
            String country2 = countriesStr.get(i+1);

            Assert.assertTrue(country1.compareTo(country2) < 0); // 2 Verification
        }

        //________________________________________________________________
        // Come back to this to find the most efficient way to approach



//        List<WebElement> rankElements2 = driver.findElements(By.xpath("//table[9]//td[1]"));
//        List<Integer> actualRanks2 = new ArrayList<>();
//
//        for(int i=0; i<10; i++){
//            actualRanks2.add(Integer.parseInt(rankElements1.get(i).getText()));
//        }
//
//        Assert.assertNotEquals(actualRanks2, expectedRanks);

    }


    /**
     * The followings are Test Cases 2 - 5
     */

    @Test (description = "the first from the bottom")
    public void tc2FirstFromBottomTest(){
        Assert.assertEquals(getCountryWithLeastGold(), " Italy (ITA)");
        Assert.assertEquals(getCountryWithLeastSilver(), " South Korea (KOR)");
        Assert.assertEquals(getCountryWithLeastBronze()," Italy (ITA)");
    }

    /**
     * country with the smallest number of gold medals.
     * @return country
     */
    private String getCountryWithLeastGold() {

        driver.findElement(By.xpath("//table[9]//th[3]")).click();
        List<WebElement> countries = driver.findElements(By.xpath("//table[9]/tbody//th"));
        List<String> countriesStr = BrowserUtils.getElementsText(countries);

        return countriesStr.get(0);
    }

    /**
     * country with the smallest number of silver medals.
     * @return country
     */
    private String getCountryWithLeastSilver() {

        driver.findElement(By.xpath("//table[9]//th[4]")).click();
        List<WebElement> countries = driver.findElements(By.xpath("//table[9]/tbody//th"));
        List<String> countriesStr = BrowserUtils.getElementsText(countries);

        return countriesStr.get(0);

    }

    /**
     * country with the smallest number of bronze medals.
     * @return country
     */

    private String getCountryWithLeastBronze(){
        driver.findElement(By.xpath("//table[9]//th[5]")).click();
        List<WebElement> countries = driver.findElements(By.xpath("//table[9]/tbody//th"));
        List<String> countriesStr = BrowserUtils.getElementsText(countries);

        return countriesStr.get(0);
    }

    @Test(description = "country by medal")
    public void tc3CountryByMedalTest(){

        List<String> expected = Arrays.asList(" South Korea (KOR)", " Japan (JPN)", " Germany (GER)", " Australia (AUS)", " Italy (ITA)", " Russia (RUS)", " China (CHN)"," France (FRA)"," Great Britain (GBR)"," United States (USA)");

        Assert.assertEquals(getCountriesBySileverCount(), expected);
    }

    private List<String> getCountriesBySileverCount(){
        driver.findElement(By.xpath("//table[9]//th[4]")).click();
        List<WebElement> countries = driver.findElements(By.xpath("//table[9]/tbody//th"));
        List<String> countriesStr = BrowserUtils.getElementsText(countries);

        return countriesStr;
    }

    @Test(description = "get index")
    public void tc4GetIndexTest(){
        String countryName = " Japan (JPN)";
        int[] expected = new int[]{6,2};
        Assert.assertEquals(getRowColumnOfCountry(countryName), expected);

    }

    private int[] getRowColumnOfCountry(String country){
        List<WebElement> countries = driver.findElements(By.xpath("//table[9]/tbody//th"));
        List<String> countriesStr = BrowserUtils.getElementsText(countries);
        if(!countriesStr.contains(country)) return new int[]{-1,-1};

        int row = countriesStr.indexOf(country);
        return new int[]{row+1,2};


    }

    @Test(description = "get sum")
    public void tc5GetSumTest(){

        List<String> expected = Arrays.asList(" Italy (ITA)"," Australia (AUS)");
        Assert.assertEquals(getSumOfBronze(),expected);

    }

    private List<String> getSumOfBronze(){
        List<WebElement> bronzeColumn = driver.findElements(By.xpath("//table[9]/tbody//tr/td[4]"));
        List<WebElement> countries = driver.findElements(By.xpath("//table[9]/tbody//th"));

        List<Integer>  bronzeCount = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            bronzeCount.add(Integer.parseInt(bronzeColumn.get(i).getText()));
        }

        // Making it BigOn^2 since this array is small
        // However for big arrays find alternative way such as BST
        for (int i = 0; i < 10; i++) {
            for (int j = i+1; j < 10; j++) {

                if(bronzeCount.get(i) + bronzeCount.get(j) == 18){
                    result.add(countries.get(i).getText());
                    result.add(countries.get(j).getText());
                }

            }
        }
        return result;
    }



}
