from selenium import webdriver
from selenium.webdriver.common.by import By

#create WebDriver instance
with webdriver.Firefox() as driver:

    #Open Webpage
    driver.get("http://alchemy.hguy.co/orangehrm")

    #check for the title
    pageTitle = driver.title
    print("Title of the page is " + pageTitle)

    if driver.title == "OrangeHRM" :
        print("You are on " + driver.title + " website.")
    else :
        print("Incorrect Website")
	
    
    #close the browser
    driver.quit()