from selenium import webdriver
from selenium.webdriver.common.by import By

#create WebDriver instance
with webdriver.Firefox() as driver:

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
    
    # HomePage Title
    homePageTitle = driver.title
    print("Home Page title is", homePageTitle)

	#Print the confirmation message
    message = driver.find_element(By.TAG_NAME, "h1")
    print("You are on", message.text)
    
    #close the browser
    driver.quit()