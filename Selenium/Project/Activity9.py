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

    #Click on Emergency Contacts
    driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a").click()
    print("Clicked on Emergency Contacts")

    #Retrieve and Print all the information to the console

    #Find the number of columns from header in the table and print them.
    cols = driver.find_elements(By.XPATH, "/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/thead/tr/th")
    print("total number of columns in header: " , len(cols))

    #Find the number of rows in the table and print them. 
    row = driver.find_elements(By.XPATH, "/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr")
    print("total number of rows : " , len(row))

    for i in range(1, len(row)+1) :

        #Find and print all the cell values in the first row of the table.
        path =  "/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr[" + str(i) + "]"
        rowData = driver.find_elements(By.XPATH, path)

        print(i , " row cell values: ")
        for cell in rowData:
            print(cell.text)

    #close the browser
    driver.quit()