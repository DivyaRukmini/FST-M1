from threading import Thread
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as ExpectedConditions
from selenium.webdriver.support.wait import WebDriverWait


#create WebDriver instance
with webdriver.Firefox() as driver:

    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)

    #Open Webpage
    driver.get("http://alchemy.hguy.co/orangehrm")

    #check for the title
    pageTitle = driver.title
    print("Title of the page is " + pageTitle)

    # enter credentials : username and password
    driver.find_element(By.XPATH, "//*[@id=\"txtUsername\"]").send_keys("orange")
    driver.find_element(By.XPATH, "//*[@id=\"txtPassword\"]").send_keys("orangepassword123")
	
	#click submit button
    driver.find_element(By.XPATH, "//*[@id=\"btnLogin\"]").click()
    
    # Verify that the “Directory” menu item is visible and clickable
    print("“Directory” menu item is visible : " , driver.find_element(By.XPATH, "//a[@id='menu_directory_viewDirectory']").is_displayed())
    print("“Directory” menu item is clickable : " , driver.find_element(By.XPATH, "//a[@id='menu_directory_viewDirectory']").is_enabled())

    driver.find_element(By.XPATH, "//a[@id='menu_directory_viewDirectory']").click()
    print("Clicked on Directory tab")
    directory = driver.find_element(By.XPATH, "//*[@id=\"content\"]/div[1]/div[1]/h1").text
    print("You are on " , directory)

    #close the browser
    driver.quit()