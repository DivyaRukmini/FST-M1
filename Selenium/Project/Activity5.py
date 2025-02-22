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

    #click on edit 
    driver.find_element(By.XPATH, "//input[@id='btnSave']").click()

    #Update Name, Gender and the DOB fields.
    driver.find_element(By.ID, "personal_txtEmpFirstName").clear()
    driver.find_element(By.ID, "personal_txtEmpFirstName").send_keys("Divya Rukmini")

    driver.find_element(By.ID, "personal_txtEmpLastName").clear()
    driver.find_element(By.ID, "personal_txtEmpLastName").send_keys("Mohan Raj")

    driver.find_element(By.ID, "personal_optGender_2").click()

    driver.find_element(By.ID, "personal_DOB").clear()
    driver.find_element(By.ID, "personal_DOB").send_keys("1993-03-18")

    driver.find_element(By.XPATH, "//input[@id='btnSave']").click()
    print("Information Updated successfully.")


    wait.until(ExpectedConditions.visibility_of(driver.find_element(By.ID, "personal_txtEmpFirstName")))

    print("Updated First Name : " , driver.find_element(By.ID, "personal_txtEmpFirstName").get_attribute("value"))
    print("Updated Last Name : " , driver.find_element(By.ID, "personal_txtEmpLastName").get_attribute("value"))
    print("Updated Gender : " , driver.find_element(By.ID, "personal_optGender_2").is_selected())
    print("Updated DOB : " , driver.find_element(By.ID, "personal_DOB").get_attribute("value"))

    #close the browser
    driver.quit()