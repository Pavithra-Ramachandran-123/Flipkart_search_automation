package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {
    ChromeDriver driver;
    
    String url="http://www.flipkart.com";
    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @Test
    public void testCase01() throws InterruptedException{
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("start of testCase01");
        driver.get("http://www.flipkart.com/");
        WebElement searchBox= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        searchBox.sendKeys("Washing Machine");
        searchBox.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        //System.out.println(searchBox.getDomAttribute("value").contains("Washing Machine"));
        // Actions actions = new Actions(driver);
        // actions.sendKeys(searchBox, "iPhone").sendKeys(Keys.ENTER).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Popularity']")));
        WebElement popularitySort= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Popularity']")));
        popularitySort.click();
        Thread.sleep(1000);
        List<WebElement> productRatings=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='_75nlfW']")));
        int sumOfPdtwithLessThanFourRating=0;
        for(WebElement pr:productRatings){
            
            WebElement rating=pr.findElement(By.xpath(".//div[@class='XQDdHH' and text()]"));
            //System.out.println(rating.getText());
            //System.out.println(pr.getText());
            double r=Double.parseDouble(rating.getText());
            //System.out.println(r+"\n");
            if(r<=4){
                sumOfPdtwithLessThanFourRating++; 
            }
        }
        System.out.println("Count of Products with rating <= 4 : "+sumOfPdtwithLessThanFourRating);
        System.out.println("end of testCase01");
        Thread.sleep(1000);
    }

    @Test
    public void testCase02() throws InterruptedException{
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("start of testCase02");
        driver.get("http://www.flipkart.com/");
        driver.navigate().refresh();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        WebElement searchBox= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        searchBox.sendKeys("iPhone");
        searchBox.sendKeys(Keys.ENTER);
        //System.out.println(searchBox.getDomAttribute("value").contains("iphone"));
        // Actions actions = new Actions(driver);
        // actions.sendKeys(searchBox, "iPhone").sendKeys(Keys.ENTER).build().perform();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='_75nlfW']")));
        List<WebElement> productList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='_75nlfW']")));
        Thread.sleep(1000);
        for(WebElement pr:productList){
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='UkUFwK' and text()]")));
            WebElement discountPercentage=pr.findElement(By.xpath(".//div[@class='UkUFwK']"));
            WebElement productTitle=pr.findElement(By.xpath(".//div[@class='KzDlHZ' and text()]"));
            int percentInt=Integer.parseInt(discountPercentage.getText().replaceAll("[^0-9]",""));
            if(percentInt>17){
                System.out.println(productTitle.getText()+" "+discountPercentage.getText());
            }
        }
        Thread.sleep(1000);
        System.out.println("end of testCase02");
    }

    @Test
    public void testCase03() throws InterruptedException{
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("start of testCase03");
        driver.get("http://www.flipkart.com/");
        driver.navigate().refresh();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        WebElement searchBox= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
        searchBox.sendKeys("Coffee Mug");
        searchBox.sendKeys(Keys.ENTER);
        //System.out.println(searchBox.getDomAttribute("value").contains("Coffee Mug"));
        // Actions actions = new Actions(driver);
        // actions.sendKeys(searchBox, "iPhone").sendKeys(Keys.ENTER).build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='4★ & above']")));
        WebElement fournAboveFilter= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='4★ & above']")));
        fournAboveFilter.click();
        Thread.sleep(3000);
        // List<WebElement> productList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("wjcEIp")));
    
        // for(int i=1;i<=5;i++){
        //     //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='UkUFwK' and text()]")));
        //     String productTitle=productList.get(i).getDomAttribute("title");
        //     String imgUrl=productList.get(i).getDomAttribute("href");
        //     //WebElement discountPercentage=pr.findElement(By.xpath(".//div[@class='UkUFwK']"));
        //     //WebElement productTitle=pr.findElement(By.xpath(".//div[@class='KzDlHZ' and text()]"));
        //     System.out.println("Title : "+productTitle);
        //     System.out.println("Product Image url : "+url+imgUrl+"\n");
        // }
        // System.out.println("end of testCase03");

        List<WebElement> productElements = driver.findElements(By.cssSelector(".slAVV4"));

            // Create a list to hold product info
            List<Product> products = new ArrayList<>();

            // Iterate through each product element
            for (WebElement productElement : productElements) {
                
                    String title = productElement.findElement(By.cssSelector("a.wjcEIp")).getDomAttribute("title");

                    // Get the image URL
                    String imageUrl = productElement.findElement(By.cssSelector("img.DByuf4")).getDomAttribute("src");

                    // Get the number of reviews
                    String reviewsText = productElement.findElement(By.cssSelector(".Wphh3N")).getText();
                    int reviewsCount = Integer.parseInt(reviewsText.replaceAll("[^0-9]", ""));

                    // Add the product to the list
                    products.add(new Product(title, imageUrl, reviewsCount));
                } 
            
            products.sort(Comparator.comparingInt(Product::getReviews).reversed());

            // Print the top 5 products
            for (int i = 0; i < Math.min(5, products.size()); i++) {
                Product product = products.get(i);
                System.out.println("Title: " + product.getTitle());
                System.out.println("Image URL: " + product.getImageUrl());
                System.out.println("Reviews: " + product.getReviews());
                System.out.println("---------------");
            }
            Thread.sleep(1000);
            
    }
     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}
