from selenium import webdriver
from selenium.webdriver.common.by import By

#create WebDriver instance
with webdriver.Firefox() as driver:

    #Open Webpage
    driver.get("http://alchemy.hguy.co/orangehrm")

    #check for the header
    header = driver.find_element(By.TAG_NAME, "img").get_attribute("src")
    print("Image header url is " + header)
	
    
    #close the browser
    driver.quit()