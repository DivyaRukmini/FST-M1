from threading import Thread
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains
from selenium.webdriver.support import expected_conditions as ExpectedConditions
from selenium.webdriver.support.wait import WebDriverWait


#create WebDriver instance
with webdriver.Firefox() as driver:

    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)

    builder = ActionChains(driver)

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
    
    #Find the “My Info” menu item and click it.
    info = driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewMyDetails\"]")

    builder.move_to_element(info).pause(5).click(info).pause(5).perform()

    print("Clicked on My Info tab")

    myInfo = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[2]/div[1]/h1").text
    print("You are on " , myInfo)

    #Add Qualification.
    driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[1]/ul/li[9]/a").click()
    print("Clicked on Qualifications tab")

    #Add Work Experience
    driver.find_element(By.XPATH, "//input[@id='addWorkExperience']").click()
    print("Clicked on add Work Experience")

    Exp = driver.find_element(By.CSS_SELECTOR, "div[id='changeWorkExperience'] div[class='head']").text
    print("You are on " + Exp)

    driver.find_element(By.ID, "experience_employer").clear()
    driver.find_element(By.ID, "experience_employer").send_keys("DR Test Company")

    driver.find_element(By.ID, "experience_jobtitle").clear()
    driver.find_element(By.ID, "experience_jobtitle").send_keys("QA")

    driver.find_element(By.ID, "experience_comments").clear()
    driver.find_element(By.ID, "experience_comments").send_keys("QA Work Experience added.")

    driver.find_element(By.XPATH, "//input[@id='btnWorkExpSave']").click()
    print("Work experience added successfully.")

    #close the browser
    driver.quit()